package colecciones;

import java.util.HashMap;
import java.util.Map;

public class Mapas {

    public static void main(String[] args) {

        HashMap<String, Empleado> empleados = new HashMap<>();
        empleados.put("01", new Empleado("Empleado1", 1000));
        empleados.put("02", new Empleado("Empleado2", 2000));
        empleados.put("03", new Empleado("Empleado3", 3000));
        empleados.put("04", new Empleado("Empleado4", 4000));

        System.out.println("*** EMPLEADOS");
        System.out.println(empleados);

        System.out.println("*** EMPLEADOS: 03-> ELIMINADO, 04-> SUSTITUIDO");
        empleados.remove("03");  // Eliminar un elemento
        empleados.put("04", new Empleado("NuevoEmpleado4", 5000)); // Sustituir un elemento
        System.out.println(empleados);

        // EntrySet (interfaz interna)
        System.out.println(empleados.entrySet());

        for (Map.Entry entrada : empleados.entrySet()) {
            System.out.println("Clave=" + entrada.getKey() + ", Valor=" + entrada.getValue());
        }
    }

}

class Empleado {

    private String nombre;
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "[Nombre=" + nombre + ", Sueldo=" + sueldo + "]";
    }

}
