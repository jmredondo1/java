package hilos1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos1 {

    public static void main(String[] args) {
        MiNuevoHilo hilo1 = new MiNuevoHilo();
        hilo1.setName("Hilo-1");
        MiNuevoHilo hilo2 = new MiNuevoHilo();
        hilo2.setName("Hilo-2");

        hilo1.start();
        hilo2.start();
    }

}

class MiNuevoHilo extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando hilo " + getName() );
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiNuevoHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
