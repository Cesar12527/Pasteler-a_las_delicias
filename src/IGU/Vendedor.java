package IGU;

import BDGestion.BDGestionarClientes;
import BDGestion.BDGestionarProductos;
import BDGestion.BDGestionMetodoPago;
import Entidades.Producto;
import Entidades.Venta;
import BDGestion.BDGestionarDetalleVenta;
import BDGestion.BDGestionarVenta;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Empleado;
import Entidades.MetodoPago;
import IGU.Desing.BordeRedondeado;
import IGU.Desing.PanaderiaButton;
import IGU.Modelos.ModeloComboTipoPago;
import IGU.Modelos.ModeloTablaCliente;
import IGU.Modelos.ModeloTablaDetalleVenta;
import IGU.Modelos.ModeloTablaGestionProducto;

import Seguridad.sesion;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author obbtu
 */
public class Vendedor extends javax.swing.JFrame {

    int item;
    DefaultTableModel model = new DefaultTableModel();
  private int indexElemSelecc = -1;
    private JPopupMenu popupSugerencias = new JPopupMenu();
    private JList<String> listaSugerencias = new JList<>();
    private DefaultListModel<String> modeloSugerencias = new DefaultListModel<>();
    
   ModeloComboTipoPago mctp = new ModeloComboTipoPago();
ModeloTablaDetalleVenta tblv = new ModeloTablaDetalleVenta();
ModeloTablaCliente mtc = new ModeloTablaCliente();
ModeloTablaGestionProducto modeloGestionProd = new ModeloTablaGestionProducto();
    

    public Vendedor() {
        initComponents();
        
         txtCliente.setBorder(new BordeRedondeado(10));
         txtProducto.setBorder(new BordeRedondeado(10));
         txtCantidad.setBorder(new BordeRedondeado(10));
         txtPrecio.setBorder(new BordeRedondeado(10));
         txtStock.setBorder(new BordeRedondeado(10));
         txtTotalPagar.setBorder(new BordeRedondeado(10));
         txtNombres.setBorder(new BordeRedondeado(10));
         txtApellidos.setBorder(new BordeRedondeado(10));
         txtDNI.setBorder(new BordeRedondeado(10));
         txtTelefono.setBorder(new BordeRedondeado(10));
         
         
         this.getContentPane().setBackground(java.awt.Color.WHITE);
         tableVentaListaVenta.setBackground(java.awt.Color.WHITE);
         jPanel1.setBackground(java.awt.Color.WHITE);
          jPanel2.setBackground(java.awt.Color.WHITE);
          jPanel3.setBackground(java.awt.Color.WHITE);
          jPanel4.setBackground(java.awt.Color.WHITE);
          jPanel5.setBackground(java.awt.Color.WHITE);
          jPanel7.setBackground(java.awt.Color.WHITE);
         tblVenta.setBackground(java.awt.Color.WHITE);
        tblCliente.setBackground(java.awt.Color.WHITE);
        tblVenta1.setBackground(java.awt.Color.WHITE);
        
         tblProductos.setBackground(java.awt.Color.WHITE);
        jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE);
        jScrollPane4.getViewport().setBackground(java.awt.Color.WHITE);
                jScrollPane5.getViewport().setBackground(java.awt.Color.WHITE);

        // Botones de Navegación Lateral (similares a la imagen)
    PanaderiaButton.aplicarEstilo(btnNuevaVenta, "nueva venta");
    PanaderiaButton.aplicarEstilo(btnListaProductos, "productos"); // Asumiendo que "Lista de productos" es "productos"
    PanaderiaButton.aplicarEstilo(btnCliente, "clientes"); // btnCliente es el botón "Clientes"
    PanaderiaButton.aplicarEstilo(btnListaVentas, "lista de ventas"); // "Reportes" o "Lista de ventas"
    PanaderiaButton.aplicarEstilo(btnSalir, "salir");

