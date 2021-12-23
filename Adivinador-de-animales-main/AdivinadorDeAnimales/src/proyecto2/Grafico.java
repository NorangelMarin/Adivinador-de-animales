package proyecto2;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Jenderson Quintero y Norangel Marin.
 */
public class Grafico extends JPanel {

    private Arbol arbol;
    public static final int ancho = 80;
    public static final int alto = 25;
    public static final int r = alto / 2;
    public static final int espaciado = 60;

    /**
     * Actualiza el arbol.
     * @param a Arbol
     */
    public void setArbol(Arbol a) {
        this.setBackground(new Color(186, 255, 172));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1500, 500));
        arbol = a;
        repaint();
    }

    /**
     * Método para pintar en el panel.
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, (getWidth() - 50) / 2, 20, arbol.getRaiz());
    }

    /**
     * Iniciador de objetos que se pintará en el panel.
     * @param g Graphics
     * @param x int
     * @param y int
     * @param n Nodo
     */
    private void pintar(Graphics g, int x, int y, Nodo n) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        if (n == null) {

        } else {
            String[] letras = n.getDato().split("");
            int aExtra = n.getNodos(n) * (espaciado / 2);

            g.setColor(new Color(47,162,0));
            g.fillRect(x, y, ancho, alto);
            g.setColor((Color.BLACK));
            g.drawRect(x, y, ancho, alto);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.BOLD, 12));
            if (letras.length >= 2 && letras.length <= 6) {
                g.drawString(n.getDato(), x + 26, y + 17);
            } else if (letras.length > 6 && letras.length <= 15) {
                g.drawString(n.getDato(), x + 10, y + 17);
            }else{
                g.drawString(n.getDato(), x-15, y + 17);
            }
            
            g.setColor(new Color(56,22,12));
            g2d.setStroke(new BasicStroke(2));
            if (n.getIzq() != null) {
                g.drawLine(x + r - 14, y + r, x - espaciado - aExtra + r + 10, y + espaciado + r - 10);
                g.setColor(Color.BLUE);
                g.drawString("NO", (((x + r - 14)+(x - espaciado - aExtra + r + 10))/2)-17, ((y + r)+(y + espaciado + r - 10))/2);
            }
            if (n.getDer() != null) {
                g.setColor(new Color(56,22,12));
                g.drawLine(x + r + 70, y + r, x + espaciado + aExtra + r + 35, y + espaciado + r - 10);
                g.setColor(Color.BLUE);
                g.drawString("SI", ((x + r + 70)+(x + espaciado + aExtra + r + 35))/2, ((y + r)+(y + espaciado + r - 10))/2);
            }
            pintar(g, x - espaciado - aExtra, y + espaciado, n.getIzq());
            pintar(g, x + espaciado + aExtra, y + espaciado, n.getDer());
        }
    }
}
