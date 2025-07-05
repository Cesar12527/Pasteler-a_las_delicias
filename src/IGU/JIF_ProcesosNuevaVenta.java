package IGU;

import BDGestion.BDGestionEmpleados;
import BDGestion.BDGestionMetodoPago;
import BDGestion.BDGestionarClientes;
import BDGestion.BDGestionarProductos;
import Entidades.Producto;
import Entidades.Venta;
import BDGestion.BDGestionarDetalleVenta;
import BDGestion.BDGestionarVenta;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Empleado;
import Entidades.MetodoPago;
import IGU.Modelos.ModeloComboEmpleado;
import IGU.Modelos.ModeloComboTipoPago;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class JIF_ProcesosNuevaVenta extends javax.swing.JInternalFrame {
    private static JIF_ProcesosNuevaVenta instancia;
    int item;
    DefaultTableModel model = new DefaultTableModel();
    double TotalPagar = 0.00;
    
    private JPopupMenu popupSugerencias = new JPopupMenu();
    private JList<String> listaSugerencias = new JList<>();
    private DefaultListModel<String> modeloSugerencias = new DefaultListModel<>();
   
   ModeloComboTipoPago mctp = new ModeloComboTipoPago();
   ModeloComboEmpleado mce = new ModeloComboEmpleado();
  
 
  
    private JIF_ProcesosNuevaVenta() {
        initComponents();
        this.cargarComboMetodoPago();
        this.cargarComboEmpleado();
       

  listaSugerencias.setModel(modeloSugerencias);
listaSugerencias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

popupSugerencias.add(new javax.swing.JScrollPane(listaSugerencias));

txtProducto.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasProducto();
    }

    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasProducto();
    }

    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasProducto();
    }
});

