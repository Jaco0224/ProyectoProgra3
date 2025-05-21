
package security;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class VendedorController {
    
        @GetMapping("/home")
    public String vendedorHome(Model model) {
        // Aquí puedes mostrar el menú del restaurante, etc.
        return "vendedorHome"; // Debes tener esta vista
    }
    
}
