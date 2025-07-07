package IGU;
import BDGestion.BDGestionActivoFijo;
import Entidades.ActivoFijo;
import IGU.Modelos.ModeloTablaActivoFijo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JIF_GestionActivosFijos extends javax.swing.JInternalFrame {
   private static JIF_GestionActivosFijos instancia;
   ModeloTablaActivoFijo mtc = new ModeloTablaActivoFijo();
    private int indexElemSelecc = -1;
    
    private JIF_GestionActivosFijos() {
        initComponents();
        this.cargarTabla();
        this.limpiarFormulario();
        this.activarControles(false);
    }
public static JIF_GestionActivosFijos getInstancia(){
        
       if( instancia == null || instancia.isClosed() ){
            instancia = new JIF_GestionActivosFijos();
       } 
       return instancia;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActivosFijos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripción = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtFechaAd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtValorPre = new javax.swing.JTextField();

        setClosable(true);

        tblActivosFijos.setModel(this.mtc);
        tblActivosFijos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblActivosFijos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jScrollPane1.setViewportView(tblActivosFijos);

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descripcion:");

        txtDescripción.setColumns(20);
        txtDescripción.setRows(5);
        jScrollPane2.setViewportView(txtDescripción);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha Adquisicion(yyyy-MM-dd):");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Valor precio:");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estado:");

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtValorPre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFechaAd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnGuardar)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaAd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorPre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.activarControles(true);
        tblActivosFijos.clearSelection();  // ← quita la selección en la tabla
        tblActivosFijos.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.activarControles(false);
        limpiarFormulario();
        tblActivosFijos.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       this.indexElemSelecc = this.tblActivosFijos.getSelectedRow();
        
        if(indexElemSelecc == -1){
        JOptionPane.showMessageDialog(this, "Seleccione un activo fijo de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    } else{

    JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este activo fijo?", "Confirmar", JOptionPane.YES_NO_OPTION);
    
        ActivoFijo objC = mtc.getActivoFijo(indexElemSelecc);
        try {
            BDGestionActivoFijo bdCli = new BDGestionActivoFijo();
            objC = (ActivoFijo) bdCli.obtener(objC.getId() );
            
            this.txtNombre.setText( objC.getNombre() );
            this.txtDescripción.setText(objC.getDescripcion());
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.txtFechaAd.setText(sdf.format(objC.getFechaAdquisicion()));

        this.txtValorPre.setText(String.valueOf(objC.getValorPrecio()));
        this.txtEstado.setText(objC.getEstado());
            this.activarControles(true);
            tblActivosFijos.clearSelection();
        } catch (Exception e) {
        }
        
        
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       // TODO add your handling code here:
        ActivoFijo objP = new ActivoFijo();
        this.indexElemSelecc = this.tblActivosFijos.getSelectedRow();
        
        try{
           validarActivosFijos();
            
            objP.setNombre(this.txtNombre.getText());
            objP.setDescripcion(this.txtDescripción.getText());
            double precio = Double.parseDouble(this.txtValorPre.getText());
            objP.setValorPrecio(precio);
            String fechaTexto = this.txtFechaAd.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaUtil = sdf.parse(fechaTexto);
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
            objP.setFechaAdquisicion(fechaSQL);
            objP.setEstado(this.txtEstado.getText());


             BDGestionActivoFijo gestCli = new BDGestionActivoFijo();
            if (this.indexElemSelecc >= 0 ){ // Hay elem cargado en FORM : Editando!
                ActivoFijo cliEdit = (ActivoFijo) this.mtc.getActivoFijo(this.indexElemSelecc);
                gestCli.actualizar( cliEdit.getId() , objP);
            
            } else {    // El elem es nuevo: Crear!
                int id = gestCli.crear(objP);
                objP.setId(id);
                 this.mtc.addActivoFijo(objP);
                 
            }
            cargarTabla();
            this.limpiarFormulario();
            this.activarControles(false);
            tblActivosFijos.clearSelection();  // ← quita la selección en la tabla
            this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
      
           
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     this.indexElemSelecc = this.tblActivosFijos.getSelectedRow();
    if (indexElemSelecc == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un activo fijo de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    } else{

    JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este activo fijo?", "Confirmar", JOptionPane.YES_NO_OPTION);
    
    try {
        ActivoFijo cli = mtc.getActivoFijo(indexElemSelecc); // obtén el cliente del modelo de tabla
        BDGestionActivoFijo bd = new BDGestionActivoFijo();
        bd.eliminar(cli.getId());
        cargarTabla();       // recarga la tabla con datos actualizados
        tblActivosFijos.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }   
    }     // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblActivosFijos;
    private javax.swing.JTextArea txtDescripción;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaAd;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValorPre;
    // End of variables declaration//GEN-END:variables

   public void cargarTabla(){
    
     ArrayList arrPro = null;
        try {
            BDGestionActivoFijo bd_gestProd = new BDGestionActivoFijo();
            arrPro = bd_gestProd.listar();
            this.mtc.setListadoActivos(arrPro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
        }
}

private void limpiarFormulario() {
        this.txtNombre.setText("");
        this.txtDescripción.setText("");
        this.txtEstado.setText("");
        this.txtFechaAd.setText("");
        this.txtValorPre.setText("");
        
    }

    private void activarControles(boolean estado) {
        this.txtNombre.setEnabled(estado);
        this.txtDescripción.setEnabled(estado);
        this.txtFechaAd.setEnabled(estado);
        this.txtEstado.setEnabled(estado);
        this.txtValorPre.setEnabled(estado);
        this.btnGuardar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.btnEliminar.setEnabled(!estado);
        this.btnModificar.setEnabled(!estado);
}
   private void validarActivosFijos()  {
    if (txtNombre.getText().trim().isEmpty()) {
        throw new IllegalArgumentException("El campo Nombre no puede estar vacío.");
    }

    if (txtDescripción.getText().trim().isEmpty()) {
        throw new IllegalArgumentException("El campo Descripción no puede estar vacío.");
    }


    if (txtFechaAd.getText().trim().isEmpty()) {
        throw new IllegalArgumentException("El campo Fecha de Adquisición no puede estar vacío.");
    }

   try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        java.util.Date fechaIngresada = sdf.parse(txtFechaAd.getText().trim());

        // Comparar con la fecha actual
        java.util.Date fechaHoy = new java.util.Date();
        if (fechaIngresada.after(fechaHoy)) {
            throw new IllegalArgumentException("La Fecha de Adquisición no puede ser mayor que la fecha actual.");
        }
    } catch (Exception ex) {
        throw new IllegalArgumentException("ingrese una fecha valida");
    }


    String valorTexto = txtValorPre.getText().trim();
    if (valorTexto.isEmpty()) {
        throw new IllegalArgumentException("El campo Valor Precio no puede estar vacío.");
    }

    // ✅ Aceptar solo números positivos decimales (ej. 0.01, 10, 150.75) y mayores que 0
    if (!valorTexto.matches("^\\d*\\.?\\d+$") || Double.parseDouble(valorTexto) <= 0) {
        throw new IllegalArgumentException("Ingrese un precio valido.");
    }

    if (txtEstado.getText().trim().isEmpty()) {
        throw new IllegalArgumentException("El campo 'Estado' no puede estar vacío.");
    }
}

}
