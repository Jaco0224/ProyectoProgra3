package ventacomida.ProyectoPrograIII.services;

import ventacomida.ProyectoPrograIII.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarTodos();
    Usuario guardar(Usuario usuario);
    Usuario obtenerPorId(Integer id);
    void eliminar(Integer id);
    
    

}
