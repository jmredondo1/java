package swing;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Imagenes {

    public static void main(String[] args) {

        Marco1 m = new Marco1();
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Marco1 extends JFrame {

    public Marco1() {
        setTitle("Ventana con imagen");
        setBounds(50, 50, 500, 500);
        Panel1 p = new Panel1();
        add(p);
    }

}

class Panel1 extends JPanel {

    private Image imagen;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //File f = new File(System.getProperty("user.home") + "/Desktop/coche.png");
        File f = new File(System.getProperty("user.home") + "/Desktop/bola.png");
        try {
            imagen = ImageIO.read(f);
            System.out.println(f.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Imagen no se carga: " + ex.getMessage());;
        }
        
        g.drawImage(imagen, 5, 5, null);
        g.copyArea(5, 5, 20, 20, 200, 200);
    }

}