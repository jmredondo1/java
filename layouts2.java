// LAYOUTS 2
package layouts2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts2 {

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

        Panel1 p1 = new Panel1();
        Panel2 p2 = new Panel2();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

    }

}

class Panel1 extends JPanel {

    public Panel1() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Rojo"));
        add(new JButton("Verde"));

    }

}

class Panel2 extends JPanel {

    public Panel2() {
        setLayout(new BorderLayout());
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Amarillo"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);

    }

}
