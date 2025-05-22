package ventacomida.ProyectoPrograIII.impl;

import ventacomida.ProyectoPrograIII.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.repository.VentaRepository;
import ventacomida.ProyectoPrograIII.services.VentaService;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

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
}
