/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java221;

/**
 *
 * @author jmr
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Emp trabajador1 = new Emp("Paco");
        Emp trabajador2 = new Emp("Ana");
        Emp trabajador3 = new Emp("Juan");
        Emp trabajador4 = new Emp("María");

        trabajador1.cambiaSeccion("RRHH");
//        trabajador1.cambiaNombre("María");

        System.out.println(
                trabajador1.devuelveDatos() + "\n"
                + trabajador2.devuelveDatos() + "\n"
                + trabajador3.devuelveDatos() + "\n"
                + trabajador4.devuelveDatos()
        );
        
        System.out.println("Siguiente -->"+Emp.dameIdSiguiente());

    }

}

class Emp {

    private final String nombre;

    private String seccion;

    private int Id;

    private static int IdSiguiente;

    public Emp(String nombre) {
        this.nombre = nombre;
        this.seccion = "Administración";
        Id = ++IdSiguiente;

    }

    public void cambiaSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String devuelveDatos() {
        return "Nombre: " + nombre + " -- Sección: " + seccion + " -- ID:" + Id;
    }

    public static String dameIdSiguiente() {
        return "El siguiente Id es " + IdSiguiente;
    }

//    public void cambiaNombre(String nombre){
//        this.nombre = nombre;
//    }
}
