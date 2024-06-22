package controlador;

import java.io.IOException;
import java.util.List;

import dao.ClassClienteImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.internal.org.jline.utils.Log;
import model.TblCliente;

/**
 * Servlet implementation class ControladorCliente
 */
@WebServlet("/ControladorCliente")
public class ControladorCliente extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ControladorCliente() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ClassClienteImp crud = new ClassClienteImp();
      List<TblCliente> clientes = crud.ListadoCliente();
      request.setAttribute("clientes", clientes);
      request.getRequestDispatcher("/listadoClientes.jsp").forward(request, response);
    } catch (Exception e) {
      Log.debug(e.getMessage());
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Recuperamos los valores del formulario
      String nombres = request.getParameter("nombres");
      String apellidos = request.getParameter("apellidos");
      String email = request.getParameter("email");
      String dni = request.getParameter("dni");
      String telefono = request.getParameter("telefono");
      String sexo = request.getParameter("sexo");
      String nacionalidad = request.getParameter("nacionalidad");

      // Instanciar las respectivas entidades
      TblCliente cliente = new TblCliente();
      ClassClienteImp crud = new ClassClienteImp();

      // Asignar valores del formulario
      cliente.setNombre(nombres);
      cliente.setApellido(apellidos);
      cliente.setEmail(email);
      cliente.setDni(dni);
      cliente.setTelefono(telefono);
      cliente.setSexo(sexo);
      cliente.setNacionalidad(nacionalidad);

      // Registrar los datos
      crud.RegistrarCliente(cliente);

      // Redireccionamos
      List<TblCliente> clientes = crud.ListadoCliente();
      request.setAttribute("clientes", clientes);
      request.getRequestDispatcher("/listadoClientes.jsp").forward(request, response);

    } catch (Exception e) {
      Log.debug(e.getMessage() != null ? e.getMessage() : "Error desconocido.");
    }
  }

}
