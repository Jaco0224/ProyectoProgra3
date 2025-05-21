package ventacomida.ProyectoPrograIII.services;

import ventacomida.ProyectoPrograIII.model.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> listarTodos();
    Venta guardar(Venta venta);
    Venta obtenerPorId(Integer id);
    void eliminar(Integer id);
}
