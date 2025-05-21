package ventacomida.ProyectoPrograIII.repository;

import ventacomida.ProyectoPrograIII.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByUsuario(String usuario);
    
}


