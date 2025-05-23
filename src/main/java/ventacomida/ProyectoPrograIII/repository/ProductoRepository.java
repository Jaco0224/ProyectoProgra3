package ventacomida.ProyectoPrograIII.repository;

import java.util.Optional;
import ventacomida.ProyectoPrograIII.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    Optional <Producto> findByNombre(String nombre);
    
}
