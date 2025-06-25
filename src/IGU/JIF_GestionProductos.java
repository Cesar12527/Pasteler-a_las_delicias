
package IGU;

import BDGestion.BDComboboxCategoriaProducto;
import BDGestion.BDGestionarProductos;
import Entidades.CategoriaProducto;
import Entidades.Producto;
import IGU.Modelos.ModeloComboCategoriaProducto;
import IGU.Modelos.ModeloTablaGestionProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class JIF_GestionProductos extends javax.swing.JInternalFrame {
    ModeloComboCategoriaProducto modeloComboCP = new ModeloComboCategoriaProducto();
    
    ModeloTablaGestionProducto modeloGestionProd = new ModeloTablaGestionProducto();
    private int idActualizar =-1;
    //gestiones Bd
    private BDGestionarProductos bd_gestProd = new BDGestionarProductos();
    
    public JIF_GestionProductos() {
        initComponents();
        this.cargarGestionTablaProducto();
        this.cargarComboCategoriaProducto();
        this.activarControles(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCombBoxCategoria = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Datos de Producto"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Categoria:");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCombBoxCategoria.setModel(this.modeloComboCP);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCombBoxCategoria, 0, 128, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombreProd, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(txtStock))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Productos"));

        jTable1.setModel(this.modeloGestionProd);
        jScrollPane1.setViewportView(jTable1);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnEditar)
                        .addGap(82, 82, 82)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Producto objP = new Producto();
        try{
            this.validarProducto();
            
            objP.setNombre(this.txtNombreProd.getText());
            double precio = Double.parseDouble(this.txtPrecio.getText());
            objP.setPrecioUnitario(precio);
            int stock = Integer.parseInt(this.txtStock.getText());
            objP.setStock(stock);
            //ComboBox
            CategoriaProducto cp = this.modeloComboCP.getSeleccionado();
            objP.setCategoriaProducto(cp);
            //ComboBox
            
            if(this.idActualizar == -1){
                this.bd_gestProd.crear(objP);
                this.cargarGestionTablaProducto();
                this.limpiarFormulario();
                this.idActualizar = -1;
            }else{
                this.bd_gestProd.actualizar(idActualizar, objP);
                this.cargarGestionTablaProducto();
                this.limpiarFormulario();
                this.idActualizar = -1;
            }
            
        }catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validación", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.limpiarFormulario();
        this.activarControles(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.limpiarFormulario();
        this.activarControles(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.activarControles(true);
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCombBoxCategoria;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNombreProd;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void cargarGestionTablaProducto() {
        ArrayList arrPro = null;
        try {
            arrPro = bd_gestProd.listar();
            this.modeloGestionProd.setListadoProducto(arrPro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarComboCategoriaProducto() {
    
    try {
        BDComboboxCategoriaProducto bd_GCP = new BDComboboxCategoriaProducto();
        ArrayList arrTD = bd_GCP.listar();
        this.modeloComboCP.setListadocategoriaProducto(arrTD);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
    }
    }

    private void validarProducto() {
                   try {
            if (txtNombreProd.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("El campo Nombre no puede estar vacio.");
            }
            if (txtPrecio.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("El campo Precio no puede estar vacio.");
            }
            if (txtStock.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("El Stock no puede estar vacio.");
            } 
            if(this.jCombBoxCategoria.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Por favor elige una categoria.");
        }
        } catch (Exception e) {
            throw e;
        } 
    }

    private void limpiarFormulario() {
        this.txtNombreProd.setText("");
        this.txtPrecio.setText("");
        this.txtStock.setText("");
        this.jCombBoxCategoria.setSelectedIndex(-1);
    }

    private void activarControles(boolean estado) {
        this.txtNombreProd.setEnabled(estado);
        this.txtPrecio.setEnabled(estado);
        this.txtStock.setEnabled(estado);
        this.btnGuardar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.jCombBoxCategoria.setEnabled(estado);
      //  this.btnVerDatos.setEnabled(!estado);
        this.btnEditar.setEnabled(!estado);
        this.btnEliminar.setEnabled(!estado);

    }
}
