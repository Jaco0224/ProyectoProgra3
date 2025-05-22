package ventacomida.ProyectoPrograIII.repository;

import ventacomida.ProyectoPrograIII.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
