package hilos1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HilosBancoSincronizado1 {

    public static void main(String[] args) {

        int cantidadMax = 2000;
        Banco banco = new Banco();
        for (int cuenta = 0; cuenta < 100; cuenta++) {
            EjecucionTransferencias1 transferencia = new EjecucionTransferencias1(banco, cuenta, cantidadMax);
            Thread t = new Thread(transferencia);
            t.start();

        }
    }

}

class Banco {

    private final double[] cuentas;
    private Lock cierreBanco = new ReentrantLock();

    public Banco() {
        this.cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;

        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {

        /**
         * LOCK Hace que ningún hilo entre a ejecutar el trozo TRY...FINALLY, hasta
         * que no termine el hilo actual. 
         * Si no se usa el LOCK, el saldo total de las cuentas no conicide con el total (200.000),
         * porque varios hilos simultáneos pueden quitar y no abonar
         */
        ///////////////////////////////////
        cierreBanco.lock(); // Bloqueo mientras ejecuto un solo hilo
        ///////////////////////////////////
        try {
            if (cuentas[cuentaOrigen] < cantidad) {
                System.out.println("--- Cantidad insuficiente. Cuenta:" + cuentaOrigen + " Saldo:[" + cuentas[cuentaOrigen] + "...Cantidad:" + cantidad);
                return;
            } else {
                System.out.println("--- Cantidad OK");
            }
            cuentas[cuentaOrigen] -= cantidad;
            cuentas[cuentaDestino] += cantidad;

            System.out.println(Thread.currentThread());
            System.out.printf("ORIGEN:%d DESTINO:%d CANTIDAD:%10.2f\n", cuentaOrigen, cuentaDestino, cantidad);
            System.out.printf("********* Saldo total: %10.2f%n", getSaldoTotal());

        } finally {
            ///////////////////////////////////
            cierreBanco.unlock();// se libera el bloqueo siempre
            ///////////////////////////////////
        }

    }

    public double getSaldoTotal() {
        double suma_cuentas = 0;

        for (double cuenta : cuentas) {
            suma_cuentas += cuenta;
        }

        return suma_cuentas;
    }

}

class EjecucionTransferencias1 implements Runnable {

    private Banco banco;
    private int cuentaOrigen;
    private int cuentaDestino;
    private double cantidadMax;

    public EjecucionTransferencias1(Banco banco, int cuentaOrigen, double cantidadMax) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.cantidadMax = cantidadMax;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cuentaDestino = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
                Thread.sleep((int) Math.random() * 10); // Ralentizar la ejecución
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
