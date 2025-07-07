
package IGU.Desing;


import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class ComboBoxPersonalizado {

    public static void personalizarCombo(JComboBox combo) {
        combo.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton boton = new JButton();
                boton.setBorder(BorderFactory.createEmptyBorder());
                boton.setContentAreaFilled(false);

                // Cambia este ícono por el tuyo si lo tienes
                boton.setIcon(new ImageIcon("src/IGU/flecha-hacia-abajo.png"));
                return boton;
            }
        });

        combo.setBackground(Color.WHITE);
        combo.setForeground(new Color(60, 34, 25));
        combo.setBorder(new BordeRedondeado(15));
    }
}
