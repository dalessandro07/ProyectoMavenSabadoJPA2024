package controlador;

import java.io.IOException;
import java.util.List;

import dao.ClassClienteImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
      String action = request.getParameter("action");
      String idParam = request.getParameter("id");

      if (action != null && idParam != null && "edit".equalsIgnoreCase(action)) {
        int id = Integer.parseInt(idParam);
        ClassClienteImp crud = new ClassClienteImp();

        TblCliente cliente = new TblCliente();
        cliente.setIdcliente(id);
        cliente = crud.BuscarCliente(cliente);

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/FormActualizarCliente.jsp").forward(request, response);
      } else {
        ClassClienteImp crud = new ClassClienteImp();
        List<TblCliente> clientes = crud.ListadoCliente();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("/listadoClientes.jsp").forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("errorMessage", "Ha ocurrido un error inesperado: " + e.getMessage());
      response.sendRedirect("error.jsp");
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String idParam = request.getParameter("id");
      String action = request.getParameter("action");

      // Recuperamos los datos del cliente del formulario
      String nombres = request.getParameter("nombres");
      String apellidos = request.getParameter("apellidos");
      String email = request.getParameter("email");
      String dni = request.getParameter("dni");
      String telefono = request.getParameter("telefono");
      String sexo = request.getParameter("sexo");
      String nacionalidad = request.getParameter("nacionalidad");

      // Completamos el cliente con los datos capturados
      TblCliente cliente = new TblCliente();

      cliente.setNombre(nombres);
      cliente.setApellido(apellidos);
      cliente.setEmail(email);
      cliente.setDni(dni);
      cliente.setTelefono(telefono);
      cliente.setSexo(sexo);
      cliente.setNacionalidad(nacionalidad);

      // Creamos el CRUD
      ClassClienteImp crud = new ClassClienteImp();

      if (action != null) {
        switch (action) {
        case "delete":
          if (idParam != null) {
            int id = Integer.parseInt(idParam);
            cliente.setIdcliente(id);
            cliente = crud.BuscarCliente(cliente);
            request.setAttribute("clienteEliminado", cliente);

            crud.EliminarCliente(cliente);
          }
          break;
        case "edit":
          if (idParam != null && !idParam.isEmpty()) {
            // Capturamos el id del cliente a actualizar
            int id = Integer.parseInt(idParam);
            cliente.setIdcliente(id);

            // Actualizar el cliente
            crud.ActualizarCliente(cliente);
          }
          break;
        case "new":
          // Registrar nuevo cliente
          crud.RegistrarCliente(cliente);
          break;
        default:
          break;
        }
      }

      // Redireccionamos al listado
      request.getRequestDispatcher("/listadoClientes.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("errorMessage", "Ha ocurrido un error inesperado: " + e.getMessage());
      response.sendRedirect("error.jsp");
    }
  }

}
