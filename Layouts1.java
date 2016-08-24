// LAYOUTS 1
package layouts1;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts1 {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}

class Frame extends JFrame {

    public Frame() {
        setTitle("Layout1");
        setBounds(100, 100, 500, 300);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
        Panel p = new Panel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(p);

    }

}

class Panel extends JPanel {

    public Panel() {
        add(new JButton("Rojo"));
        add(new JButton("Verde"));
        add(new JButton("Azul"));
    }

}
