// EVENTOS MÚLTIPLES FUENTES
package eventosmultiplesfuentes;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.text.StyleConstants;

public class EventosMultiplesFuentes {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

}

class Frame extends JFrame {

    public Frame() {
        setTitle("Eventos múltiples fuentes");
        setBounds(600, 300, 600, 300);
        Panel p = new Panel();
        add(p);
    }

}

class Panel extends JPanel {

    public Panel() {

        Accion accionRojo = new Accion("Rojo", new ImageIcon("src/eventosmultiplesfuentes/roja.gif"), Color.RED);
        Accion accionVerde = new Accion("Verde", new ImageIcon("src/eventosmultiplesfuentes/verde.gif"), Color.GREEN);
        Accion accionAzul = new Accion("Azul", new ImageIcon("src/eventosmultiplesfuentes/azul.gif"), Color.BLUE);

        add(new JButton(accionRojo));
        add(new JButton(accionVerde));
        add(new JButton(accionAzul));
        
        InputMap map = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        //KeyStroke keyRojo = KeyStroke.getKeyStroke("ctrl R");
        map.put(KeyStroke.getKeyStroke("ctrl R"), "FondoRojo");
        map.put(KeyStroke.getKeyStroke("ctrl V"), "FondoVerde");
        map.put(KeyStroke.getKeyStroke("ctrl A"), "FondoAzul");
        ActionMap actionMap = getActionMap();
        actionMap.put("FondoRojo", accionRojo);
        actionMap.put("FondoVerde", accionVerde);
        actionMap.put("FondoAzul", accionAzul);

    }

    // Clase interna para que SETBACKGROUND acceda al color de fondo de PANEL
    private class Accion extends AbstractAction {

        public Accion(String nombre, Icon icon, Color color) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Poner en color " + nombre);
            putValue("ColorDeFondo", color);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("ColorDeFondo");
            setBackground(c);
            System.out.println("Nombre: "+getValue(NAME)+" Descripción: "+getValue(SHORT_DESCRIPTION));
        }

    }

}