    // Botones dentro de la pestaña "Venta"
    PanaderiaButton.aplicarEstilo(btnImprimir, "reportes"); // Reutilizamos el estilo de reportes, o puedes definir uno nuevo
    PanaderiaButton.aplicarEstilo(btnEliminar, "salir"); // Podría ser "salir" o un nuevo tipo "eliminar_detalle"

    // Botones dentro de la pestaña "Clientes"
    PanaderiaButton.aplicarEstilo(btnGuardar, "ventas"); // Puedes elegir un color, "ventas" es dorado
    PanaderiaButton.aplicarEstilo(btnNuevo, "productos"); // "productos" es marron claro
    PanaderiaButton.aplicarEstilo(btnCancelar, "salir"); // rojo cereza
    PanaderiaButton.aplicarEstilo(btnModificar, "ventas"); // dorado
    PanaderiaButton.aplicarEstilo(btnEliminar1, "salir"); // rojo cereza para eliminar clientes

    
        setLocationRelativeTo(null);
        this.cargarComboMetodoPago();
        this.cargarTablaVenta();
        this.cargarTabla();
        this.activarControles(false);
        this.cargarGestionTablaProducto();
        tableVentaListaVenta.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
        @Override
        protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
            return 0;
        }
    });
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnListaVentas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        tableVentaListaVenta = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
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
        txtCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVenta1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaVenta = new javax.swing.JButton();
        btnListaProductos = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Metodo Pago:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnListaVentas.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnListaVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/ListaDeVentas.png"))); // NOI18N
        btnListaVentas.setText("Lista de ventas");
        btnListaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaVentasActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tableVentaListaVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel9.setText("Total a Pagar:");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cantidad:");

        txtTotalPagar.setText("-------------");
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        cmbTipoPago.setModel(this.mctp
        );

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Producto:");

        tblVenta.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cliente", "Empleado", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        jLabel11.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/metodo-de-pago.png"))); // NOI18N
        jLabel11.setText("Metodo Pago:");

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel4.setText("Precio:");

        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel8.setText("Stock:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9)
                                .addGap(45, 45, 45)
                                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txtPrecio))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir)
                    .addComponent(jLabel9)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(620, 620, 620))
        );

        tableVentaListaVenta.addTab("Venta", jPanel2);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 2));

        tblProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        tblProductos.setForeground(new java.awt.Color(51, 0, 0));
        tblProductos.setModel(this.modeloGestionProd);
        jScrollPane3.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tableVentaListaVenta.addTab("Lista de productos", jPanel3);

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombres:");

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Apellidos:");

        jLabel13.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("DNI:");

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Telefono:");

        txtTelefono.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));

        txtNombres.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));

        txtApellidos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        txtApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));

        btnGuardar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDNI.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        txtDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDNI)
                            .addComponent(txtNombres)
                            .addComponent(txtApellidos)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addGap(12, 12, 12)
                        .addComponent(btnCancelar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombres))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellidos))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        tblCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 2));
        tblCliente.setModel(this.mtc);
        jScrollPane4.setViewportView(tblCliente);

        btnModificar.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar1.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnModificar)
                .addGap(31, 31, 31)
                .addComponent(btnEliminar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableVentaListaVenta.addTab("Lista de clientes", jPanel5);

        tblVenta1.setModel(this.tblv);
        jScrollPane5.setViewportView(tblVenta1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tableVentaListaVenta.addTab("Lista de ventas", jPanel4);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/VentasTitulo.png"))); // NOI18N
        jLabel1.setText("    VENTAS  LAS DELICIAS ");

        btnNuevaVenta.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/ventas (1).png"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnListaProductos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnListaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/ProductosLista.png"))); // NOI18N
        btnListaProductos.setText("Lista de productos");
        btnListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaProductosActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/Clientes.png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IGU/LocalTitulo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListaVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(tableVentaListaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevaVenta)
                        .addGap(36, 36, 36)
                        .addComponent(btnListaProductos)
                        .addGap(36, 36, 36)
                        .addComponent(btnCliente)
                        .addGap(36, 36, 36)
                        .addComponent(btnListaVentas)
                        .addGap(36, 36, 36)
                        .addComponent(btnSalir))
                    .addComponent(tableVentaListaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    String textoCantidad = txtCantidad.getText().trim();

    if (!textoCantidad.isEmpty()) {
        try {
            int cant = Integer.parseInt(textoCantidad);
            if (cant <= 0) {
                throw new NumberFormatException(); // fuerza error si es negativo o cero
            }

            String nombre = txtProducto.getText();
            String cliente = txtCliente.getText();
            Empleado empleado = sesion.empleadoLogueado;
            if (empleado == null) {
                JOptionPane.showMessageDialog(this, "No hay empleado logueado.");
                return;
            }

            BigDecimal precio = new BigDecimal(txtPrecio.getText());
BigDecimal cantidad = new BigDecimal(cant);
BigDecimal total = precio.multiply(cantidad).setScale(2, RoundingMode.HALF_UP);
            int stock = Integer.parseInt(txtStock.getText());

            if (stock >= cant) {
                model = (DefaultTableModel) tblVenta.getModel();
                for (int i = 0; i < tblVenta.getRowCount(); i++) {
                    if (tblVenta.getValueAt(i, 0).equals(nombre)) {
                        JOptionPane.showMessageDialog(null, "El producto ya está registrado");
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
                o[1] = cliente;
                o[2] = empleado;
                o[3] = cant;
                o[4] = precio;
                o[5] = total;

                model.addRow(o);
                tblVenta.setModel(model);
                totalPagar();
                limpiar();
                txtProducto.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Stock no disponible");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida ");
            txtCantidad.setText("");
            txtCantidad.requestFocus();
        }

    } else {
        JOptionPane.showMessageDialog(null, "Ingrese cantidad");
    }
   }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        model = (DefaultTableModel)tblVenta.getModel();
        model.removeRow(tblVenta.getSelectedRow());
        totalPagar();
        txtProducto.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
     
    }//GEN-LAST:event_txtTotalPagarActionPerformed

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
        Empleado empleado = sesion.empleadoLogueado;
if (empleado == null) {
    JOptionPane.showMessageDialog(this, "No hay un empleado logueado.");
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
         pdf();
         cargarTablaVenta();
        limpiarTabla();
        limpiaralvender();
        txtTotalPagar.setText("0.00");
         
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al registrar venta: " + ex.getMessage());
        
    }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed

        
        
        tableVentaListaVenta.setSelectedIndex(0); // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaProductosActionPerformed
         tableVentaListaVenta.setSelectedIndex(1);// TODO add your handling code here:
    }//GEN-LAST:event_btnListaProductosActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        tableVentaListaVenta.setSelectedIndex(2);// TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnListaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaVentasActionPerformed
        tableVentaListaVenta.setSelectedIndex(3);// TODO add your handling code here:
    }//GEN-LAST:event_btnListaVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
      
     if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // ✅ Si hay un cliente seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionarClienteDeLista(); // <--- Aquí se oculta el popup y se asigna
            return;
        }
    }

   
