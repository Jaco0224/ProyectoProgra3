package ventacomida.ProyectoPrograIII;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ventacomida.ProyectoPrograIII.ui.Login;

@SpringBootApplication
public class CrunchyApplication {

	public static void main(String[] args) {
             System.out.println("Headless mode: " + java.awt.GraphicsEnvironment.isHeadless());

        ConfigurableApplicationContext context = SpringApplication.run(CrunchyApplication.class, args);
         
        java.awt.EventQueue.invokeLater(() -> {
            Login login = context.getBean(Login.class);
            login.setVisible(true);
        });
                

                            
                             
    }
                
	}


