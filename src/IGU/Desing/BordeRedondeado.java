package IGU.Desing;

import java.awt.*; // Esto ya importa Graphics2D y RenderingHints
import javax.swing.border.Border;

public class BordeRedondeado implements Border {
    private int radio;
    private int grosorBorde = 1; // Puedes ajustar el grosor de la línea del borde aquí también si usas BasicStroke

    public BordeRedondeado(int radio) {
        this.radio = radio;
    }
    
    // Constructor con grosor de borde personalizable
    public BordeRedondeado(int radio, int grosorBorde) {
        this.radio = radio;
        this.grosorBorde = grosorBorde;
    }


    @Override
    public Insets getBorderInsets(Component c) {
        // Aumenta el padding para que el texto no se corte
        // Considera el radio y un pequeño extra para el grosor de la línea y el espacio visual.
        int padding = radio / 2 + grosorBorde + 2; 
        // Se puede ajustar el '2' final para dar más o menos espacio
        return new Insets(padding, padding, padding, padding);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create(); // Usa g.create() para no afectar el Graphics original
        
        // --- LA LÍNEA CORREGIDA ESTÁ AQUÍ ---
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Suavizar bordes

        g2.setColor(Color.GRAY); // Color del borde
        g2.setStroke(new BasicStroke(grosorBorde)); // Grosor del borde

        // Dibuja el borde redondeado
        int arc = radio;
        int adjust = grosorBorde / 2; 
        g2.drawRoundRect(x + adjust, y + adjust, width - grosorBorde, height - grosorBorde, arc, arc);

        g2.dispose(); // Libera los recursos del objeto Graphics2D temporal
    }
}