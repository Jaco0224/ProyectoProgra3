package ventacomida.ProyectoPrograIII.impl;

import ventacomida.ProyectoPrograIII.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.repository.UsuarioRepository;
import ventacomida.ProyectoPrograIII.services.UsuarioService;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuariosServiceImpl implements UsuarioService {
    

    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
     usuario.setContraseña(encoder.encode(usuario.getContraseña()));
    return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
        
    
    @Override
   public Usuario buscarPorUsuario(String usuario) {
   return usuarioRepository.findByUsuario(usuario).orElse(null);
            
            
        }

    
    
    
        

        
      
    
    
}
