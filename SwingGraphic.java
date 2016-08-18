package swing;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class SwingGraphic {

    public static void main(String[] args) {
        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        marco.add(panel);

    }

}

class Marco extends JFrame {

    public Marco() {
        setVisible(true);
        setSize(500, 300);
        setLocation(400, 200);
        setTitle("Mi ventana");

    }

}

class Panel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// Sin esto funciona, pero implementa así toda la potencia de Component
        g.drawString("Aprendiendo Swing...", 20, 20);
        g.drawRect(20, 20, 200, 200);
        g.drawArc(50, 50, 100, 150, 120, 200);
    }

}
