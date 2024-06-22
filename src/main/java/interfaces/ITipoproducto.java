package interfaces;

import java.util.List;

import model.TblTipoproducto;

public interface ITipoproducto {
  // Declaramos los métodos
  public void RegistrarTipoProducto(TblTipoproducto tipoProd);

  public void ActualizarTipoProducto(TblTipoproducto tipoProd);

  public void EliminarTipoProducto(TblTipoproducto tipoProd);

  public TblTipoproducto BuscarTipoProducto(TblTipoproducto tipoProd);

  public List<TblTipoproducto> ListadoTipoProducto(TblTipoproducto tipoProd);
}
