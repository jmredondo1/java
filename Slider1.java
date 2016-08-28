package slider;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Slider {
    
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
    
    public Panel() {
        JSlider slider = new JSlider();
        //slider.setOrientation(SwingConstants.VERTICAL);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        add(slider);
    }
    
}
