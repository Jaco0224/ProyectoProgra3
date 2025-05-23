package ventacomida.ProyectoPrograIII.impl;

import jakarta.transaction.Transactional;
import ventacomida.ProyectoPrograIII.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.repository.VentaRepository;
import ventacomida.ProyectoPrograIII.services.VentaService;

import java.util.List;
import ventacomida.ProyectoPrograIII.entity.DetalleVenta;
import ventacomida.ProyectoPrograIII.repository.DetalleVentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta obtenerPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
    ventaRepository.deleteById(id);
    }
    
    @Transactional
public Venta registrarVentaConDetalles(Venta venta, List<DetalleVenta> detalles) {
    Venta ventaGuardada = ventaRepository.save(venta);

    for (DetalleVenta detalle : detalles) {
        detalle.setVenta(ventaGuardada);
        detalleVentaRepository.save(detalle);
    }

    return ventaGuardada;
}

   /* @Override
    public void registrarVenta(Venta venta, List<DetalleVenta> detalles) {
    Venta ventaGuardada = ventaRepository.save(venta);

    for (DetalleVenta detalle : detalles) {
        detalle.setVenta(ventaGuardada);
        detalleVentaRepository.save(detalle);
    }
    
    }*/
    
    @Override
    public Venta registrarVenta(Venta venta, List<DetalleVenta> detalles) {
    Venta ventaGuardada = ventaRepository.save(venta);
    
    for (DetalleVenta d : detalles) {
        d.setVenta(ventaGuardada);
        detalleVentaRepository.save(d);
    }

    return ventaGuardada;
}





    
}
