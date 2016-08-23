// EVENTO DE RATÓN CON ADAPTADOR
package eventosraton;

import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class EventosRaton {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setTitle("Eventos ratón");
        setBounds(300, 300, 500, 300);
        setVisible(true);

        Raton r = new Raton();
        addMouseListener(r);
    }

}

// Heredo la clase adaptadora en lugar de implementar la interfaz, locual no me obliga a implementar todos los métodos.
class Raton extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getModifiersEx());
        if (e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) System.out.println("Botón izquierdo");
        if (e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) System.out.println("Botón central");
        if (e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) System.out.println("Botón derecho");
    }

    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); 
        System.out.println("X:"+e.getX()+" Y:"+e.getY());
        System.out.println(e.getClickCount());
    }
    */
    
}
