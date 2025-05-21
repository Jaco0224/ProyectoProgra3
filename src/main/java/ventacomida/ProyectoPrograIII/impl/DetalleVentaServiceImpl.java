package ventacomida.ProyectoPrograIII.impl;

import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.model.DetalleVenta;
import ventacomida.ProyectoPrograIII.services.DetalleVentaService;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    @Override
    public List<DetalleVenta> listarTodos() {
        return List.of();
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return null;
    }

    @Override
    public DetalleVenta obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }
}
