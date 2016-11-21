package hilos1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos3Sincronizado {

    public static void main(String[] args) {
        MiNuevoHilo3 hilo1 = new MiNuevoHilo3();
        hilo1.setName("Hilo-1");
        HilosVarios hilo2 = new HilosVarios(hilo1);
        hilo2.setName("Hilo-2");

        hilo2.start();
        hilo1.start();
        
        
        System.out.println("Terminadas las tareas"); // Se realiza antes de comenzar HILO2, pepro después de terminar HILO1 (join) porque esta instrucción corresponde al HILO del MAIN
    }

}

class MiNuevoHilo3 extends Thread {

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

class HilosVarios extends Thread {

    private Thread hilo;
    
    public HilosVarios(Thread hilo) {
    
        this.hilo = hilo;
    
    }
    

    public void run() {
        
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
