/**
 * 
 */
package dao;

import java.util.List;

import interfaces.ICliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.TblCliente;

/**
 * 
 */
public class ClassClienteImp implements ICliente {

  private String persistenceUnitName = "ProyectoMavenSabadoJPA";

  @Override
  public void RegistrarCliente(TblCliente cliente) {
    try {
      // Establecer la conexión con la unidad de persistencia
      EntityManagerFactory fabr = Persistence.createEntityManagerFactory(persistenceUnitName);

      // Gestionar las entidades
      EntityManager em = fabr.createEntityManager();

      // Iniciamos la transacción
      em.getTransaction().begin();

      // Registramos
      em.persist(cliente);

      // Emitimos mensaje por consola
      System.out.println("Cliente registrado en la BD.");

      // Confirmamos
      em.getTransaction().commit();

      // Cerramos
      em.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void ActualizarCliente(TblCliente cliente) {
    try {
      // Establecer la conexión con la unidad de persistencia
      EntityManagerFactory fabr = Persistence.createEntityManagerFactory(persistenceUnitName);

      // Gestionar las entidades
      EntityManager em = fabr.createEntityManager();

      // Iniciamos la transacción
      em.getTransaction().begin();

      // Registramos
      em.merge(cliente);

      // Emitimos mensaje por consola
      System.out.println("Cliente actualizado en la BD.");

      // Confirmamos
      em.getTransaction().commit();

      // Cerramos
      em.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Override
  public void EliminarCliente(TblCliente cliente) {
    try {
      // Establecer la conexión con la unidad de persistencia
      EntityManagerFactory fabr = Persistence.createEntityManagerFactory(persistenceUnitName);

      // Gestionar las entidades
      EntityManager em = fabr.createEntityManager();

      // Iniciamos la transacción
      em.getTransaction().begin();

      // Recuperamos el codigo a eliminar
      TblCliente clienteAEliminar = em.merge(cliente);

      // Procedemos a eliminar
      em.remove(clienteAEliminar);

      // Emitimos mensaje por consola
      System.out.println("Cliente eliminado de la BD.");

      // Confirmamos
      em.getTransaction().commit();

      // Cerramos
      em.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Override
  public TblCliente BuscarCliente(TblCliente cliente) {
    try {
      // Establecer la conexión con la unidad de persistencia
      EntityManagerFactory fabr = Persistence.createEntityManagerFactory(persistenceUnitName);

      // Gestionar las entidades
      EntityManager em = fabr.createEntityManager();

      // Iniciamos la transacción
      em.getTransaction().begin();

      // Recuperamos el código a buscar
      TblCliente buscarCliente = em.find(TblCliente.class, cliente.getIdcliente());

      // Confirmamos
      em.getTransaction().commit();

      // Cerramos
      em.close();

      // Retornamos el cliente buscado de la BD
      return buscarCliente;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public List<TblCliente> ListadoCliente() {
    try {
      // Establecer la conexión con la unidad de persistencia
      EntityManagerFactory fabr = Persistence.createEntityManagerFactory(persistenceUnitName);

      // Gestionar las entidades
      EntityManager em = fabr.createEntityManager();

      // Iniciamos la transacción
      em.getTransaction().begin();

      // Recuperamos el listado de usuarios de la base de datos
      /*
       * Aplicamos consultas JPQL (JPA Query Language), el método createQuery() sirve para hacer consultas dinámicas
       */
      List<TblCliente> listado = em.createQuery("SELECT c FROM TblCliente c", TblCliente.class).getResultList();

      // Confirmamos
      em.getTransaction().commit();

      // Cerramos
      em.close();

      // Retornamos el listado de clientes de la BD
      return listado;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

}
