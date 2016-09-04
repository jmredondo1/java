package generico;

public class ClasesGenericas {

    public static void main(String[] args) {

        // Uso la clase egenérica para un String
        Generica<String> s = new Generica<String>();
        s.setValor("Hola mundo genérico");
        System.out.println(s.getValor());

        // Uso la clase egenérica para un Integer
        Generica<Integer> i = new Generica<Integer>();
        i.setValor(123);
        System.out.println(i.getValor());

        // Uso la clase egenérica para un Objeto
        Persona persona = new Persona("Pepe");
        Generica<Persona> p = new Generica<Persona>();
        p.setValor(persona);
        System.out.println(p.getValor());

    }

}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + '}';
    }

}

// Esta es una clase genérica. Puede instanciarse con distintos tipos de objetos
class Generica<T> {

    private T valor;

    /**
     * <b>Clase genérica:</b>
     * Devuelve un valor genérico
     * @return valor genérico
     */
    public T getValor() {
        return valor;
    }

    /**
     * <b>Clase genérica:</b>
     * Asigna un nuevo valor al parámetro. 
     * @param valor 
     */
    public void setValor(T valor) {
        this.valor = valor;
    }
    
    
}
