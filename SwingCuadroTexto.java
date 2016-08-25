// Cuadro de texto manejando DOCUMENT
package swingcuadrotexto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class SwingCuadroTexto {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("--- ERROR");
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

    public Panel() {
        JTextField field = new JTextField(20);
        Document document = field.getDocument();
        document.addDocumentListener(new Escucha());
        add(field);
    }

    private class Escucha implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Insertando...");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Borrando...");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

    }

}
