
package IGU.Desing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanaderiaButton {
    
    // Paleta de colores para panadería
    private static final Color MARRON_OSCURO = new Color(101, 67, 33);
    private static final Color MARRON_CLARO = new Color(160, 116, 78);
    private static final Color DORADO = new Color(184, 134, 11);
    private static final Color ROJO_CEREZA = new Color(185, 28, 28);
    private static final Color VERDE_MENTA = new Color(34, 139, 34);
    
    /**
     * Método principal - aplica estilo según el tipo de botón
     * Tipos: "ventas", "productos", "clientes", "reportes", "salir"
     */
    public static void aplicarEstilo(JButton boton, String tipo) {
        Color colorBase = obtenerColor(tipo);
        
        boton.setBackground(colorBase);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(aclarar(colorBase));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorBase);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                boton.setBackground(oscurecer(colorBase));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                boton.setBackground(aclarar(colorBase));
            }
        });
    }
    
    private static Color obtenerColor(String tipo) {
        switch (tipo.toLowerCase()) {
            case "ventas":
            case "nueva venta":
                return DORADO;
            case "productos":
            case "lista de productos":
                return MARRON_CLARO;
            case "clientes":
                return MARRON_OSCURO;
            case "reportes":
            case "lista de ventas":
                return VERDE_MENTA;
            case "salir":
                return ROJO_CEREZA;
            default:
                return MARRON_CLARO;
        }
    }
    
    private static Color aclarar(Color color) {
        float factor = 1.2f;
        int r = Math.min(255, (int)(color.getRed() * factor));
        int g = Math.min(255, (int)(color.getGreen() * factor));
        int b = Math.min(255, (int)(color.getBlue() * factor));
        return new Color(r, g, b);
    }
    
    private static Color oscurecer(Color color) {
        float factor = 0.8f;
        int r = (int)(color.getRed() * factor);
        int g = (int)(color.getGreen() * factor);
        int b = (int)(color.getBlue() * factor);
        return new Color(r, g, b);
    }
}