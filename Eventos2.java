// Versi�n 2 de EVENTOS1. Crea una clase para tratar el COLOR
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
        setTitle("Botones y eventos 1");
        setBounds(700, 300, 500, 300);
        Panel p = new Panel();
        add(p);
    }

}

class Panel extends JPanel {

    JButton buttonRed = new JButton("Rojo");
    JButton buttonBlue = new JButton("Azul");
    JButton buttonYellow = new JButton("Amarillo");

    public Panel() {
        add(buttonBlue);
        add(buttonRed);
        add(buttonYellow);
        ColorFondo amarillo = new ColorFondo(Color.YELLOW);
        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo rojo = new ColorFondo(Color.RED);
        
        // A�ade un "listener" cada objeto que puede emitir un evento (addActionListener).
        // El evento es de tipo ACTION (ActionListener), hay optros de tipo ventana (maxim, minim...)
        buttonBlue.addActionListener(azul);
        buttonYellow.addActionListener(amarillo);
        buttonRed.addActionListener(rojo);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBlue) {
            this.setBackground(Color.BLUE);
        }
        if (e.getSource() == buttonYellow) {
            this.setBackground(Color.YELLOW);
        }
        if (e.getSource() == buttonRed) {
            this.setBackground(Color.RED);
        }
    }

    // Creo una clase interna para que pueda acceder al m�todo setBackground() que pertenece a JFrame
    // Adem�s la encapsulo (private) para impedir su acceso
    // Esta clase es la oyente e implementa el ActionListener con el m�todo actionPerformed(ActionEvent e) 
    private class ColorFondo implements ActionListener {

        private final Color colorDeFondo;

        public ColorFondo(Color c) {
            colorDeFondo = c;
        }

        // Implementaci�n del m�todo abstracto actionPerformed
        @Override
        public void actionPerformed(ActionEvent e) {
            // Puedo llamar a este m�todo que es de JFrame porque es una clase interna, 
            // si hubiese estado en el exterior, no podr�a haberlo llamado
            setBackground(colorDeFondo);
        }

    }
}
