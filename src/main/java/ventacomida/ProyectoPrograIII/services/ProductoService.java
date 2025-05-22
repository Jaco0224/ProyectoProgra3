package ventacomida.ProyectoPrograIII.services;

import ventacomida.ProyectoPrograIII.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarTodos();

    Producto guardar(Producto producto);

    Producto obtenerPorId(Integer id);

    void eliminar(Integer id);
}
