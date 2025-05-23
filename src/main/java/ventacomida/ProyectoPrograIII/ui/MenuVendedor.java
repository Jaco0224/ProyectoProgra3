/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventacomida.ProyectoPrograIII.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventacomida.ProyectoPrograIII.entity.DetalleVenta;
import ventacomida.ProyectoPrograIII.entity.Producto;
import ventacomida.ProyectoPrograIII.entity.Usuario;
import ventacomida.ProyectoPrograIII.entity.Venta;
import ventacomida.ProyectoPrograIII.services.ProductoService;
import ventacomida.ProyectoPrograIII.services.VentaService;
import ventacomida.ProyectoPrograIII.ui.Compras.ItemCarrito;

/**
 *
 * @author jc039
 */
public class MenuVendedor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuVendedor.class.getName());

    /**
     * Creates new form MenuVendedor
     */
    
    private DefaultTableModel modeloTabla;   
    private List<ItemCarrito> carrito;
    private final ProductoService productoService;
    private final Usuario usuarioActual;
    private final VentaService ventaService;
    private JButton btnVerFactura = new JButton("Ver Factura");
    private int ultimaVentaIdGenerada = -1;

    
    public MenuVendedor(ventacomida.ProyectoPrograIII.services.ProductoService productoService,VentaService ventaService, Usuario usuarioActual) {

        initComponents();
        setLocationRelativeTo(null);
        this.productoService = productoService;
        this.ventaService = ventaService;
        this.usuarioActual = usuarioActual;
        add(btnVerFactura); // Asegurate de que esté en el layout
        btnVerFactura.setEnabled(false); // Se activa solo después de registrar una venta

     
        carrito = new ArrayList<>();
    
        modeloTabla = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio"}, 0);
        tabla.setModel(modeloTabla);
        
        btnAgregarHotDog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAlCarrito("Hot Dog", 1, 15.00);
            }
         });
         
        btnAgregarSandwich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAlCarrito("Sandwich", 1, 20.00);
            }
         });
            
        btnAgregarHamburguesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAlCarrito("Hamburguesa", 1, 22.00);
            }
         });
            
        btnAgregarAgua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAlCarrito("Agua Pura", 1, 4.00);
            }
         });
            
        btnAgregarSoda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItemAlCarrito("Soda", 1, 5.00);
            }
         });
            
            
        btnGenerarVenta.addActionListener(e -> {
           int rowCount = tabla.getRowCount();
           if (rowCount == 0) {
               JOptionPane.showMessageDialog(null, "El carrito está vacío.");
               return;
           }

           BigDecimal total = BigDecimal.ZERO;
           List<DetalleVenta> detalles = new ArrayList<>();

           for (int i = 0; i < rowCount; i++) {
               String nombre = tabla.getValueAt(i, 0).toString();
               int cantidad = Integer.parseInt(tabla.getValueAt(i, 1).toString());
               BigDecimal precio = new BigDecimal(tabla.getValueAt(i, 2).toString());

               Producto p = productoService.buscarPorNombre(nombre);
               DetalleVenta d = new DetalleVenta();
               d.setProducto(p);
               d.setCantidad(cantidad);
               d.setPrecioUnitario(precio);
               d.setSubtotal(precio.multiply(BigDecimal.valueOf(cantidad)));

               total = total.add(d.getSubtotal());
               detalles.add(d);
           }

           Venta v = new Venta();
           v.setTotal(total);
           v.setFechaVenta(Instant.now());
           v.setUsuario(usuarioActual); 

           Venta ventaGuardada = ventaService.registrarVenta(v, detalles);
           ultimaVentaIdGenerada = ventaGuardada.getId(); // guarda ID para factura

            btnVerFactura.setEnabled(true);

           JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
           ((DefaultTableModel) tabla.getModel()).setRowCount(0); // limpiar tabla
       });  

            
            
             
            
            
        
    }
    
    private void actualizarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Limpia la tabla antes de volver a llenarla

    for (ItemCarrito item : carrito) {
        modelo.addRow(new Object[]{
            item.getNombre(),
            item.getCantidad(),
            item.getPrecio()
        });
    }
}
    
        private void agregarItemAlCarrito(String nombre, int cantidad, double precio) {
        ItemCarrito item = new ItemCarrito(nombre, cantidad, precio);
        carrito.add(item);
        modeloTabla.addRow(new Object[]{item.getNombre(), item.getCantidad(), item.getPrecio()});
    }
        
       
   
       
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarHotDog = new javax.swing.JButton();
        btnAgregarHamburguesa = new javax.swing.JButton();
        btnAgregarSandwich = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregarSoda = new javax.swing.JButton();
        btnAgregarAgua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnGenerarVenta = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Roboto", 3, 36)); // NOI18N
        jLabel2.setText("Menu");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\HotDogRedim.jpeg")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\SandwichPolloRedim.jpeg")); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\HamburguesaRedim.jpeg")); // NOI18N
        jLabel7.setText("jLabel7");

        btnAgregarHotDog.setText("Agregar");
        btnAgregarHotDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHotDogActionPerformed(evt);
            }
        });

        btnAgregarHamburguesa.setText("Agregar");

        btnAgregarSandwich.setText("Agregar");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\AguaPuraRedim.jpeg")); // NOI18N
        jLabel10.setText("jLabel10");

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\SodaRedim.jpeg")); // NOI18N
        jLabel11.setText("jLabel11");

        btnAgregarSoda.setText("Agregar");
        btnAgregarSoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSodaActionPerformed(evt);
            }
        });

        btnAgregarAgua.setText("Agregar");
        btnAgregarAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAguaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\jc039\\Desktop\\Tareas 2025\\Programacion III\\Images\\LogoCrunchyRedim.jpeg")); // NOI18N
        jLabel3.setText("jLabel3");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Opciones");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));

        btnGenerarVenta.setText("Generar Venta");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerarVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnGenerarVenta)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(114, 114, 114)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnAgregarHotDog)
                                        .addGap(145, 145, 145)
                                        .addComponent(btnAgregarSandwich)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAgregarHamburguesa)))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarSoda)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addComponent(btnAgregarAgua)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarHamburguesa)
                            .addComponent(btnAgregarHotDog)
                            .addComponent(btnAgregarSandwich))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarSoda)
                            .addComponent(btnAgregarAgua))
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarHotDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHotDogActionPerformed
        // TODO add your handling code here:
       /* btnAgregarHotDog.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        carrito.add(new ItemCarrito("Hot Dog", 1, 15)); // nombre, cantidad, precio
        actualizarTabla();
    }
});*/
       

        
    }//GEN-LAST:event_btnAgregarHotDogActionPerformed

    private void btnAgregarSodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSodaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarSodaActionPerformed

    private void btnAgregarAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAguaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAguaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAgua;
    private javax.swing.JButton btnAgregarHamburguesa;
    private javax.swing.JButton btnAgregarHotDog;
    private javax.swing.JButton btnAgregarSandwich;
    private javax.swing.JButton btnAgregarSoda;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
