
package IGU;

import javax.swing.JOptionPane;

public class MDI_MenuPrincipal extends javax.swing.JFrame {
    
    public MDI_MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jM_Productos = new javax.swing.JMenu();
        MI_Productos = new javax.swing.JMenuItem();
        MI_CategoriaProducto = new javax.swing.JMenuItem();
        MI_ActivosFijos = new javax.swing.JMenuItem();
        jM_Ventas = new javax.swing.JMenu();
        MI_RealizarVenta = new javax.swing.JMenuItem();
        MI_MetodoPago = new javax.swing.JMenuItem();
        jM_Compras = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        MI_RealizarCompra = new javax.swing.JMenuItem();
        jM_Caja1 = new javax.swing.JMenu();
        MI_Empleados = new javax.swing.JMenuItem();
        MI_Roles = new javax.swing.JMenuItem();
        jM_Clientes = new javax.swing.JMenu();
        MI_Clientes = new javax.swing.JMenuItem();
        jM_Proveedores = new javax.swing.JMenu();
        MI_Proveedores = new javax.swing.JMenuItem();
        jM_Caja = new javax.swing.JMenu();
        Mi_GestionCaja = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jM_Reportes = new javax.swing.JMenu();
        jM_CerrarSesion = new javax.swing.JMenu();
        MI_CerrarSesion = new javax.swing.JMenuItem();
        MI_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        menuBar.add(jM_Ventas);

        jM_Compras.setText("Compras");

        jMenuItem8.setText("Ventas por fecha");
        jM_Compras.add(jMenuItem8);

        jMenuItem9.setText("Compras por Proveedor");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jM_Compras.add(jMenuItem9);

        jMenuItem10.setText("Stock de Productos");
        jM_Compras.add(jMenuItem10);

        MI_RealizarCompra.setText("Realizar Compra");
        MI_RealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_RealizarCompraActionPerformed(evt);
            }
        });
        jM_Compras.add(MI_RealizarCompra);

        menuBar.add(jM_Compras);

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

        jM_Proveedores.setText("Proveedores");

        MI_Proveedores.setMnemonic('d');
        MI_Proveedores.setText("Proveedores");
        MI_Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ProveedoresActionPerformed(evt);
            }
        });
        jM_Proveedores.add(MI_Proveedores);

        menuBar.add(jM_Proveedores);

        jM_Caja.setText("Caja");

        Mi_GestionCaja.setText("Gestion Caja");
        Mi_GestionCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mi_GestionCajaActionPerformed(evt);
            }
        });
        jM_Caja.add(Mi_GestionCaja);

        jMenuItem11.setText("Movimientos de Caja");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jM_Caja.add(jMenuItem11);

        menuBar.add(jM_Caja);

        jM_Reportes.setText("Reportes");
        menuBar.add(jM_Reportes);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MI_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MI_SalirActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void MI_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CerrarSesionActionPerformed
        // TODO add your handling code here:  
        int opc = JOptionPane.showConfirmDialog(null,"¿Desea cerrar sesión?","Confirmar salida", 
                  JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_MI_CerrarSesionActionPerformed

    private void MI_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ProductosActionPerformed
        // TODO add your handling code here:
        JIF_GestionProductos jif_GP = new JIF_GestionProductos();
        this.desktopPane.add(jif_GP);
        jif_GP.setVisible(true);
    }//GEN-LAST:event_MI_ProductosActionPerformed

    private void MI_CategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CategoriaProductoActionPerformed
        // TODO add your handling code here:
        JIF_GestionCategoriaProducto jif_GCP = new JIF_GestionCategoriaProducto();
        this.desktopPane.add(jif_GCP);
        jif_GCP.setVisible(true);
    }//GEN-LAST:event_MI_CategoriaProductoActionPerformed

    private void MI_ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ProveedoresActionPerformed
        // TODO add your handling code here:
        JIF_GestionProveedores jif_GP = new JIF_GestionProveedores();
        this.desktopPane.add(jif_GP);
        jif_GP.setVisible(true);
    }//GEN-LAST:event_MI_ProveedoresActionPerformed

    private void MI_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_EmpleadosActionPerformed
        // TODO add your handling code here:
        JIF_GestionEmpleados jif_GE = new JIF_GestionEmpleados();
        this.desktopPane.add(jif_GE);
        jif_GE.setVisible(true);
    }//GEN-LAST:event_MI_EmpleadosActionPerformed

    private void MI_RolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RolesActionPerformed
        // TODO add your handling code here:
        JIF_CrearUsuario jif_GR = new JIF_CrearUsuario();
        this.desktopPane.add(jif_GR);
        jif_GR.setVisible(true);
    }//GEN-LAST:event_MI_RolesActionPerformed

    private void MI_MetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_MetodoPagoActionPerformed
        // TODO add your handling code here:
        JIF_GestionMetodoPagos jif_GMP = new JIF_GestionMetodoPagos();
        this.desktopPane.add(jif_GMP);
        jif_GMP.setVisible(true);
    }//GEN-LAST:event_MI_MetodoPagoActionPerformed

    private void MI_ActivosFijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ActivosFijosActionPerformed
        // TODO add your handling code here:
        JIF_GestionActivosFijos jif_GAF = new JIF_GestionActivosFijos();
        this.desktopPane.add(jif_GAF);
        jif_GAF.setVisible(true);
    }//GEN-LAST:event_MI_ActivosFijosActionPerformed

    private void MI_RealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RealizarVentaActionPerformed
        // TODO add your handling code here:
        JIF_ProcesosNuevaVenta jif_PNV = new JIF_ProcesosNuevaVenta();
        this.desktopPane.add(jif_PNV);
        jif_PNV.setVisible(true);
    }//GEN-LAST:event_MI_RealizarVentaActionPerformed

    private void MI_RealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RealizarCompraActionPerformed
        // TODO add your handling code here:
        JIF_ProcesosCompra jif_PC = new JIF_ProcesosCompra();
        this.desktopPane.add(jif_PC);
        jif_PC.setVisible(true);
    }//GEN-LAST:event_MI_RealizarCompraActionPerformed

    private void Mi_GestionCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mi_GestionCajaActionPerformed
        // TODO add your handling code here:
        JIF_GestionCaja jif_GC = new JIF_GestionCaja();
        this.desktopPane.add(jif_GC);
        jif_GC.setVisible(true);
    }//GEN-LAST:event_Mi_GestionCajaActionPerformed

    private void MI_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ClientesActionPerformed
        // TODO add your handling code here:
        JIF_GestionClientes jif_GC = new JIF_GestionClientes();
        this.desktopPane.add(jif_GC);
        jif_GC.setVisible(true);
    }//GEN-LAST:event_MI_ClientesActionPerformed

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
    private javax.swing.JMenuItem MI_Proveedores;
    private javax.swing.JMenuItem MI_RealizarCompra;
    private javax.swing.JMenuItem MI_RealizarVenta;
    private javax.swing.JMenuItem MI_Roles;
    private javax.swing.JMenuItem MI_Salir;
    private javax.swing.JMenuItem Mi_GestionCaja;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jM_Caja;
    private javax.swing.JMenu jM_Caja1;
    private javax.swing.JMenu jM_CerrarSesion;
    private javax.swing.JMenu jM_Clientes;
    private javax.swing.JMenu jM_Compras;
    private javax.swing.JMenu jM_Productos;
    private javax.swing.JMenu jM_Proveedores;
    private javax.swing.JMenu jM_Reportes;
    private javax.swing.JMenu jM_Ventas;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
