package barraherramientas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BarraHerramientas {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        Frame mimarco = new Frame();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}

class Frame extends JFrame {

    private JPanel panel; // Se define aquí para que sea accesible

    public Frame() {
        setTitle("Marco con Barra");
        setBounds(500, 300, 600, 450);
        panel = new JPanel();
        add(panel);

        // configuración de acciones para el color. Una clase independiente, interna porque se usa varias veces
        Action accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/azul.gif"), Color.BLUE);
        Action accionVerde = new AccionColor("Verde", new ImageIcon("src/graficos/verde.gif"), Color.GREEN);
        Action accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/roja.gif"), Color.RED);
        // Acción para salir. Una clase anónima, porque solo se usa una vez
        Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/salir.gif")) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        // Menú
        JMenu menu = new JMenu("Color");
        menu.add(accionRojo);
        menu.add(accionVerde);
        menu.add(accionAzul);
        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Barra de herramientas desmontable
        JToolBar bar = new JToolBar();
        bar.add(accionRojo);
        bar.add(accionVerde);
        bar.add(accionAzul);
        bar.addSeparator();
        bar.add(accionSalir);

        add(bar, BorderLayout.NORTH);

    }

    private class AccionColor extends AbstractAction {

        // Al constructor de la AbstractAction le puedo pasar cuantos parámetros quiera en formato CLAVE,VALOR
        public AccionColor(String nombre, Icon icono, Color c) {
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
            putValue("Color", c);
        }

        // La acción a realizar
        public void actionPerformed(ActionEvent arg0) {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }

    }

}
