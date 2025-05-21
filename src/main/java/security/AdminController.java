/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class AdminController {
    
     @GetMapping("/home")
    public String adminHome(Model model) {
        // Aquí puedes cargar el JasperReport, o una lista de ventas
        return "adminHome"; // Asegúrate que adminHome.html o .jsp exista
    }
    
}
