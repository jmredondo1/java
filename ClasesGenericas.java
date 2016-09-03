package generico;

public class ClasesGenericas {

    public static void main(String[] args) {

        // Uso la clase egen�rica para un String
        Generica<String> s = new Generica<String>();
        s.setValor("Hola mundo gen�rico");
        System.out.println(s.getValor());

        // Uso la clase egen�rica para un Integer
        Generica<Integer> i = new Generica<Integer>();
        i.setValor(123);
        System.out.println(i.getValor());

        // Uso la clase egen�rica para un Objeto
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

// Esta es una clase gen�rica. Puede instanciarse con distintos tipos de objetos
class Generica<T> {

    private T valor;

    /**
     * <b>Clase gen�rica:</b>
     * Devuelve un valor gen�rico
     * @return valor gen�rico
     */
    public T getValor() {
        return valor;
    }

    /**
     * <b>Clase gen�rica:</b>
     * Asigna un nuevo valor al par�metro. 
     * @param valor 
     */
    public void setValor(T valor) {
        this.valor = valor;
    }
    
    
}