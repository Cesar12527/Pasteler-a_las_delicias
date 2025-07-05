
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
     private static JIF_GestionProductos instancia;
    ModeloComboCategoriaProducto modeloComboCP = new ModeloComboCategoriaProducto();
    private int indexElemSelecc = -1;

    ModeloTablaGestionProducto modeloGestionProd = new ModeloTablaGestionProducto();
    //gestiones Bd

    
    private JIF_GestionProductos() {
        initComponents();
        this.cargarGestionTablaProducto();
        this.cargarComboCategoriaProducto();
        this.activarControles(false);
    }
    public static JIF_GestionProductos getInstancia(){
        
        if( instancia == null || instancia.isClosed() ){
            instancia = new JIF_GestionProductos();
        } 
        return instancia;
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
        bntNuevo = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

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

        bntNuevo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bntNuevo.setText("Nuevo");
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });

        cmbCategoria.setModel(this.modeloComboCP);

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCategoria, 0, 128, Short.MAX_VALUE))
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
                                    .addComponent(bntNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(bntNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Productos"));

        tblProductos.setModel(this.modeloGestionProd);
        jScrollPane1.setViewportView(tblProductos);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
                        .addComponent(btnModificar)
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
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            CategoriaProducto cp = this.modeloComboCP.getSeleccionado();
            objP.setCategoriaProducto(cp);

             BDGestionarProductos gestCli = new BDGestionarProductos();
            if (this.indexElemSelecc >= 0 ){ // Hay elem cargado en FORM : Editando!
                Producto cliEdit = (Producto) this.modeloGestionProd.getProducto(this.indexElemSelecc);
                gestCli.actualizar( cliEdit.getId() , objP);
            
            } else {    // El elem es nuevo: Crear!
                int id = gestCli.crear(objP);
                objP.setId(id);
                 this.modeloGestionProd.addProducto(objP);
                 
            }
            cargarGestionTablaProducto();
            this.limpiarFormulario();
            this.activarControles(false);
            tblProductos.clearSelection();  // ← quita la selección en la tabla
            this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
      
           
        }
       

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
         this.activarControles(true);
         tblProductos.clearSelection();  // ← quita la selección en la tabla
         this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         this.indexElemSelecc = this.tblProductos.getSelectedRow();

if (indexElemSelecc == -1) {
    JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    return;
} else {
        Producto objC = modeloGestionProd.getProducto(indexElemSelecc);
        try {
            BDGestionarProductos bdCli = new BDGestionarProductos();
            objC = (Producto) bdCli.obtenerporNombre(objC.getNombre());
            
            this.txtNombreProd.setText( objC.getNombre() );
            this.txtPrecio.setText( String.valueOf(objC.getPrecioUnitario()));
            this.txtStock.setText( String.valueOf((int) objC.getStock()));
            this.modeloComboCP.setSeleccionado(objC.getCategoriaProducto());
            this.cmbCategoria.setSelectedItem(objC.getCategoriaProducto());
            this.activarControles(true);
            tblProductos.clearSelection();  // ← quita la selección en la tabla
        } catch (Exception e) {
        }
}
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.activarControles(false);
        limpiarFormulario();
        tblProductos.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     this.indexElemSelecc = this.tblProductos.getSelectedRow();

if (indexElemSelecc == -1) {
    JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    return;
} else {
    int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este producto?", "Confirmar",JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        try {
            Producto prod = modeloGestionProd.getProducto(indexElemSelecc); // obtén el producto del modelo de tabla
            BDGestionarProductos bd = new BDGestionarProductos();
            bd.eliminar(prod.getId());
            cargarGestionTablaProducto();
             tblProductos.clearSelection();  // ← quita la selección en la tabla
            this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación// recarga la tabla con datos actualizados
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Si es NO, no hace nada (solo cierra el diálogo)
}
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombreProd;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void cargarGestionTablaProducto() {
        ArrayList arrPro = null;
        try {
            BDGestionarProductos bd_gestProd = new BDGestionarProductos();
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
            throw new IllegalArgumentException("El campo Nombre no puede estar vacío.");
        }
         if (this.modeloComboCP.getSeleccionado() == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoria para el empleado.");
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Precio no puede estar vacío.");
        }
       
        if (txtStock.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Stock no puede estar vacío.");
        } 
    try {
    int stock = Integer.parseInt(txtStock.getText().trim());
    if (stock < 0) {
        throw new IllegalArgumentException("El Stock no puede ser negativo.");
    }
    } catch (NumberFormatException ex) {
    throw new IllegalArgumentException("El Stock debe ser un número entero válido.");
    }
        

    } catch (Exception e) {
        throw e;
    }
    }

    private void limpiarFormulario() {
        this.txtNombreProd.setText("");
        this.txtPrecio.setText("");
        this.txtStock.setText("");
        this.cmbCategoria.setSelectedIndex(-1);
    }

    private void activarControles(boolean estado) {
        this.txtNombreProd.setEnabled(estado);
        this.txtPrecio.setEnabled(estado);
        this.txtStock.setEnabled(estado);
        this.btnGuardar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.cmbCategoria.setEnabled(estado);
        this.btnModificar.setEnabled(!estado);
        this.btnEliminar.setEnabled(!estado);

    }
}
