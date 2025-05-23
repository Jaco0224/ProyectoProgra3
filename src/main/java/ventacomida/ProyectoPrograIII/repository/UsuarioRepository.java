package ventacomida.ProyectoPrograIII.repository;

import java.util.Optional;
import ventacomida.ProyectoPrograIII.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional <Usuario> findByUsuario(String usuario);
    
    
    
}


