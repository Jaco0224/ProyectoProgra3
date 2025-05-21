package ventacomida.ProyectoPrograIII.impl;

import ventacomida.ProyectoPrograIII.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ventacomida.ProyectoPrograIII.repository.UsuarioRepository;
import ventacomida.ProyectoPrograIII.services.UsuarioService;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuariosServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
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
    
    
        //guarda usuario para el login
        public void guardarUsuario(Usuario usuario) {
        // encripta la contraseña antes de guardar
        usuario.setContraseña(encoder.encode(usuario.getContraseña()));
        usuarioRepository.save(usuario);
    }
    
    
}
