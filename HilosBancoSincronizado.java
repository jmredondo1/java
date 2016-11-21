package hilos1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HilosBancoSincronizado {

    public static void main(String[] args) {

        Banco b = new Banco();
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
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
        cierreBanco.lock();

        try {
            if (cuentas[cuentaOrigen] < cantidad) {
                return;
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de %d para %d\n", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;
            System.out.printf("********* Saldo total: %10.2f%n", getSaldoTotal());
        } finally {
            cierreBanco.unlock();
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

class EjecucionTransferencias implements Runnable {

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
    // la cuenta destino será aleatoria

    public EjecucionTransferencias(Banco b, int de, double max) {
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
