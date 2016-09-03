package arraylistEjemplo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEjemplo1 {

    public static void main(String[] args) {

// El problema es que hay que saber de antemano el número de elementos. La solución es un ArrayList
/*
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Empleado("Ana", 45, 2500);
        empleados[1] = new Empleado("Antonio", 50, 3000);
        empleados[2] = new Empleado("María", 55, 3500);
         */
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        empleados.add(new Empleado("Nombre 0", 45, 2500));
        empleados.add(new Empleado("Nombre 1", 50, 3000));
        empleados.add(new Empleado("Nombre 2", 51, 2000));
        empleados.add(new Empleado("Nombre 3", 55, 3500));

        // Posicionamiento en posición 1
        //empleados.add(new Empleado("María", 55, 3500));
        empleados.set(1, new Empleado("Nombre 1-NUEVO", 52, 1000)); // Sustituye al que estaba en esa posición

        System.out.println("Número de elementos: " + empleados.size());
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }

        // Imprimir un elemento de una posición
        System.out.println("El elemento en 3 lugar: " + empleados.get(2).toString());

        // Iteraciones
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

    }

}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + '}';
    }

}
