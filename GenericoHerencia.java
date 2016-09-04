package genericoherencia;

public class GenericoHerencia {

    public static void main(String[] args) {
// Antes de los gen�ricos, se instanciaba as�:        
//        Empleado empleado1 = new Empleado("Elena", 2500, 45);
//        Jefe jefe1 = new Jefe("Ana", 3000, 50);
//        Empleado empleado2 = jefe1; // Por el principio de sustituci�n (es un...), se puede almacenar un JEFE en un EMPLEADO, porque un JEFE es un EMPLEADO (no al rev�s)

        Generico<Empleado> empleadoG = new Generico<Empleado>();
        Generico<Jefe> jefeG = new Generico<Jefe>();

        // Generico<Empleado> g = jefeG; // Principio de sustituci�n no funciona. ERROR
        // Soluci�n: ver comentario del m�todo en la clase gen�rica
        Generico.imprimirTrabajador(jefeG);
        Generico.imprimirTrabajador(empleadoG);

    }

}

class Generico<T> {

    private T primero;

    public Generico() {
        primero = null;
    }

    public T getPrimero() {
        return primero;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

    // soluciona el problema de la herencia en clases gen�ricas <? extends Empleado>
    public static void imprimirTrabajador(Generico<? extends Empleado> emp) {
        Empleado primero = emp.getPrimero();
        System.out.println(primero);
    }

}

class Empleado {

    private String nombre;

    private double salario;

    private int edad;

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", salario=" + salario + ", edad=" + edad + '}';
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

class Jefe extends Empleado {

    public Jefe(String nombre, double salario, int edad) {
        super(nombre, salario, edad);
    }

    double incentivo(double incentivo) {
        return incentivo;
    }
}
