/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java221;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmr
 */
public class Prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jefe jefe1 = new Jefe("Jefe1", 90000, 5, 5, 2016);
        jefe1.setIncentivo(10000.0);
        Empleado[] empleados = new Empleado[5];
        empleados[0] = new Empleado("Empleado1", 60000, 1, 1, 2001);
        empleados[1] = new Empleado("Empleado2", 70000, 2, 2, 2002);
        empleados[2] = new Empleado("Empleado3", 50000, 3, 3, 2003);
        empleados[3] = jefe1; // Polimorfismo
        empleados[4] = new Jefe("Jefe2", 80000, 4, 4, 2004);// No le aplica el polimorfismo porque es un empleado

        // Imprimir empleados (y jefes)
        System.out.println("---LISTADO ANTES DE SUBIR EL SUELDO----------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }

        Empleado DirectorComercial = new Empleado("EmpleadoJefe", 85000, 5, 5, 2005); // esto está permitido
        Comparable comparable = new Empleado("EmpleadoComparable", 95000, 6, 6, 2006); // Esto se puede porque Empleado instancia Comprable
        if (comparable instanceof Empleado) {
            System.out.println("comparable es de tipo EMPLEADO");
        }
        if (DirectorComercial instanceof Comparable) {
            System.out.println("DirectorComercial es de tipo comparable"); //Sí, porque implementa Comparable
        }
        if (comparable instanceof Jefe) {
            System.out.println("comparable es de tipo JEFE"); // Esto no funciona
        }

        // Comprobar la interface
        System.out.println(jefe1.tomarDecision("Subir sueldo empleado"));
        
        // establecer bonus
        jefe1.setIncentivo(500);

        System.out.println("--------------------------------");
        // Subir salario a empleados (y jefes)
        for (Empleado empleado : empleados) {
            System.out.println(empleado.subirSalario(10));
        }

        // Imprimir empleados (y jefes) 
        System.out.println("---LISTADO SIMPLE-----------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        // Imprimir empleados (y jefes) por orden de sueldo
        Arrays.sort(empleados);
        System.out.println("---LISTADO ORDENADO POR SUELDO----------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }

    }

}

class Empleado implements Comparable, Trabajadores {

    // Todos los campos privados para que no se pueda acceder desde fuera de la clase
    // Variable de clase. Solo una instancia para todos los objetos. La incrementaremos en cada objeto creado
    private static int idNext;
    // Se hace FINAL para que no se pueda modificar
    private final String nombre;
    // Variable que toma del valor de la variable de clase idNext
    private int id;
    private double salario;
    private Date fechaAlta;

    public Empleado(String nombre, double salario, int dia, int mes, int año) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaAlta = new GregorianCalendar(año, mes - 1, dia).getTime();
        this.id = ++idNext;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(int dia, int mes, int año) {
        this.fechaAlta = new GregorianCalendar(año, mes - 1, dia).getTime();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "CLASE " + this.getClass().getSimpleName()
                + "\t{"
                + "nombre=" + getNombre()
                + "\t id=" + getId()
                + "\t salario=" + getSalario()
                + "\t fechaAlta=" + getFechaAlta()
                + "}";
    }

    public String subirSalario(int porcentaje) {
        this.salario += this.salario * porcentaje / 100;
        return "<***> Salario subido un " + porcentaje + "% --> " + this.getNombre();
    }

    // Compara dos objetos y retorna un valor. Implementa la interface Arrays
    @Override
    public int compareTo(Object o) {
        Empleado e = (Empleado) o;
        if (salario < e.salario) {
            return -1;
        } else if (salario > e.salario) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public double estableceBonus(double gratificacion) {
        return gratificacion;
    }

}

class Jefe extends Empleado implements Jefes {

    private double incentivo;

    public Jefe(String nombre, double salario, int dia, int mes, int año) {
        super(nombre, salario, dia, mes, año);

    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public double getSalario() {
        double salarioJefe = super.getSalario();
        return salarioJefe + incentivo;
    }

    @Override
    public String tomarDecision(String td) {
        return " >>> Decisión tomada: " + td;
    }

    @Override
    public double estableceBonus(double gratificacion) {
        double prima = 2000;
        return Trabajadores.bonusBase + gratificacion + prima;
    }

}
