package interfaces;

import java.util.List;

import model.TblProducto;

public interface IProducto {
  // Declaramos los métodos
  public void RegistrarProducto(TblProducto producto);

  public void ActualizarProducto(TblProducto producto);

  public void EliminarProducto(TblProducto producto);

  public TblProducto BuscarProducto(TblProducto producto);

  public List<TblProducto> ListadoProducto(TblProducto producto);
}
