/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java221;

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
        // TODO code application logic here
        Empleado[] empleados = new Empleado[4];
        empleados[0] = new Empleado("Empleado1", 50000, 1, 1, 2001);
        empleados[1] = new Empleado("Empleado2", 60000, 2, 2, 2002);
        empleados[2] = new Empleado("Empleado3", 70000, 3, 3, 2003);
        //empleados[2] = new Empleado("Empleado3", 70000, 3, 3, 2003);
        empleados[3] = new Jefe("Jefe1", 80000, 4, 4, 2004);

        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        System.out.println("--------------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.subirSalario(10));
        }
        System.out.println("--------------------------------");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }

    }

}

class Empleado {

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
        return this.getClass().getSimpleName()+"{" + "nombre=" + nombre + ", id=" + id + ", salario=" + salario + ", fechaAlta=" + fechaAlta + '}';
    }

    public String subirSalario(int porcentaje) {
        this.salario += this.salario * porcentaje / 100;
        return "<***> Salario subido un " + porcentaje + "% --> " + this.getNombre();
    }

}

class Jefe extends Empleado{

    public Jefe(String nombre, double salario, int dia, int mes, int año) {
        super(nombre, salario, dia, mes, año);
    }


}
