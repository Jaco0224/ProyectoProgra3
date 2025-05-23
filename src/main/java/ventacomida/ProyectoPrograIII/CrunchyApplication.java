package ventacomida.ProyectoPrograIII;


import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ventacomida.ProyectoPrograIII.config.AppConfig;
import ventacomida.ProyectoPrograIII.entity.Usuario;
import ventacomida.ProyectoPrograIII.services.ProductoService;
import ventacomida.ProyectoPrograIII.services.UsuarioService;
import ventacomida.ProyectoPrograIII.services.VentaService;
import ventacomida.ProyectoPrograIII.ui.Login;

@SpringBootApplication
public class CrunchyApplication {

	public static void main(String[] args) {
             System.out.println("Headless mode: " + java.awt.GraphicsEnvironment.isHeadless());

           ConfigurableApplicationContext context = SpringApplication.run(CrunchyApplication.class, args);
           ProductoService productoService = context.getBean(ProductoService.class);
           VentaService ventaService = context.getBean(VentaService.class);
           UsuarioService usuarioService = context.getBean(UsuarioService.class);
           BCryptPasswordEncoder passwordEncoder = context.getBean(BCryptPasswordEncoder.class);
            
            
            
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
        //AuthenticationManager authManager = context.getBean(AuthenticationManager.class);
        
        
        
            java.awt.EventQueue.invokeLater(() -> {
            new Login(usuarioService, passwordEncoder, productoService,ventaService).setVisible(true);
        });
                

                      
                             
    }
                
	}


