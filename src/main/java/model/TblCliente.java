package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the tbl_cliente database table.
 * 
 */
@Entity
@Table(name = "tbl_cliente")
@NamedQuery(name = "TblCliente.findAll", query = "SELECT t FROM TblCliente t")
public class TblCliente implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private int idcliente;

  private String apellido;

  private String dni;

  private String email;

  private String nacionalidad;

  private String nombre;

  private String sexo;

  private String telefono;

  public TblCliente() {
  }

  public int getIdcliente() {
    return this.idcliente;
  }

  public void setIdcliente(int idcliente) {
    this.idcliente = idcliente;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return this.dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNacionalidad() {
    return this.nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getSexo() {
    return this.sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getTelefono() {
    return this.telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

}