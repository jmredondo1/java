package eventos1;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Eventos1 {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setTitle("Eventos1");
        setBounds(700, 300, 500, 300);
        Panel panel = new Panel();
        add(panel);
    }

}

class Panel extends JPanel implements ActionListener {

    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");

    public Panel() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        botonAzul.addActionListener((ActionListener) this);
        botonAmarillo.addActionListener((ActionListener) this);
        botonRojo.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object botonPulsado = e.getSource();
        if (botonPulsado == botonAzul) {
            this.setBackground(Color.BLUE);
        } else if (botonPulsado == botonAmarillo) {
            this.setBackground(Color.YELLOW);
        } else {
            this.setBackground(Color.RED);
        }
    }

}
