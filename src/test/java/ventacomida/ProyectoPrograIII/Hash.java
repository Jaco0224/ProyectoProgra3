/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventacomida.ProyectoPrograIII;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Hash {
    
     public static void main(String[] args) {
        String usuario = "Allan";
        String contrasena = "4321";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(contrasena);

        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña en texto plano: " + contrasena);
        System.out.println("Contraseña encriptada (hash): " + hash);
    }
    
}
