
package IGU;

import BDGestion.BDComboboxCategoriaProducto;
import BDGestion.BDGestionEmpleados;
import BDGestion.BDGestionarDetalleVenta;
import BDGestion.BDGestionarProductos;
import BDGestion.BDGestionarVenta;
import Entidades.CategoriaProducto;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Venta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author obbtu
 */
public class JIF_Reportes extends javax.swing.JInternalFrame {
private static JIF_Reportes instancia;
    private JPopupMenu popupSugerencias = new JPopupMenu();
    private JList<String> listaSugerencias = new JList<>();
    private DefaultListModel<String> modeloSugerencias = new DefaultListModel<>();
    
    private JIF_Reportes() {
        initComponents();
        tblreportes.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
        @Override
        protected int calculateTabAreaHeight(int tabPlacement, int runCount, int maxTabHeight) {
            return 0;
        }
    });
        listaSugerencias.setModel(modeloSugerencias);
listaSugerencias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
popupSugerencias.add(new javax.swing.JScrollPane(listaSugerencias));
txtVentaemp.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasEmpleado(); // ✅ solo clientes
    }
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasEmpleado();
    }
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasEmpleado();
    }
});
txtVentacat.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCategoría(); // ✅ solo clientes
    }
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCategoría();
    }
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        mostrarSugerenciasCategoría();
    }
});



