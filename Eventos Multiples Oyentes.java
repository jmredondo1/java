// UNA FUENTE DE EVENTO MÚLTIPLES OYENTES
package eventosmultiplesoyentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventosMultiplesOyentes {

    public static void main(String[] args) {

        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}

// Ventana principal
class Frame extends JFrame {

    public Frame() {
        setTitle("Múltiples oyentes");
        setBounds(500, 100, 500, 300);
        add(new Panel());
    }

}

// panel que alberga los botones
class Panel extends JPanel {

    //Lo defino fuera del constructor para poder tener acceso desde las clases internas
    private final JButton botonCerrar;

    public Panel() {
        JButton botonNuevo = new JButton("Nueva ventana");
        botonCerrar = new JButton("Cerrar todas las ventanas");
        add(botonNuevo);
        add(botonCerrar);

        //Oyente o = new Oyente();
        botonNuevo.addActionListener(new Oyente());
    }

    private class Oyente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Ventana v = new Ventana(botonCerrar);
            v.setVisible(true);
        }

    }

}

class Ventana extends JFrame {

    static int contador = 0;

    public Ventana(JButton cerrar) {
        contador++;
        setTitle("Ventana " + contador);
        setBounds(40 * contador, 40 * contador, 200, 100);
        //CerrarVentanas cv = new CerrarVentanas();
        cerrar.addActionListener(new CerrarVentana());
    }

    private class CerrarVentana implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }

}
