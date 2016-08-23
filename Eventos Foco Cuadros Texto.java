// EVENTOS DE FOCO OCN CUADROS DE TEXTO
package eventosfoco;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventosFoco {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setTitle("Eventos foco");
        setBounds(300, 300, 500, 300);
        add(new Panel());
        setVisible(true);

    }

}

class Panel extends JPanel {

    JTextField cuadro1;
    JTextField cuadro2;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null); // Invalido la colocacion de elemntos organizado
        cuadro1 = new JTextField();
        cuadro2 = new JTextField();
        cuadro1.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);
        add(cuadro1);
        add(cuadro2);
        Foco f = new Foco();
        cuadro1.addFocusListener(f);
        //cuadro2.addFocusListener(f);
    }

    // la hago como clase interna para poder acceder a cuadro1 y a cuadro2
    private class Foco implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Tiene el foco: " + e.getSource());
        }

        // Cuando pierde el foco, valida el email
        @Override
        public void focusLost(FocusEvent e) {
            //System.out.println("Pierde el foco: " + e.getSource());
            String email = cuadro1.getText();
            int test = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    test++;
                }
            }
            if(test==1) System.out.println("Email correcto"); else System.out.println("Email incorrecto");

        }

    }
}