txtVentaemp.addKeyListener(new java.awt.event.KeyAdapter() {
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
txtVentacat.addKeyListener(new java.awt.event.KeyAdapter() {
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
public static JIF_Reportes getInstancia(){
        
        if( instancia == null || instancia.isClosed() ){
            instancia = new JIF_Reportes();
        } 
        return instancia;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblreportes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtVentaemp = new javax.swing.JTextField();
        btnVentaemp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnProdvend = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnProdmenos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtVentacat = new javax.swing.JTextField();
        btnVentacat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnStock = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        txtVentaemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVentaempKeyPressed(evt);
            }
        });

        btnVentaemp.setText("Generar reporte");
        btnVentaemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaempActionPerformed(evt);
            }
        });

        jLabel1.setText("Reporte de ventas por empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVentaemp, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVentaemp)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVentaemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentaemp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblreportes.addTab("tab1", jPanel1);

        btnProdvend.setText("Generar reporte");
        btnProdvend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdvendActionPerformed(evt);
            }
        });

        jLabel5.setText("Reporte de producto más vendido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnProdvend)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnProdvend)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tblreportes.addTab("tab2", jPanel2);

        btnProdmenos.setText("Generar reporte");
        btnProdmenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdmenosActionPerformed(evt);
            }
        });

        jLabel4.setText("Reporte de producto menos vendido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProdmenos)
                    .addComponent(jLabel4))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnProdmenos)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tblreportes.addTab("tab3", jPanel3);

        txtVentacat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVentacatActionPerformed(evt);
            }
        });
        txtVentacat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVentacatKeyPressed(evt);
            }
        });

        btnVentacat.setText("Generar reporte");
        btnVentacat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentacatActionPerformed(evt);
            }
        });
        btnVentacat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnVentacatKeyPressed(evt);
            }
        });

        jLabel3.setText("Reporte de ventas por categoría");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVentacat))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtVentacat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVentacat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentacat)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tblreportes.addTab("tab4", jPanel4);

        btnStock.setText("Generar reporte");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });

        jLabel2.setText("Reporte del stock actual");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStock)
                    .addComponent(jLabel2))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(btnStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblreportes.addTab("tab5", jPanel5);

        jButton1.setText("Venta por empleado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Producto más vendido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Producto menos vendido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Venta por categoría");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Stock actual");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblreportes, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(764, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblreportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tblreportes.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtVentacatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVentacatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentacatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tblreportes.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tblreportes.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tblreportes.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       tblreportes.setSelectedIndex(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtVentaempKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaempKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // ✅ Si hay un cliente seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionar(); // <--- Aquí se oculta el popup y se asigna
            return;
        }
         }
    }//GEN-LAST:event_txtVentaempKeyPressed

    private void btnVentaempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaempActionPerformed
        try {
        String nombre = txtVentaemp.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de empleado.");
            return;
        }

        BDGestionEmpleados daoEmp = new BDGestionEmpleados();
        Empleado emp = daoEmp.obtenerPorNombre(nombre);

        if (emp == null) {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
            return;
        }

        BDGestionarVenta daoVenta = new BDGestionarVenta();
        ArrayList<Venta> ventas = daoVenta.listarPorEmpleado(emp.getIdEmpleado());

        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ventas registradas para este empleado.");
            return;
        }

        
 generarReporteVentasEmpleado(nombre);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_btnVentaempActionPerformed

    private void btnProdvendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdvendActionPerformed
       generarReporteProductoMasVendido(); // TODO add your handling code here:
    }//GEN-LAST:event_btnProdvendActionPerformed

    private void btnProdmenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdmenosActionPerformed
       generarReporteProductoMenosVendido(); // TODO add your handling code here:
    }//GEN-LAST:event_btnProdmenosActionPerformed

    private void txtVentacatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentacatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // ✅ Si hay un cliente seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionarcat(); // <--- Aquí se oculta el popup y se asigna
            return;
        }
         }
    }//GEN-LAST:event_txtVentacatKeyPressed

    private void btnVentacatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnVentacatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // ✅ Si hay un cliente seleccionado en la lista de sugerencias
        if (popupSugerencias.isVisible() && listaSugerencias.getSelectedIndex() >= 0) {
            seleccionar(); // <--- Aquí se oculta el popup y se asigna
            return;
        }
         }
    }//GEN-LAST:event_btnVentacatKeyPressed

    private void btnVentacatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentacatActionPerformed
        

        try {
    String nombreCategoria = txtVentacat.getText().trim();
    if (nombreCategoria.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el nombre de la categoría.");
        return;
    }

    BDComboboxCategoriaProducto daoCat = new BDComboboxCategoriaProducto();
    CategoriaProducto categoria = daoCat.obtenerpornombre(nombreCategoria);
    if (categoria == null) {
        JOptionPane.showMessageDialog(this, "Categoría no encontrada.");
        return;
    }

    // Si existe la categoría, generar el PDF
    generarReporteVentasPorCategoria(nombreCategoria);

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error al generar reporte: " + e.getMessage());
    e.printStackTrace();
}
 
    }//GEN-LAST:event_btnVentacatActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        generarReporteStockProductos();
    }//GEN-LAST:event_btnStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProdmenos;
    private javax.swing.JButton btnProdvend;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton btnVentacat;
    private javax.swing.JButton btnVentaemp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane tblreportes;
    private javax.swing.JTextField txtVentacat;
    private javax.swing.JTextField txtVentaemp;
    // End of variables declaration//GEN-END:variables
