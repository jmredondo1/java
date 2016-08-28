package combo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Combo {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Frame extends JFrame {

    public Frame() throws HeadlessException {
        setTitle("ComboBox");
        setBounds(300, 300, 500, 300);
        Panel p = new Panel();
        add(p);
        setVisible(true);
    }

}

class Panel extends JPanel {

    private JLabel label;
    private JComboBox comboBox;

    public Panel() {
        setLayout(new BorderLayout());
        label = new JLabel("Hola Mundo Hola Mundo Hola Mundo ");
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        add(label, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        comboBox = new JComboBox();
        String[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fuente : fuentes) {
            comboBox.addItem(fuente);
        }
        panel2.add(comboBox);
        add(panel2, BorderLayout.NORTH);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font((String)comboBox.getSelectedItem(), Font.PLAIN, 18));
            }
        });

    }

}
