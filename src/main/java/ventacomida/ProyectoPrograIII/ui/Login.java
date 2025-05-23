/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventacomida.ProyectoPrograIII.ui;

import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ventacomida.ProyectoPrograIII.entity.Usuario;
import ventacomida.ProyectoPrograIII.impl.ProductoServiceImpl;
import ventacomida.ProyectoPrograIII.impl.VentaServiceImpl;
import ventacomida.ProyectoPrograIII.services.ProductoService;
import ventacomida.ProyectoPrograIII.services.UsuarioService;
import ventacomida.ProyectoPrograIII.services.VentaService;

/**
 *
 * @author jc039
 */


public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    
    
    /**
     * Creates new form Login
     */
    
    private final UsuarioService usuarioService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProductoService productoService;
    private final VentaService ventaService;
   
    @Autowired
   
    public Login(UsuarioService usuarioService, BCryptPasswordEncoder passwordEncoder, ProductoService productoService, VentaService ventaService) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.productoService = productoService;
        this.ventaService = ventaService;

   
        initComponents();
        setLocationRelativeTo(null);
        
        btnLogin.addActionListener(e -> {
        String usuario = txtUsuario.getText();
        String contraseña = new String(txtpassword.getPassword());

        autenticarDesdeSwing(usuario, contraseña);
});
        

        
        
    }

    public void autenticarDesdeSwing(String usuario, String contraseña) {
            Usuario usuarioObj = usuarioService.buscarPorUsuario(usuario);

    if (usuarioObj != null && passwordEncoder.matches(contraseña, usuarioObj.getContraseña())) {
        JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");

            String rol = usuarioObj.getRole().toUpperCase(); // normalizar

            if ("ROLE_ADMIN".equals(rol) || "ADMINISTRADOR".equals(rol)) {
                new VentanaAdmin().setVisible(true);
            } else if ("ROLE_VENDEDOR".equals(rol) || "VENDEDOR".equals(rol)) {
                new MenuVendedor(productoService, ventaService, usuarioObj).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Rol desconocido: " + rol);
            }
        this.dispose(); // Cierra la ventana Login

    } else {
        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
    }
    }
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 56, -1));

        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 136, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 240, -1));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 253, -1));

        btnLogin.setText("Ingresar");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        

        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    
   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
