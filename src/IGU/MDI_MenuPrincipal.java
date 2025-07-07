
package IGU;


import java.awt.Color;
import javax.swing.JOptionPane;

public class MDI_MenuPrincipal extends javax.swing.JFrame {
    
    public MDI_MenuPrincipal() {
        initComponents();
        desktopPane.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jM_Productos = new javax.swing.JMenu();
        MI_Productos = new javax.swing.JMenuItem();
        MI_CategoriaProducto = new javax.swing.JMenuItem();
        MI_ActivosFijos = new javax.swing.JMenuItem();
        jM_Ventas = new javax.swing.JMenu();
        MI_RealizarVenta = new javax.swing.JMenuItem();
        MI_MetodoPago = new javax.swing.JMenuItem();
        MI_TablaVentas = new javax.swing.JMenuItem();
        jM_Caja1 = new javax.swing.JMenu();
        MI_Empleados = new javax.swing.JMenuItem();
        MI_Roles = new javax.swing.JMenuItem();
        jM_Clientes = new javax.swing.JMenu();
        MI_Clientes = new javax.swing.JMenuItem();
        jM_Reportes = new javax.swing.JMenu();
        MI_Reportes = new javax.swing.JMenuItem();
        jM_CerrarSesion = new javax.swing.JMenu();
        MI_CerrarSesion = new javax.swing.JMenuItem();
        MI_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 2));
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/logoGrande.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(50, 90, 540, 350);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/centro.png"))); // NOI18N
        desktopPane.add(jLabel2);
        jLabel2.setBounds(30, 200, 90, 90);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/centro.png"))); // NOI18N
        desktopPane.add(jLabel3);
        jLabel3.setBounds(550, 190, 90, 90);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/centro.png"))); // NOI18N
        desktopPane.add(jLabel4);
        jLabel4.setBounds(310, 0, 90, 90);

        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 2));

        jM_Productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_Productos.setMnemonic('e');
        jM_Productos.setText("Productos");

        MI_Productos.setMnemonic('t');
        MI_Productos.setText("Productos");
        MI_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ProductosActionPerformed(evt);
            }
        });
        jM_Productos.add(MI_Productos);

        MI_CategoriaProducto.setMnemonic('y');
        MI_CategoriaProducto.setText("Categorias_Productos");
        MI_CategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_CategoriaProductoActionPerformed(evt);
            }
        });
        jM_Productos.add(MI_CategoriaProducto);

        MI_ActivosFijos.setText("Activos Fijos");
        MI_ActivosFijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ActivosFijosActionPerformed(evt);
            }
        });
        jM_Productos.add(MI_ActivosFijos);

        menuBar.add(jM_Productos);

        jM_Ventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_Ventas.setText("Ventas");

        MI_RealizarVenta.setText("Realizar Venta");
        MI_RealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RealizarVentaActionPerformed(evt);
            }
        });
        jM_Ventas.add(MI_RealizarVenta);

        MI_MetodoPago.setText("Metodo de Pago");
        MI_MetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_MetodoPagoActionPerformed(evt);
            }
        });
        jM_Ventas.add(MI_MetodoPago);

        MI_TablaVentas.setText("Tabla Ventas");
        MI_TablaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_TablaVentasActionPerformed(evt);
            }
        });
        jM_Ventas.add(MI_TablaVentas);

        menuBar.add(jM_Ventas);

        jM_Caja1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_Caja1.setText("Empleados");

        MI_Empleados.setText("Empleados");
        MI_Empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_EmpleadosActionPerformed(evt);
            }
        });
        jM_Caja1.add(MI_Empleados);

        MI_Roles.setText("Roles");
        MI_Roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RolesActionPerformed(evt);
            }
        });
        jM_Caja1.add(MI_Roles);

        menuBar.add(jM_Caja1);

        jM_Clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_Clientes.setText("Clientes");

        MI_Clientes.setMnemonic('p');
        MI_Clientes.setText("Clientes");
        MI_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ClientesActionPerformed(evt);
            }
        });
        jM_Clientes.add(MI_Clientes);

        menuBar.add(jM_Clientes);

        jM_Reportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_Reportes.setText("Reportes");

        MI_Reportes.setMnemonic('p');
        MI_Reportes.setText("Reportes");
        MI_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ReportesActionPerformed(evt);
            }
        });
        jM_Reportes.add(MI_Reportes);

        menuBar.add(jM_Reportes);

        jM_CerrarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jM_CerrarSesion.setMnemonic('f');
        jM_CerrarSesion.setText("Cerrar sesion");

        MI_CerrarSesion.setMnemonic('s');
        MI_CerrarSesion.setText("Cerrar Sesion");
        MI_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_CerrarSesionActionPerformed(evt);
            }
        });
        jM_CerrarSesion.add(MI_CerrarSesion);

        MI_Salir.setMnemonic('x');
        MI_Salir.setText("Salir");
        MI_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_SalirActionPerformed(evt);
            }
        });
        jM_CerrarSesion.add(MI_Salir);

        menuBar.add(jM_CerrarSesion);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MI_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MI_SalirActionPerformed

    private void MI_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CerrarSesionActionPerformed
       int opc = JOptionPane.showConfirmDialog(null,"¿Desea cerrar sesión?","Confirmar salida", 
                  JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_MI_CerrarSesionActionPerformed

    private void MI_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ProductosActionPerformed
          JIF_GestionProductos Productos = JIF_GestionProductos.getInstancia();
        if(!Productos.isVisible()){
        desktopPane.add(Productos);
        Productos.setVisible(true);
        } else {
            try{
                Productos.setSelected(true);
            Productos.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_ProductosActionPerformed

    private void MI_CategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CategoriaProductoActionPerformed
        JIF_GestionCategoriaProducto Categoria = JIF_GestionCategoriaProducto.getInstancia();
        if(!Categoria.isVisible()){
        desktopPane.add(Categoria);
        Categoria.setVisible(true);
        } else {
            try{
                Categoria.setSelected(true);
            Categoria.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
        
    }//GEN-LAST:event_MI_CategoriaProductoActionPerformed

    private void MI_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_EmpleadosActionPerformed
         JIF_GestionEmpleados GestionEmpleado = JIF_GestionEmpleados.getInstancia();
        if(!GestionEmpleado.isVisible()){
        desktopPane.add(GestionEmpleado);
        GestionEmpleado.setVisible(true);
        } else {
            try{
                GestionEmpleado.setSelected(true);
            GestionEmpleado.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_EmpleadosActionPerformed

    private void MI_RolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RolesActionPerformed
        // TODO add your handling code here:
        JIF_CrearUsuario Crearusuario = JIF_CrearUsuario.getInstancia();
        if(!Crearusuario.isVisible()){
        desktopPane.add(Crearusuario);
        Crearusuario.setVisible(true);
        } else {
            try{
                Crearusuario.setSelected(true);
            Crearusuario.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_RolesActionPerformed

    private void MI_MetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_MetodoPagoActionPerformed
        JIF_GestionMetodoPagos MetodoPagos = JIF_GestionMetodoPagos.getInstancia();
        if(!MetodoPagos.isVisible()){
        desktopPane.add(MetodoPagos);
        MetodoPagos.setVisible(true);
        } else {
            try{
                MetodoPagos.setSelected(true);
            MetodoPagos.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_MetodoPagoActionPerformed

    private void MI_ActivosFijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ActivosFijosActionPerformed
        JIF_GestionActivosFijos ActivosFijos = JIF_GestionActivosFijos.getInstancia();
        if(!ActivosFijos.isVisible()){
        desktopPane.add(ActivosFijos);
        ActivosFijos.setVisible(true);
        } else {
            try{
                ActivosFijos.setSelected(true);
            ActivosFijos.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_ActivosFijosActionPerformed

    private void MI_RealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RealizarVentaActionPerformed
        JIF_ProcesosNuevaVenta NuevaVenta = JIF_ProcesosNuevaVenta.getInstancia();
        if(!NuevaVenta.isVisible()){
        desktopPane.add(NuevaVenta);
        NuevaVenta.setVisible(true);
        } else {
            try{
                NuevaVenta.setSelected(true);
            NuevaVenta.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_RealizarVentaActionPerformed

    private void MI_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ClientesActionPerformed
        JIF_GestionClientes Clientes = JIF_GestionClientes.getInstancia();
        if(!Clientes.isVisible()){
        desktopPane.add(Clientes);
        Clientes.setVisible(true);
        } else {
            try{
                Clientes.setSelected(true);
            Clientes.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_ClientesActionPerformed

    private void MI_TablaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_TablaVentasActionPerformed
       JIF_ListadoVentas Ventas = JIF_ListadoVentas.getInstancia();
        if(!Ventas.isVisible()){
        desktopPane.add(Ventas);
        Ventas.setVisible(true);
        } else {
            try{
                Ventas.setSelected(true);
            Ventas.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_TablaVentasActionPerformed

    private void MI_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ReportesActionPerformed
        JIF_Reportes Reportes = JIF_Reportes.getInstancia();
        if(!Reportes.isVisible()){
        desktopPane.add(Reportes);
        Reportes.setVisible(true);
        } else {
            try{
                Reportes.setSelected(true);
            Reportes.toFront();
            }catch (Exception e){
                System.out.println("error:"+e.getMessage());
            }
        }
    }//GEN-LAST:event_MI_ReportesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MI_ActivosFijos;
    private javax.swing.JMenuItem MI_CategoriaProducto;
    private javax.swing.JMenuItem MI_CerrarSesion;
    private javax.swing.JMenuItem MI_Clientes;
    private javax.swing.JMenuItem MI_Empleados;
    private javax.swing.JMenuItem MI_MetodoPago;
    private javax.swing.JMenuItem MI_Productos;
    private javax.swing.JMenuItem MI_RealizarVenta;
    private javax.swing.JMenuItem MI_Reportes;
    private javax.swing.JMenuItem MI_Roles;
    private javax.swing.JMenuItem MI_Salir;
    private javax.swing.JMenuItem MI_TablaVentas;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jM_Caja1;
    private javax.swing.JMenu jM_CerrarSesion;
    private javax.swing.JMenu jM_Clientes;
    private javax.swing.JMenu jM_Productos;
    private javax.swing.JMenu jM_Reportes;
    private javax.swing.JMenu jM_Ventas;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
