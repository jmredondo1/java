// FOCO DE VENTANA
package eventosfocoventana;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

// Todo en la misma clase
public class FocoVentana extends JFrame implements WindowFocusListener {

    FocoVentana ventana1;
    FocoVentana ventana2;

    public static void main(String[] args) {
        new FocoVentana().iniciar();
    }

    public void iniciar() {
        // Ventana1
        ventana1 = new FocoVentana();
        ventana1.setBounds(300, 100, 600, 300);
        ventana1.setVisible(true);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.addWindowFocusListener(this);
        // Ventana2
        ventana2 = new FocoVentana();
        ventana2.setBounds(900, 100, 600, 300);
        ventana2.setVisible(true);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.addWindowFocusListener(this);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if (e.getSource() == ventana1) {
            ventana1.setTitle("Tengo el foco");
        }
        if (e.getSource() == ventana2) {
            ventana2.setTitle("Tengo el foco");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if (e.getSource() == ventana1) {
            ventana1.setTitle("");
        }
        if (e.getSource() == ventana2) {
            ventana2.setTitle("");
        }
    }

}
