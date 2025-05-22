package ventacomida.ProyectoPrograIII.services;

import ventacomida.ProyectoPrograIII.entity.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {

    List<DetalleVenta> listarTodos();
    DetalleVenta guardar(DetalleVenta detalleVenta);
    DetalleVenta obtenerPorId(Integer id);
    void eliminar(Integer id);
}
