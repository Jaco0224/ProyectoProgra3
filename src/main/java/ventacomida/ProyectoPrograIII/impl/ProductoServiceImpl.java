package ventacomida.ProyectoPrograIII.impl;

import ventacomida.ProyectoPrograIII.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.repository.ProductoRepository;
import ventacomida.ProyectoPrograIII.services.ProductoService;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
    
      @Override
    public Producto buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + nombre));
    }
}


