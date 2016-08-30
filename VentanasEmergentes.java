package ventanasemergentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanasEmergentes {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(VentanasEmergentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}

class Frame extends JFrame {

    public Frame() {
        setTitle("Ventanas emergentes");
        setBounds(10, 100, 500, 300);
        add(new Panel());
    }

}

class Panel extends JPanel {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    public Panel() {
        button1 = new JButton("Botón1");
        button2 = new JButton("Botón2");
        button3 = new JButton("Botón3");
        button4 = new JButton("Botón4");

        button1.addActionListener(new Accion());
        button2.addActionListener(new Accion());
        button3.addActionListener(new Accion());
        button4.addActionListener(new Accion());

        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    private class Accion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(button1)) {
                //nota: HAY QUE PASARLE EL COMPOLNENTE PADRE (Panel.this) PARA QUE SALGA EN EL CENTRO DE DICHO COMPONENTE
                JOptionPane.showMessageDialog(Panel.this, "Mensaje 1", "Título", 3);
            } else if (e.getSource().equals(button2)) {
                System.out.println(JOptionPane.showInputDialog(Panel.this, "Mensaje 2"));
            } else if (e.getSource().equals(button3)) {
                System.out.println(JOptionPane.showConfirmDialog(Panel.this, "Mensaje 3", "Título", 1));
            } else {
                System.out.println(JOptionPane.showOptionDialog(Panel.this, "Mensaje 4", "Título", 1, 1, null, null, null));
            }
        }
    }

}
