package swingcuadrotexto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SwingCuadroTexto2 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("--- ERROR");;
        }
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Frame extends JFrame {

    public Frame() {
        setTitle("Cuadro de Texto");
        setBounds(100, 200, 500, 300);
        add(new Panel());
        setVisible(true);
    }
}

class Panel extends JPanel {

    // Lo defino fuera para que la clase interna tenga acceso
    JPasswordField password = new JPasswordField(15);

    public Panel() {
        // panel general dividido en cinco zonas (NORTH,SOUTH,EAST,WEST CENTER)
        setLayout(new BorderLayout());
        // Un nuevo panel en el NORTH de tipo GRID de 2x2
        JPanel superior = new JPanel();
        superior.setLayout(new GridLayout(2, 2));
        add(superior, BorderLayout.NORTH);

        JLabel label1 = new JLabel("USUARIO");
        JLabel label2 = new JLabel("PASSWORD");
        JTextField usuario = new JTextField(15);
        
        Password evento = new Password();
        password.getDocument().addDocumentListener(evento);

        superior.add(label1);
        superior.add(usuario);
        superior.add(label2);
        superior.add(password);

        JButton button = new JButton("Aceptar");
        add(button, BorderLayout.SOUTH);

    }

    // Clase interna para acceder al cuadro de la password
    private class Password implements DocumentListener {

        // Si la password está entre 8 y 12 es correcta, si no incorrecta
        @Override
        public void insertUpdate(DocumentEvent e) {
            char[] contraseña;
            contraseña = password.getPassword();
            if (contraseña.length<8 || contraseña.length>12) {
                password.setBackground(Color.RED);
            }else{
            password.setBackground(Color.WHITE);
            }
            
            
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char[] contraseña;
            contraseña = password.getPassword();
            if (contraseña.length<8 || contraseña.length>12) {
                password.setBackground(Color.RED);
            }else{
            password.setBackground(Color.WHITE);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

    }

}