// TODO add your handling code here:
    }//GEN-LAST:event_txtClienteKeyPressed

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.indexElemSelecc = this.tblCliente.getSelectedRow();
        if (indexElemSelecc == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else{
            try {
                Cliente objC = mtc.getCliente(indexElemSelecc);
                BDGestionarClientes bdCli = new BDGestionarClientes();
                objC = (Cliente) bdCli.obtenerPorNombre(objC.getNombre());

                this.txtNombres.setText( objC.getNombre() );
                this.txtApellidos.setText(objC.getApellidos());
                this.txtDNI.setText(objC.getDni());
                this.txtTelefono.setText(objC.getTelefono());

                this.activarControles(true);
                tblCliente.clearSelection();  // ← quita la selección en la tabla

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        this.indexElemSelecc = this.tblCliente.getSelectedRow();
        if (indexElemSelecc == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else{

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                try {
                    Cliente cli = mtc.getCliente(indexElemSelecc); // obtén el cliente del modelo de tabla
                    BDGestionarClientes bd = new BDGestionarClientes();
                    bd.eliminar(cli.getId());
                    cargarTabla();       // recarga la tabla con datos actualizados
                    tblCliente.clearSelection();  // ← quita la selección en la tabla
                    this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try{
            this.validarCliente();
            Cliente objP = new Cliente();
            objP.setNombre(this.txtNombres.getText());
            objP.setApellidos(this.txtApellidos.getText());
            objP.setDni(this.txtDNI.getText());
            objP.setTelefono(this.txtTelefono.getText());

            BDGestionarClientes gestCli = new BDGestionarClientes();
            if (this.indexElemSelecc >= 0 ){ // Hay elem cargado en FORM : Editando!
                Cliente cliEdit = (Cliente) this.mtc.getCliente(this.indexElemSelecc);
                gestCli.actualizar( cliEdit.getId() , objP);

            } else {    // El elem es nuevo: Crear!
                int id = gestCli.crear(objP);
                objP.setId(id);
                this.mtc.addCliente(objP);

            }
            cargarTabla();
            this.limpiarFormulario();
            this.activarControles(false);
            tblCliente.clearSelection();  // ← quita la selección en la tabla
            this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.activarControles(true);
        tblCliente.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.activarControles(false);
        this.limpiarFormulario();
        tblCliente.clearSelection();  // ← quita la selección en la tabla
        this.indexElemSelecc = -1;              // ← desactiva la edición o eliminación
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListaProductos;
    private javax.swing.JButton btnListaVentas;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane tableVentaListaVenta;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTable tblVenta1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

private void totalPagar(){
    BigDecimal totalPagar = BigDecimal.ZERO;
    int numFila = tblVenta.getRowCount();
    for (int i = 0; i < numFila; i++) {
        BigDecimal subtotal = new BigDecimal(tblVenta.getModel().getValueAt(i, 5).toString());
        totalPagar = totalPagar.add(subtotal);
    }
    txtTotalPagar.setText(totalPagar.setScale(2, RoundingMode.HALF_UP).toString());
}
private void limpiar(){
   this.txtProducto.setText("");
    this.txtCantidad.setText("");
    this.txtPrecio.setText("");
    this.txtStock.setText("");
}
private void limpiaralvender(){
    this.cmbTipoPago.setSelectedIndex(-1);
   this.txtCliente.setText("");
    
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
            throw new IllegalArgumentException("Debe seleccionar un metodo de pago para realizar la venta.");
        }

    } catch (Exception e) {
        throw e;
    }
    }
 

 private void cargarTablaVenta() {
    try {
        BDGestionarDetalleVenta bd_gestProd = new BDGestionarDetalleVenta();
        ArrayList<DetalleVenta> arrPro = bd_gestProd.listar();

        System.out.println("Filas obtenidas de la BD: " + arrPro.size()); // 👈

        if (arrPro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron datos.");
        }

        this.tblv.setListadoProducto(arrPro);
    } catch (Exception e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(
            this,
            "ERROR: " + e.getMessage(),
            "Error de Base de Datos",
            JOptionPane.ERROR_MESSAGE);
    }
}
 public void cargarTabla(){
    
     ArrayList arrPro = null;
        try {
            BDGestionarClientes bd_gestProd = new BDGestionarClientes();
            arrPro = bd_gestProd.listar();
            this.mtc.setListadoClientes(arrPro);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
        }
}
 private void limpiarFormulario() {
        this.txtNombres.setText("");
        this.txtApellidos.setText("");
        this.txtDNI.setText("");
        this.txtTelefono.setText("");
    }

    private void activarControles(boolean estado) {
        this.txtNombres.setEnabled(estado);
        this.txtApellidos.setEnabled(estado);
        this.txtDNI.setEnabled(estado);
        this.btnGuardar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.txtTelefono.setEnabled(estado);
        this.btnEliminar.setEnabled(!estado);
        this.btnModificar.setEnabled(!estado);
}
    private void validarCliente() {
    try {
        if (txtNombres.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Nombre no puede estar vacío.");
        }
        if (txtApellidos.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Apellido no puede estar vacío.");
        }
        if (txtDNI.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo DNI no puede estar vacío.");
        }
        if (!txtDNI.getText().trim().matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe contener exactamente 8 dígitos numéricos.");
        }
        if (txtTelefono.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo Teléfono no puede estar vacío.");
        }
        if (!txtTelefono.getText().trim().matches("9\\d{8}")) {
            throw new IllegalArgumentException("El teléfono debe tener 9 dígitos y empezar con '9'.");
        }

    } catch (Exception e) {
        throw e;
    }
}
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
     public void pdf() {
    try {
        // Crear nombre único para el PDF con fecha y hora
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String carpetaDescargas = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
        File file = new File(carpetaDescargas + "venta_" + timestamp + ".pdf");
        FileOutputStream archivo = new FileOutputStream(file);
        Document doc = new Document();
        PdfWriter.getInstance(doc, archivo);
        doc.open();

        // Título
        Paragraph titulo = new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.",
                new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD));
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(titulo);

        // RUC y dirección
        Paragraph ruc = new Paragraph("RUC: 20539087135",
                new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
        ruc.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(ruc);

        Paragraph direccion = new Paragraph("Dirección: Av. Héroes del Cenepa 1154",
                new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
        direccion.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(direccion);

        // Subtítulo
        Paragraph sub = new Paragraph("COMPROBANTE DE VENTA\n\n",
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        sub.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(sub);

        // Fecha en español
        SimpleDateFormat sdf = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaFormateada = sdf.format(new Date());
        Paragraph fecha = new Paragraph("Fecha: " + fechaFormateada);
        fecha.setAlignment(Paragraph.ALIGN_RIGHT);
        doc.add(fecha);
        doc.add(Chunk.NEWLINE);

        // Cliente, Empleado y Tipo de pago
        BDGestionarClientes daoCliente = new BDGestionarClientes();
        Cliente cliente = daoCliente.obtenerPorNombre(txtCliente.getText());
        Empleado empleado = sesion.empleadoLogueado;
        String nombreCliente = cliente != null ? cliente.getNombre() + " " + cliente.getApellidos() : "";
        String nombreEmpleado = empleado.getNombreEmpleado() + " " + empleado.getApellidos();
        String metodoPago = cmbTipoPago.getSelectedItem().toString();

        Paragraph datos = new Paragraph("Cliente: " + nombreCliente +
                                        "\nEmpleado: " + nombreEmpleado +
                                        "\nMétodo de Pago: " + metodoPago);
        doc.add(datos);
        doc.add(Chunk.NEWLINE);

        // Tabla de productos
        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{3, 1, 1, 1});
        tabla.addCell("Producto");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio");
        tabla.addCell("Subtotal");

        DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            tabla.addCell(modelo.getValueAt(i, 0).toString()); // Producto
            tabla.addCell(modelo.getValueAt(i, 3).toString()); // Cantidad
            tabla.addCell(modelo.getValueAt(i, 4).toString()); // Precio
            tabla.addCell(modelo.getValueAt(i, 5).toString()); // Subtotal
        }

        doc.add(tabla);
        doc.add(Chunk.NEWLINE);

        // Total
        Paragraph total = new Paragraph("TOTAL A PAGAR: S/ " + txtTotalPagar.getText(),
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        total.setAlignment(Paragraph.ALIGN_RIGHT);
        doc.add(total);

        doc.close();
        archivo.close();

        // Abrir el PDF automáticamente
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar PDF: " + e.getMessage());
        e.printStackTrace();
    }
}
}



