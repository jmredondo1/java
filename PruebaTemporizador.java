package java221;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {

    public static void main(String[] args) {
        
        Hora listener = new Hora();
        //ActionListener listener = new Hora(); //también funcionaría
        Timer timer = new Timer(2000, listener);
        timer.start();
        
        JOptionPane.showMessageDialog(null, "Pulsa para detener");
        
            
    }

}

class Hora implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(new Date());
        
    }


}
