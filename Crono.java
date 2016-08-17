package crono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Crono {

    public static void main(String[] args) {

        int delay = 1000; //milliseconds
        
        // Clase interna local dentro de un método, alternativa a una clase externa
        ActionListener tarea = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(new Date());

            }
        };

//        Tiempo tarea = new Tiempo();// Hay que instanciar la clase si no se usa la clase interna local
        new Timer(delay, tarea).start();

        JOptionPane.showMessageDialog(null, "Pulsa aceptar");
        System.exit(0);
    }

}

// Esta clase debe instanciarse si no se usa la clase interna local
class Tiempo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(new Date());
    }

}