package ventacomida.ProyectoPrograIII.repository;

import ventacomida.ProyectoPrograIII.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