txtCliente.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCliente(); // ✅ solo clientes
    }
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCliente();
    }
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCliente();
    }
});
txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();

        if (popupSugerencias.isVisible()) {
            int index = listaSugerencias.getSelectedIndex();

            // Flecha abajo
            if (key == KeyEvent.VK_DOWN) {
                if (index < modeloSugerencias.size() - 1) {
                    listaSugerencias.setSelectedIndex(index + 1);
                    listaSugerencias.ensureIndexIsVisible(index + 1);
                }
                evt.consume(); // Evita que se pase al JTextField
            }

            // Flecha arriba
            else if (key == KeyEvent.VK_UP) {
                if (index > 0) {
                    listaSugerencias.setSelectedIndex(index - 1);
                    listaSugerencias.ensureIndexIsVisible(index - 1);
                }
                evt.consume();
            }

            // Escape para cerrar el popup
            else if (key == KeyEvent.VK_ESCAPE) {
                popupSugerencias.setVisible(false);
            }
        }
    }
});
txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();

        if (popupSugerencias.isVisible()) {
            int index = listaSugerencias.getSelectedIndex();

            // Flecha abajo
            if (key == KeyEvent.VK_DOWN) {
                if (index < modeloSugerencias.size() - 1) {
                    listaSugerencias.setSelectedIndex(index + 1);
                    listaSugerencias.ensureIndexIsVisible(index + 1);
                }
                evt.consume(); // Evita que se pase al JTextField
            }

            // Flecha arriba
            else if (key == KeyEvent.VK_UP) {
                if (index > 0) {
                    listaSugerencias.setSelectedIndex(index - 1);
                    listaSugerencias.ensureIndexIsVisible(index - 1);
                }
                evt.consume();
            }

            // Escape para cerrar el popup
            else if (key == KeyEvent.VK_ESCAPE) {
                popupSugerencias.setVisible(false);
            }
        }}

    
});
    }
    public static JIF_ProcesosNuevaVenta getInstancia(){
        
        if( instancia == null || instancia.isClosed() ){
            instancia = new JIF_ProcesosNuevaVenta();
        } 
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        txtCliente = new javax.swing.JTextField();

        setClosable(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel9.setText("Total a Pagar:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cantidad:");

        txtTotalPagar.setText("-------------");
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Empleado:");

        cmbTipoPago.setModel(this.mctp
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Producto:");

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cliente", "Empleado", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Metodo Pago:");

        jLabel4.setText("Precio:");

        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        jLabel8.setText("Stock:");

        cmbEmpleado.setModel(this.mce
        );

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnEliminar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(31, 31, 31))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel9)
                                .addGap(33, 33, 33)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(11, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir)
                    .addComponent(jLabel9)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(620, 620, 620))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(321, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(321, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        if(!"".equals(txtCantidad.getText())){
         String nombre = txtProducto.getText();
          String cliente = txtCliente.getText();
         String empleado = cmbEmpleado.getSelectedItem().toString();
         int cant = Integer.parseInt(txtCantidad.getText());
         double precio = Double.parseDouble(txtPrecio.getText());
         double total = cant * precio;
         int stock = Integer.parseInt(txtStock.getText());
         if(stock >= cant ){
          model = (DefaultTableModel)tblVenta.getModel();
          for(int i= 0; i<tblVenta.getRowCount(); i++){
          if(tblVenta.getValueAt(i, 0).equals(nombre)){
          JOptionPane.showMessageDialog(null, "El Producto ya está registrado");
          return;
          }
          }
          item = item + 1;
         ArrayList list = new ArrayList(); 
         list.add(item);
         list.add(nombre);
         list.add(cliente);
         list.add(empleado);
         list.add(cant);
         list.add(precio);
         list.add(total);
         Object[] o = new Object[6];
         o[0] = nombre;
         o[1]= cliente;
         o[2]= empleado;
         o[3] = cant;
         o[4] = precio;
         o[5] = total;
         model.addRow(o);
         tblVenta.setModel(model);
             totalPagar();
             limpiar();
             txtProducto.requestFocus();
         }else{
         JOptionPane.showMessageDialog(null, "Stock no disponible");
         }
        }else{
        JOptionPane.showMessageDialog(null, "Ingrese cantidad");
        }
    }//GEN-LAST:event_txtCantidadKeyPressed
    }
    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed

    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         model = (DefaultTableModel)tblVenta.getModel();
        model.removeRow(tblVenta.getSelectedRow());
        totalPagar();
        txtProducto.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
         try {
              validarVenta();
        // ✅ Validar si hay productos en la tabla
        if (tblVenta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos para vender.");
            return;
        }

        // Paso 1: Crear objeto Venta
        Venta venta = new Venta();
        venta.setTotal(Float.parseFloat(txtTotalPagar.getText()));

        // Buscar cliente por nombre
       String nombreCliente = txtCliente.getText().trim();
BDGestionarClientes daoCliente = new BDGestionarClientes();
Cliente cliente = daoCliente.obtenerPorNombre(nombreCliente);



venta.setCliente(cliente); 

        // Buscar empleado por nombre
        
        Empleado empleado = mce.getSeleccionado();
        if (empleado == null) {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado");
            return;
        }
        venta.setEmpleado(empleado);
        // Método de pago
     
        MetodoPago metodo = mctp.getSeleccionado();
        
        venta.setMetodoPago(metodo);

        // Paso 2: Insertar Venta
        BDGestionarVenta ventaDao = new BDGestionarVenta();
        int idVentaGenerada = ventaDao.crear(venta);
        if (idVentaGenerada == -1) {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta.");
            return;
        }

        // Paso 3: Insertar detalles
        BDGestionarDetalleVenta detalleDao = new BDGestionarDetalleVenta();
        for (int i = 0; i < tblVenta.getRowCount(); i++) {
            DetalleVenta det = new DetalleVenta();
            det.setVenta(new Venta(idVentaGenerada, 0, null, null, null, null));

            Producto p = new Producto();
            String nombreProducto = tblVenta.getValueAt(i, 0).toString();
            p.setId(obtenerIdProductoPorNombre(nombreProducto));
            det.setProducto(p);

            det.setCantidad(Integer.parseInt(tblVenta.getValueAt(i, 3).toString()));
            det.setSubTotal(Float.parseFloat(tblVenta.getValueAt(i, 5).toString()));
            detalleDao.crear(det);
            BDGestionarProductos prodDao = new BDGestionarProductos();
            prodDao.actualizarStock(p.getId(), det.getCantidad());
        }

        // Paso 4: Confirmación
        limpiarTabla();
        txtTotalPagar.setText("0.00");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al registrar venta: " + ex.getMessage());
        
    }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // Si hay un producto seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionarProductoDeLista(); // ✅ Usa el método ya creado
            return; // Termina aquí para no continuar con la búsqueda manual
        }

        // ↓↓↓ Si no hay sugerencia seleccionada, continuar con la búsqueda normal
        String nombre = txtProducto.getText().trim();
        if (!nombre.isEmpty()) {
            try {
                BDGestionarProductos dao = new BDGestionarProductos();
                Producto producto = (Producto) dao.obtenerporNombre(nombre);
                if (producto != null) {
                    txtPrecio.setText(String.valueOf(producto.getPrecioUnitario()));
                    txtStock.setText(String.valueOf(producto.getStock()));
                    txtCantidad.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado");
                    limpiar();
                    txtProducto.requestFocus();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al buscar producto: " + ex.getMessage());
            }
        }
    }

    }//GEN-LAST:event_txtProductoKeyPressed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // ✅ Si hay un cliente seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionarClienteDeLista(); // <--- Aquí se oculta el popup y se asigna
            return;
        }
       }
    }//GEN-LAST:event_txtClienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
