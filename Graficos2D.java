package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paneles {

    public static void main(String[] args) {
        MarcoTexto marcoTexto = new MarcoTexto();
        marcoTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}///

class MarcoTexto extends JFrame {

    public MarcoTexto() {

        setSize(400, 400);
        setLocation(400, 200);
        setTitle("Mi ventana");
        Panel panel = new Panel();
        add(panel);
        setVisible(true);

    }

}

class Panel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawRect(100, 100, 50, 50);
        g.drawArc(20, 50, 60, 80, 10, 90);
        g.drawString("Hola Mundo...", 200, 50);

        // Convierte g en g2D para usar las clases 2D más potentes
        Graphics2D g2D = (Graphics2D) g;

        //Un rectángulo
        Rectangle2D rectangulo2D = new Rectangle2D.Double(100, 100, 200, 150);
        g2D.draw(rectangulo2D);
        //Una elipse
        Ellipse2D elipse2D = new Ellipse2D.Double(100, 150, 200, 200);
        g2D.draw(elipse2D);
        //Una línea
        g2D.draw(new Line2D.Double(10, 10, 100, 100));

        //Centros
        double centroX = rectangulo2D.getCenterX();
        double centroY = rectangulo2D.getCenterY();

        //Elipse
        double radio = 150;
        Ellipse2D ellipse2D = new Ellipse2D.Double(centroX, centroY, centroY - radio, centroY - radio);
        g2D.draw(ellipse2D);
    }

}
