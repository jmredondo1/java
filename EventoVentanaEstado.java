// Detectar el cambio de estado de las ventanas
package ventanasestado;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

public class VentanasEstado {

    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setVisible(true);
        setBounds(300, 200, 500, 300);
        //Instancia de el cambio de estado
        CambioDeEstado estado = new CambioDeEstado();
        // Añadir oyente
        addWindowStateListener(estado);
    }

}

// Clase oyente
class CambioDeEstado implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {
        //System.out.println("Estado cambiado: ANTIGUO: "+e.getOldState()+" NUEVO: "+e.getNewState());
        String mensaje = "";
        if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
            mensaje = "MAXIMIZED_BOTH";
        }
        if (e.getNewState() == JFrame.ICONIFIED) {
            mensaje = "ICONIFIED";
        }
        if (e.getNewState() == JFrame.NORMAL) {
            mensaje = "NORMAL";
        }

        System.out.println(mensaje);
    }

}