private void totalPagar(){
TotalPagar = 0.00;
int numFila = tblVenta.getRowCount();
    for (int i = 0; i < numFila; i++) {
        double cal= Double.parseDouble(String.valueOf(tblVenta.getModel().getValueAt(i, 5)));
        TotalPagar = TotalPagar + cal;
    }
    txtTotalPagar.setText(String.format("%.2f",TotalPagar));

}
private void limpiar(){
   this.txtProducto.setText("");
    this.txtCantidad.setText("");
    this.txtPrecio.setText("");
    this.txtStock.setText("");
}


private int obtenerIdProductoPorNombre(String nombreProducto) throws Exception {
    BDGestionarProductos dao = new BDGestionarProductos();
    Producto p = (Producto) dao.obtenerporNombre(nombreProducto);
    if (p != null) {
        return p.getId();
    } else {
        throw new Exception("Producto no encontrado: " + nombreProducto);
    }
}

private void limpiarTabla() {
    DefaultTableModel model = (DefaultTableModel) tblVenta.getModel();
    model.setRowCount(0);
    item = 0;
}
private void cargarComboMetodoPago() {
    
    try {
        BDGestionMetodoPago bd_GCP = new BDGestionMetodoPago();
        ArrayList arrTD = bd_GCP.listar();
        this.mctp.setListadoRol(arrTD);
         cmbTipoPago.setModel(mctp);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
    }
    }
private void cargarComboEmpleado() {
    
    try {
        BDGestionEmpleados bd_GCP = new BDGestionEmpleados();
        ArrayList arrTD = bd_GCP.listar();
        this.mce.setListadoRol(arrTD);
         cmbEmpleado.setModel(mce);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
    }
    }

private void mostrarSugerenciasProducto() {
    String texto = txtProducto.getText().trim().toLowerCase();
    modeloSugerencias.clear();
    
    if (texto.length() < 1) {
        popupSugerencias.setVisible(false);
        return;
    }
    
    try {
        BDGestionarProductos dao = new BDGestionarProductos();
        ArrayList<Producto> productos = dao.listar();
        
        for (Producto p : productos) {
            String nombreProducto = p.getNombre().toLowerCase();
            String nombreCategoria = p.getCategoriaProducto().getNombrecat().toLowerCase();

            if (nombreProducto.contains(texto) || nombreCategoria.contains(texto)) {
                modeloSugerencias.addElement(p.getNombre());
            }
        }

        if (modeloSugerencias.isEmpty()) {
            popupSugerencias.setVisible(false);
        } else {
            listaSugerencias.setSelectedIndex(0);
            popupSugerencias.show(txtProducto, 0, txtProducto.getHeight());
            txtProducto.requestFocus();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar sugerencias: " + e.getMessage());
    }
}


private void mostrarSugerenciasCliente() {
    String texto = txtCliente.getText().trim().toLowerCase();
    modeloSugerencias.clear();
    
    if (texto.length() < 1) {
        popupSugerencias.setVisible(false);
        return;
    }
    
    try {
        BDGestionarClientes dao = new BDGestionarClientes();
        ArrayList<Cliente> clientes = dao.listar();
        
        for (Cliente c : clientes) {
            String nombreCliente = c.getNombre().toLowerCase();
            if (nombreCliente.contains(texto)) {
                modeloSugerencias.addElement(c.getNombre());
            }
        }

        if (modeloSugerencias.isEmpty()) {
            popupSugerencias.setVisible(false);
        } else {
            listaSugerencias.setSelectedIndex(0);
            popupSugerencias.show(txtCliente, 0, txtCliente.getHeight());
            txtCliente.requestFocus();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar sugerencias: " + e.getMessage());
    }
}

private void seleccionarProductoDeLista() {
    String seleccionado = listaSugerencias.getSelectedValue();
    if (seleccionado != null) {
        txtProducto.setText(seleccionado);
        popupSugerencias.setVisible(false);
        // Simular enter para cargar los datos del producto
        KeyEvent evt = new KeyEvent(txtProducto, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, '\n');
        txtProductoKeyPressed(evt);
    }
}
private void seleccionarClienteDeLista() {
    String seleccionado = listaSugerencias.getSelectedValue();
    if (seleccionado != null) {
        txtCliente.setText(seleccionado);
        popupSugerencias.setVisible(false);
        txtCliente.requestFocus();
    }
}
 private void validarVenta() {
            try {
       
        if (this.mctp.getSeleccionado() == null) {
            throw new IllegalArgumentException("Debe seleccionar un Rol para el empleado.");
        }

    } catch (Exception e) {
        throw e;
    }
    }
}
