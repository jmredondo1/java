// Eventos de ventana con ADAPTADOR
package eventos2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class Eventos2 {

    public static void main(String[] args) {
        // Ventana1
        Frame f1 = new Frame();
        f1.setTitle("Ventana1");
        f1.setBounds(300, 300, 500, 300);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Ventana2
        Frame f2 = new Frame();
        f2.setTitle("Ventana2");
        f2.setBounds(900, 300, 500, 300);
        f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

class Frame extends JFrame {

    public Frame() {
        // Como tengo 2 ventanas con distintas características, lo hago cuando las instacio y no en el constructor
        //        setTitle("Eventos de ventana 2");
        //        setBounds(700, 300, 500, 300);
        setVisible(true);
        // Ventana oyente = new Ventana();
        addWindowListener(new Ventana());
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

}

// Eventos de ventana
/*
class Ventana implements WindowListener {
    // No hay por qué usar todos los métodos. Solo los que vayamos a utilizar

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana cerrando");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println(e.getSource() + " --> La ventana ha sido cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana restaurada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println(e.getSource() + " --> Ventana desactivada");
    }

}
 */
// Uso un ADAPTADOR para no tener que implementar todos los métodos de la interface anterior. Es para ahorrar código.
// Se trata de una clase ABSTRACTA, en lugar de una INTERFACE, por lo que solo se implementa el método que se quiera usar
class Ventana extends WindowAdapter {

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(e.getWindow() +" --> Ventana minimizada"); 
        
    }

}