private void seleccionar() {
    String seleccionado = listaSugerencias.getSelectedValue();
    if (seleccionado != null) {
        txtVentaemp.setText(seleccionado);
        popupSugerencias.setVisible(false);
        txtVentaemp.requestFocus();
    }
}
private void seleccionarcat() {
    String seleccionado = listaSugerencias.getSelectedValue();
    if (seleccionado != null) {
        txtVentacat.setText(seleccionado);
        popupSugerencias.setVisible(false);
        txtVentacat.requestFocus();
    }
}
private void mostrarSugerenciasEmpleado() {
    String texto = txtVentaemp.getText().trim().toLowerCase();
    modeloSugerencias.clear();
    
    if (texto.length() < 1) {
        popupSugerencias.setVisible(false);
        return;
    }
    
    try {
        BDGestionEmpleados dao = new BDGestionEmpleados();
        ArrayList<Empleado> empleado = dao.listar();
        
        for (Empleado e : empleado) {
            String nombreCliente = e.getNombreEmpleado().toLowerCase();
            if (nombreCliente.contains(texto)) {
                modeloSugerencias.addElement(e.getNombreEmpleado());
            }
        }

        if (modeloSugerencias.isEmpty()) {
            popupSugerencias.setVisible(false);
        } else {
            listaSugerencias.setSelectedIndex(0);
            popupSugerencias.show(txtVentaemp, 0, txtVentaemp.getHeight());
            txtVentaemp.requestFocus();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar sugerencias: " + e.getMessage());
    }
    }
private void mostrarSugerenciasCategoría() {
    String texto = txtVentacat.getText().trim().toLowerCase();
    modeloSugerencias.clear();
    
    if (texto.length() < 1) {
        popupSugerencias.setVisible(false);
        return;
    }
    
    try {
        BDComboboxCategoriaProducto dao = new BDComboboxCategoriaProducto();
        ArrayList<CategoriaProducto> categoria = dao.listar();
        
        for (CategoriaProducto e : categoria) {
            String nombreCliente = e.getNombrecat().toLowerCase();
            if (nombreCliente.contains(texto)) {
                modeloSugerencias.addElement(e.getNombrecat());
            }
        }

        if (modeloSugerencias.isEmpty()) {
            popupSugerencias.setVisible(false);
        } else {
            listaSugerencias.setSelectedIndex(0);
            popupSugerencias.show(txtVentacat, 0, txtVentacat.getHeight());
            txtVentacat.requestFocus();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar sugerencias: " + e.getMessage());
    }
    }
public void generarReporteVentasEmpleado(String nombreEmpleado) {
    try {
        BDGestionEmpleados daoEmp = new BDGestionEmpleados();
        Empleado empleado = daoEmp.obtenerPorNombre(nombreEmpleado);
        BDGestionarVenta daoVenta = new BDGestionarVenta();
        ArrayList<Venta> ventas = daoVenta.listarPorEmpleado(empleado.getIdEmpleado());

        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El empleado no tiene ventas registradas.");
            return;
        }

        String baseNombre = empleado.getNombreEmpleado().replaceAll("\\s+", "_").toLowerCase();
        String carpeta = "src/pdf/";
        String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String nombreArchivoPDF = carpeta + "reporte_" + baseNombre + "_" + fechaHoy + ".pdf";
        File pdfFile = new File(nombreArchivoPDF);

        // Si ya existe, solo lo abrimos
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
            return;
        }

        // Verificación si está siendo utilizado por otro programa
        try (RandomAccessFile raf = new RandomAccessFile(pdfFile, "rw")) {
            // OK, no está bloqueado
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
                "Archivo en uso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Generar PDF
        try (FileOutputStream archivo = new FileOutputStream(pdfFile)) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Paragraph titulo = new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.",
                    new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD));
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(titulo);

            Paragraph sub = new Paragraph("REPORTE DE VENTAS POR EMPLEADO\n\n",
                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            sub.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(sub);

            Paragraph emp = new Paragraph("Empleado: " + empleado.getNombreEmpleado() + " " + empleado.getApellidos());
            doc.add(emp);
            doc.add(new Paragraph("Fecha de reporte: " + fechaHoy));
            doc.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{2, 3, 2, 1.5f, 1.5f});
            tabla.addCell("Fecha");
            tabla.addCell("Cliente");
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");

            float sumaTotal = 0f;
            for (Venta venta : ventas) {
                BDGestionarDetalleVenta daoDetalle = new BDGestionarDetalleVenta();
                ArrayList<DetalleVenta> detalles = daoDetalle.obtenerDetallesPorVenta(venta.getIdVenta());
                boolean primeraFila = true;
                for (DetalleVenta det : detalles) {
                    tabla.addCell(primeraFila ? venta.getFecha() : "");
                    if (primeraFila) {
                        if (venta.getCliente() != null && venta.getCliente().getNombre() != null) {
                            tabla.addCell(venta.getCliente().getNombre() + " " + venta.getCliente().getApellidos());
                        } else {
                            tabla.addCell("");
                        }
                    } else {
                        tabla.addCell("");
                    }
                    tabla.addCell(det.getProducto().getNombre());
                    tabla.addCell(String.valueOf(det.getCantidad()));
                    float precioUnitario = det.getCantidad() > 0 ? det.getSubTotal() / det.getCantidad() : 0;
                    tabla.addCell(String.format("S/ %.2f", precioUnitario));
                    primeraFila = false;
                }
                sumaTotal += venta.getTotal();
            }

            doc.add(tabla);
            doc.add(Chunk.NEWLINE);
            Paragraph total = new Paragraph("TOTAL VENDIDO: S/ " + String.format("%.2f", sumaTotal),
                    new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
            total.setAlignment(Paragraph.ALIGN_RIGHT);
            doc.add(total);

            doc.close();
        }

        Desktop.getDesktop().open(pdfFile);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar PDF: " + e.getMessage());
        e.printStackTrace();
    }
}
public void generarReporteProductoMasVendido() {
    try {
        BDGestionarDetalleVenta daoDetalle = new BDGestionarDetalleVenta();
        ArrayList<DetalleVenta> detalles = daoDetalle.listarTodos();
        if (detalles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay detalles de venta registrados.");
            return;
        }

        HashMap<String, Integer> contadorProductos = new HashMap<>();
        for (DetalleVenta d : detalles) {
            String nombreProd = d.getProducto().getNombre();
            int cantidad = d.getCantidad();
            contadorProductos.put(nombreProd, contadorProductos.getOrDefault(nombreProd, 0) + cantidad);
        }

        String productoMasVendido = null;
        int cantidadMax = 0;
        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
            if (entry.getValue() > cantidadMax) {
                cantidadMax = entry.getValue();
                productoMasVendido = entry.getKey();
            }
        }

        if (productoMasVendido == null) {
            JOptionPane.showMessageDialog(this, "No se pudo determinar el producto más vendido.");
            return;
        }

        String carpeta = "src/pdf/";
        String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String nombrePDF = carpeta + "producto_mas_vendido_" + fechaHoy + ".pdf";
        File pdfFile = new File(nombrePDF);

        // Si ya existe, abrirlo y salir (no se genera nada nuevo)
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
            return;
        }

        // Verificación si el archivo está abierto por otro programa
        try (RandomAccessFile raf = new RandomAccessFile(pdfFile, "rw")) {
            // OK: no está bloqueado
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
                    "Archivo en uso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Generar PDF
        try (FileOutputStream archivo = new FileOutputStream(pdfFile)) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Paragraph titulo = new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.",
                    new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            Paragraph subtitulo = new Paragraph("REPORTE: PRODUCTO MÁS VENDIDO\n\n",
                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(subtitulo);

            doc.add(new Paragraph("Fecha de reporte: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
            doc.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(60);
            tabla.setWidths(new float[]{4, 2});
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell("Producto");
            tabla.addCell("Cantidad Vendida");
            tabla.addCell(productoMasVendido);
            tabla.addCell(String.valueOf(cantidadMax));
            doc.add(tabla);

            doc.close();
        }

        Desktop.getDesktop().open(pdfFile);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar reporte: " + e.getMessage());
        e.printStackTrace();
    }
}

public void generarReporteProductoMenosVendido() {
    try {
        BDGestionarDetalleVenta daoDetalle = new BDGestionarDetalleVenta();
        ArrayList<DetalleVenta> detalles = daoDetalle.listarTodos();
        if (detalles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay detalles de venta registrados.");
            return;
        }

        HashMap<String, Integer> contadorProductos = new HashMap<>();
        for (DetalleVenta d : detalles) {
            String nombreProd = d.getProducto().getNombre();
            int cantidad = d.getCantidad();
            contadorProductos.put(nombreProd, contadorProductos.getOrDefault(nombreProd, 0) + cantidad);
        }

        String productoMenosVendido = null;
        int cantidadMin = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : contadorProductos.entrySet()) {
            if (entry.getValue() < cantidadMin) {
                cantidadMin = entry.getValue();
                productoMenosVendido = entry.getKey();
            }
        }

        if (productoMenosVendido == null) {
            JOptionPane.showMessageDialog(this, "No se pudo determinar el producto menos vendido.");
            return;
        }

        String carpeta = "src/pdf/";
        String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String nombrePDF = carpeta + "producto_menos_vendido_" + fechaHoy + ".pdf";
        File pdfFile = new File(nombrePDF);

        // Si ya existe, solo abrir
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
            return;
        }

        // Verificar si el archivo está en uso
        try (RandomAccessFile raf = new RandomAccessFile(pdfFile, "rw")) {
            // OK
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
                "Archivo en uso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileOutputStream archivo = new FileOutputStream(pdfFile)) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            doc.add(new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.", new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD)));
            doc.add(new Paragraph("REPORTE: PRODUCTO MENOS VENDIDO\n\n", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
            doc.add(new Paragraph("Fecha de reporte: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
            doc.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(60);
            tabla.setWidths(new float[]{4, 2});
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell("Producto");
            tabla.addCell("Cantidad Vendida");
            tabla.addCell(productoMenosVendido);
            tabla.addCell(String.valueOf(cantidadMin));

            doc.add(tabla);
            doc.close();
        }

        Desktop.getDesktop().open(pdfFile);

    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null,
            "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
            "Archivo en uso", JOptionPane.WARNING_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar reporte: " + e.getMessage());
        e.printStackTrace();
    }
}
public void generarReporteVentasPorCategoria(String nombreCategoria) {
    try {
        BDComboboxCategoriaProducto daoCat = new BDComboboxCategoriaProducto();
        CategoriaProducto categoria = daoCat.obtenerpornombre(nombreCategoria);
        if (categoria == null) {
            JOptionPane.showMessageDialog(null, "Categoría no encontrada.");
            return;
        }

        BDGestionarDetalleVenta daoDetalle = new BDGestionarDetalleVenta();
        ArrayList<DetalleVenta> detalles = daoDetalle.listarTodos();
        if (detalles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay detalles de venta registrados.");
            return;
        }

        ArrayList<DetalleVenta> detallesCategoria = new ArrayList<>();
        float montoTotal = 0f;
        for (DetalleVenta d : detalles) {
            Producto p = d.getProducto();
            if (p.getCategoriaProducto() != null &&
                p.getCategoriaProducto().getId() == categoria.getId()) {
                detallesCategoria.add(d);
                montoTotal += d.getSubTotal();
            }
        }

        if (detallesCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas para esta categoría.");
            return;
        }

        String baseNombre = categoria.getNombrecat().replaceAll("\\s+", "_").toLowerCase();
        String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String carpeta = "src/pdf/";
        String nombreArchivoPDF = carpeta + "reporte_categoria_" + baseNombre + "_" + fechaHoy + ".pdf";
        File pdfFile = new File(nombreArchivoPDF);

        // Si ya existe, solo abrir
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
            return;
        }

        // Verificar si está abierto en otro programa
        try (RandomAccessFile raf = new RandomAccessFile(pdfFile, "rw")) {
            // OK
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
                "Archivo en uso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileOutputStream archivo = new FileOutputStream(pdfFile)) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            doc.add(new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.",
                    new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD)));
            doc.add(new Paragraph("REPORTE DE VENTAS POR CATEGORÍA\n\n",
                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
            doc.add(new Paragraph("Categoría: " + categoria.getNombrecat()));
            doc.add(new Paragraph("Fecha de reporte: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
            doc.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{5, 2, 2});
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Subtotal (S/.)");

            for (DetalleVenta d : detallesCategoria) {
                tabla.addCell(d.getProducto().getNombre());
                tabla.addCell(String.valueOf(d.getCantidad()));
                tabla.addCell(String.format("S/ %.2f", d.getSubTotal()));
            }

            doc.add(tabla);
            doc.add(Chunk.NEWLINE);

            Paragraph total = new Paragraph("TOTAL VENDIDO EN CATEGORÍA: S/ " + String.format("%.2f", montoTotal),
                    new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD));
            total.setAlignment(Paragraph.ALIGN_RIGHT);
            doc.add(total);

            doc.close();
        }

        Desktop.getDesktop().open(pdfFile);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        e.printStackTrace();
    }
}
public void generarReporteStockProductos() {
    try {
        BDGestionarProductos daoProd = new BDGestionarProductos();
        ArrayList<Producto> productos = daoProd.listar();
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String fechaHoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String carpeta = "src/pdf/";
        String nombreArchivoPDF = carpeta + "reporte_stock_productos_" + fechaHoy + ".pdf";
        File pdfFile = new File(nombreArchivoPDF);

        // Si ya existe, solo abrir
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
            return;
        }

        // Verificar si está abierto en otro programa
        try (RandomAccessFile raf = new RandomAccessFile(pdfFile, "rw")) {
            // Acceso válido
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
                "Archivo en uso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileOutputStream archivo = new FileOutputStream(pdfFile)) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            doc.add(new Paragraph("PASTELERÍA LAS DELICIAS E.I.R.L.", new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD)));
            doc.add(new Paragraph("REPORTE DE STOCK ACTUAL DE PRODUCTOS\n\n", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
            doc.add(new Paragraph("Fecha de reporte: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
            doc.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{4, 3, 2, 2});
            tabla.addCell("Producto");
            tabla.addCell("Categoría");
            tabla.addCell("Stock Actual");
            tabla.addCell("Precio (S/.)");

            ArrayList<Producto> productosPeligro = new ArrayList<>();

            for (Producto p : productos) {
                tabla.addCell(p.getNombre());
                tabla.addCell(p.getCategoriaProducto().getNombrecat());
                tabla.addCell(String.valueOf(p.getStock()));
                tabla.addCell(String.format("S/ %.2f", p.getPrecioUnitario()));

                if (p.getStock() <= 5) {
                    productosPeligro.add(p);
                }
            }

            doc.add(tabla);

            // Productos con bajo stock
            if (!productosPeligro.isEmpty()) {
                doc.add(Chunk.NEWLINE);
                doc.add(new Paragraph("PRODUCTOS POR AGOTARSE", new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.RED)));
                doc.add(Chunk.NEWLINE);

                PdfPTable tablaPeligro = new PdfPTable(4);
                tablaPeligro.setWidthPercentage(100);
                tablaPeligro.setWidths(new float[]{4, 3, 2, 2});
                tablaPeligro.addCell("Producto");
                tablaPeligro.addCell("Categoría");
                tablaPeligro.addCell("Stock");
                tablaPeligro.addCell("Precio (S/.)");

                for (Producto p : productosPeligro) {
                    tablaPeligro.addCell(p.getNombre());
                    tablaPeligro.addCell(p.getCategoriaProducto().getNombrecat());
                    tablaPeligro.addCell(String.valueOf(p.getStock()));
                    tablaPeligro.addCell(String.format("S/ %.2f", p.getPrecioUnitario()));
                }

                doc.add(tablaPeligro);
            }

            doc.close();
        }

        Desktop.getDesktop().open(pdfFile);

    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null,
            "El archivo PDF ya está abierto en otro programa.\nPor favor, ciérrelo antes de generar un nuevo reporte.",
            "Archivo en uso", JOptionPane.WARNING_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
        e.printStackTrace();
    }
}


}
