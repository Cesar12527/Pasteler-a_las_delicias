
package IGU;

import BDGestion.BDGestionEmpleados;
import BDGestion.BDGestionTipoRol;
import BDGestion.BDGestionUsuario;
import Entidades.Empleado;
import Entidades.Usuario;
import Entidades.TipoRol;
import Seguridad.sesion;
import IGU.Modelos.ModeloComboTipoRol;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JF_InicioSesion extends javax.swing.JFrame {
    ModeloComboTipoRol modeloComboTipoRol = new ModeloComboTipoRol();
    
    private int intentosFallidos = 0;
    public JF_InicioSesion() {
        initComponents();
        this.cargarComboTipoRol();
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        PasswordFieldContraseña = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPerfil = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Contraseña:");

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");

        jComboBoxPerfil.setModel(this.modeloComboTipoRol);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Perfil:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PasswordFieldContraseña)
                        .addComponent(jComboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
     
 if (!validarCamposSesion()) {
        return; // si falla la validación, no continúa
    }
    try {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(PasswordFieldContraseña.getPassword()).trim();
        String rolSeleccionado = jComboBoxPerfil.getSelectedItem().toString();
        String nombreEmpleado = txtNombre.getText().trim();

        // Paso 1: Validar usuario, clave y rol
        BDGestionUsuario bd_GU = new BDGestionUsuario();
        Usuario user = bd_GU.validarLogin(usuario, clave, rolSeleccionado);

        if (user == null) {
            intentosFallidos++;
            JOptionPane.showMessageDialog(this, "Usuario, contraseña o perfil incorrectos", "Acceso denegado", JOptionPane.WARNING_MESSAGE);
            txtUsuario.setText("");
            PasswordFieldContraseña.setText("");
            if (intentosFallidos >= 3) {
                JOptionPane.showMessageDialog(this, 
                        "Ha superado los intentos permitidos.\nEl sistema se cerrará por seguridad.", 
                        "Bloqueo de seguridad", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            return;
        }

        // Paso 2: Buscar al empleado por nombre
        BDGestionEmpleados daoEmp = new BDGestionEmpleados();
        Empleado empleado = daoEmp.obtenerPorNombre(nombreEmpleado);

        if (empleado == null) {
            JOptionPane.showMessageDialog(this, "Empleado no encontrado con ese nombre.");
            return;
        }

        // Paso 3: Verificar que el usuario del empleado sea el mismo que el logueado
        if (!empleado.getUsuario().getUsuario().equals(user.getUsuario())) {
            JOptionPane.showMessageDialog(this, "El nombre ingresado no corresponde con el usuario.");
            return;
        }

        // Paso 4: Validar que el rol del usuario coincida con el seleccionado
        if (!empleado.getUsuario().getTiporol().getNombre().equalsIgnoreCase(rolSeleccionado)) {
            JOptionPane.showMessageDialog(this, "El empleado no tiene el rol seleccionado.");
            return;
        }

        // Guardar el empleado logueado en sesión
        sesion.empleadoLogueado = empleado;

        // Abrir ventana según rol
        this.dispose();
        if (user.getTiporol().getId() == 1) {
            new MDI_MenuPrincipal().setVisible(true); // administrador
        } else {
            new Vendedor().setVisible(true); // otro rol (como cajero o vendedor)
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int opc = JOptionPane.showConfirmDialog(null,"¿Desea cerrar sesión?","Confirmar salida", 
                  JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
        if(opc == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JF_InicioSesion inicio = new JF_InicioSesion();           
                inicio.setLocationRelativeTo(null);
                inicio.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordFieldContraseña;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> jComboBoxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    private void cargarComboTipoRol(){  
    try {
        BDGestionTipoRol bd_GCP = new BDGestionTipoRol();
        ArrayList arrTD = bd_GCP.listar();
        this.modeloComboTipoRol.setListadoRol(arrTD);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                    this, 
                    "ERROR: " +e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
    }
    }

    private boolean validarCamposSesion() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(PasswordFieldContraseña.getPassword()).trim();
        String rol = jComboBoxPerfil.getSelectedItem().toString();
        
        if ( jComboBoxPerfil.getSelectedIndex() == 0 || rol.equals("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un rol válido.");
            jComboBoxPerfil.requestFocus();
            return false;
        }
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de usuario.");
            txtUsuario.requestFocus();
            return false;
        }
        if (clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña.");
            PasswordFieldContraseña.requestFocus();
            return false;
        }
        return true;
    }

}
