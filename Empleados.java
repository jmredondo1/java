/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java221;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author jmr
 */
public class Empleados {

    private String Nombre;

    private double Sueldo;

    private Date FechaAlta;

    /**
     * Get the value of FechaAlta
     *
     * @return the value of FechaAlta
     */
    public Date getFechaAlta() {
        return FechaAlta;
    }

    /**
     * Set the value of FechaAlta
     *
     * @param FechaAlta new value of FechaAlta
     */
    public void setFechaAlta(int dia, int mes, int año) {
        GregorianCalendar calendar = new GregorianCalendar(año, mes, dia);
        this.FechaAlta = calendar.getTime();
    }

    /**
     * Get the value of Sueldo
     *
     * @return the value of Sueldo
     */
    public double getSueldo() {
        return Sueldo;
    }

    /**
     * Set the value of Sueldo
     *
     * @param Sueldo new value of Sueldo
     */
    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    /**
     * Get the value of Nombre
     *
     * @return the value of Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Set the value of Nombre
     *
     * @param Nombre new value of Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Empleados(String Nombre, double Sueldo, int dia, int mes, int año) {
        this.Nombre = Nombre;
        this.Sueldo = Sueldo;
        GregorianCalendar calendar = new GregorianCalendar(año, mes, dia);
        this.FechaAlta = calendar.getTime();
    }

    @Override
    public String toString() {
        return "Empleado{" + "Nombre=" + Nombre + ", Sueldo=" + Sueldo + ", FechaAlta=" + FechaAlta + '}';
    }

    public void subirSueldo(int porcentaje) {
        double nuevoSueldo = 5000 + this.Sueldo;
        //System.out.println("Sueldo actual:"+this.Sueldo+" --- subida: "+ nuevoSueldo);
        this.Sueldo = nuevoSueldo;
    }
}
