package hilos1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos2Sincronizado {

    public static void main(String[] args) {
        MiNuevoHilo2 hilo1 = new MiNuevoHilo2();
        hilo1.setName("Hilo-1");
        MiNuevoHilo2 hilo2 = new MiNuevoHilo2();
        hilo2.setName("Hilo-2");

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos2Sincronizado.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo2.start();
        
        System.out.println("Terminadas las tareas"); // Se realiza antes de comenzar HILO2, pepro después de terminar HILO1 (join) porque esta instrucción corresponde al HILO del MAIN
    }

}

class MiNuevoHilo2 extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ejecutando hilo sicronizado..." + getName() );
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiNuevoHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
