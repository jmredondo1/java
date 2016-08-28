package slider;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class Frame extends JFrame {

    public Frame() {
        setTitle("ComboBox");
        setBounds(300, 300, 500, 300);
        Panel p = new Panel();
        add(p);
        setVisible(true);
    }

}

class Panel extends JPanel {

    private JLabel label;
    private JSlider slider;

    public Panel() {
        setLayout(new BorderLayout());
        label = new JLabel("Hola Mundo Hola Mundo Hola Mundo ");
        add(label, BorderLayout.CENTER);

        slider = new JSlider(8, 50, 12);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Serif", Font.ITALIC, 10));
        slider.setSnapToTicks(true);

        JPanel panel2 = new JPanel();
        panel2.add(slider);
        add(panel2, BorderLayout.NORTH);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setFont(new Font("Serif", Font.PLAIN, slider.getValue()));
            }
        });

    }

}
