package ventacomida.ProyectoPrograIII.services;

import ventacomida.ProyectoPrograIII.entity.Venta;

import java.util.List;
import ventacomida.ProyectoPrograIII.entity.DetalleVenta;

public interface VentaService {

    List<Venta> listarTodos();
    Venta guardar(Venta venta);
    Venta obtenerPorId(Integer id);
    void eliminar(Integer id);
    
    Venta registrarVenta(Venta venta, List<DetalleVenta> detalles);
    
}
