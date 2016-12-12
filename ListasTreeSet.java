package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class Tree {

    public static void main(String[] args) {

        Articulo articulo1 = new Articulo(1, "Artículo Z");
        Articulo articulo2 = new Articulo(2, "Artículo X");
        Articulo articulo3 = new Articulo(3, "Artículo Y");

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 1 --> Comparador estándar CompareTo, implementando la
         * interface Comparable
         */
        TreeSet<Articulo> articulos = new TreeSet<>();
        articulos.add(articulo3);
        articulos.add(articulo2);
        articulos.add(articulo1);

        System.out.println("***ORDENA POR NÚMERO");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.getNumero() + " > " + articulo.getDescripcion());
        }

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 2 --> Comparador implementando la interface COMPARATOR para
         * ordenar por otra cosa (p.e. descripción) hay que implementar un
         * constructor sin parámetros y hacer referencia a dicho comparador
         */
        Articulo articuloComparador = new Articulo(); // Creo un constructor sin parámetros
        TreeSet<Articulo> ts = new TreeSet<>(articuloComparador);// comparador para Artículos
        ts.add(articulo3);
        ts.add(articulo2);
        ts.add(articulo1);

        System.out.println("***ORDENA POR DESCRIPCIÓN");
        for (Articulo t : ts) {
            System.out.println(t.getNumero() + " >  " + t.getDescripcion());
        }

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 3 --> Nuevo comparador independiente de la clase, por si no
         * se pudiese alterar la clase Articulo y no puede implementar la
         * interface COMPARATOR
         *
         */
        System.out.println("***ORDENA NUEVO COMPARADOR");
        ComparadorArticulos ca = new ComparadorArticulos();
        TreeSet<Articulo> ts1 = new TreeSet<>(ca);
        ts1.add(articulo3);
        ts1.add(articulo2);
        ts1.add(articulo1);

        for (Articulo t1 : ts1) {
            System.out.println(t1.getNumero() + " > " + t1.getDescripcion());
        }

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 4 --> Clase interna para el comparador
         * No hace falta crear el comparador como clase; se implementa como
         * clase anónima
         *
         */
        TreeSet<Articulo> ts2 = new TreeSet<>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }

        });
        System.out.println("***ORDENA COMPARADOR CON CLASE INTERNA");
        Articulo articulo_1 = new Articulo(1, "Artículo Z");
        Articulo articulo_2 = new Articulo(2, "Artículo X");
        Articulo articulo_3 = new Articulo(3, "Artículo Y");
        ts2.add(articulo_3);
        ts2.add(articulo_2);
        ts2.add(articulo_1);
        for (Articulo articulo : ts2) {
            System.out.println(articulo.getNumero() + " > " + articulo.getDescripcion());
        }

    }

}

class Articulo implements Comparable<Articulo>, Comparator<Articulo> {

    private int numero;
    private String descripcion;

    public Articulo() {// Constructor vacío solo necesario para el comparador (métodp COMPARE)
    }

    public Articulo(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Articulo o) {
        // Ordenación por número de artículo
        return numero - o.numero;
    }

    @Override
    public int compare(Articulo o1, Articulo o2) {
        return o1.getDescripcion().compareTo(o2.getDescripcion());
    }

}

class ComparadorArticulos implements Comparator<Articulo> {

    @Override
    public int compare(Articulo o1, Articulo o2) {

        return o1.getDescripcion().compareTo(o2.getDescripcion());
    }

}