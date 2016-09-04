package metodogenerico;

import java.util.Calendar;
import java.util.GregorianCalendar;
import sun.java2d.SurfaceData;

public class MetodoGenerico {

    public static void main(String[] args) {

        // Array de nombres
        String[] nombres = {"María", "José", "Ana"};

        // Num elementos: llamada al método genérico. No es necesario instanciar porque es un método estático: nombreDeClase.Metodo
        System.out.println(Generico.getLongitud(nombres));

        Persona persona0 = new Persona("Nombre 0", 20);
        Persona persona1 = new Persona("Nombre 1", 30);
        Persona persona2 = new Persona("Nombre 2", 40);
        Persona persona3 = new Persona("Nombre 3", 50);
        Persona[] personas = {persona0, persona1, persona2, persona3};

        // Num elementos: llamada al método genérico. Ahora es un array de objetos
        System.out.println(Generico.getLongitud(personas));

//        for (Persona persona : personas) {
//            System.out.println(persona.getNombre());
//        }
        // Llamada a método genérico: Dar el menor
        System.out.println(GenericoMenor.getMenor(nombres));

        // System.out.println(GenericoMenor.getMenor(personas)); 
        // ERROR: esto no se puede dar el menor porque no implementa Comparable

        // GregorianCalendar sí implementa le interface Comparable
        GregorianCalendar fecha1 = new GregorianCalendar(2016, 10, 20);
        GregorianCalendar fecha2 = new GregorianCalendar(2016, 9, 10);
        GregorianCalendar fecha3 = new GregorianCalendar(2016, 8, 1);
        GregorianCalendar[] fechas = {fecha1, fecha2, fecha3};

        System.out.println(GenericoMenor.getMenor(fechas).getTime());

    }

}

// Clase que contiene el método genérico para devolver el número de elementos
class Generico {

    // public=accesible. static=accesible sin instanciar.
    public static <T> String getLongitud(T[] a) {
        return "Num. elementos " + a.length;
    }
}
// Clase que contiene el método genérico para devolver el menor elemento

class GenericoMenor {

    // public=accesible. static=accesible sin instanciar.
    public static <T extends Comparable> T getMenor(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        } else {

            T elementoMenor = a[0];
            for (int i = 1; i < a.length; i++) {
                if (elementoMenor.compareTo(a[i]) > 0) {
                    elementoMenor = a[i];
                }
            }
            return elementoMenor;
        }
    }
}

class Persona {

    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

}
