package testEntidades;

import dao.ClassClienteImp;
import model.TblCliente;

public class TestEntidadCliente {

  public static void main(String[] args) {
    // Realizamos la respectiva instancia de la clase
    TblCliente cliente = new TblCliente();
    ClassClienteImp crud = new ClassClienteImp();

    // Asignamos valores
    cliente.setNombre("Diego Alessandro");
    cliente.setApellido("Rios Villegas");
    cliente.setDni("75896412");
    cliente.setEmail("darv@gmail.com");
    cliente.setTelefono("956812335");
    cliente.setSexo("M");
    cliente.setNacionalidad("peruano");

    // Invocamos al método registrar
    crud.RegistrarCliente(cliente);

  }

}
