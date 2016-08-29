package menu;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {

    public static void main(String[] args) {

        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setTitle("Menu");
        setBounds(100, 100, 500, 300);
        Panel p = new Panel();
        add(p);
        setVisible(true);
    }

}

class Panel extends JPanel {

    public Panel() {
        JMenuBar bar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEdicion = new JMenu("Edición");
        JMenu menuHerramientas = new JMenu("Herramientas");
        JMenu menuOpciones = new JMenu("Opciones"); // Lleva un submenu

        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar Como...");
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("Pegar");
        JMenuItem generales = new JMenuItem("Generales");
        JMenuItem opcion1 = new JMenuItem("Opción1");
        JMenuItem opcion2 = new JMenuItem("Opción2");

        menuArchivo.add(guardar);
        menuArchivo.add(guardarComo);
        menuEdicion.add(cortar);
        menuEdicion.add(copiar);
        menuEdicion.add(pegar);
        menuOpciones.add(opcion1);
        menuOpciones.add(opcion2);
        menuEdicion.add(menuOpciones);
        menuHerramientas.add(generales);

        bar.add(menuArchivo);
        bar.add(menuEdicion);
        bar.add(menuHerramientas);

        add(bar);
    }

}
