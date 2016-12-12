package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class Tree {

    public static void main(String[] args) {

        Articulo articulo1 = new Articulo(1, "Art�culo Z");
        Articulo articulo2 = new Articulo(2, "Art�culo X");
        Articulo articulo3 = new Articulo(3, "Art�culo Y");

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 1 --> Comparador est�ndar CompareTo, implementando la
         * interface Comparable
         */
        TreeSet<Articulo> articulos = new TreeSet<>();
        articulos.add(articulo3);
        articulos.add(articulo2);
        articulos.add(articulo1);

        System.out.println("***ORDENA POR N�MERO");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.getNumero() + " > " + articulo.getDescripcion());
        }

        ///////////////////////////////////////////////////////////////////////
        /**
         * EJEMPLO 2 --> Comparador implementando la interface COMPARATOR para
         * ordenar por otra cosa (p.e. descripci�n) hay que implementar un
         * constructor sin par�metros y hacer referencia a dicho comparador
         */
        Articulo articuloComparador = new Articulo(); // Creo un constructor sin par�metros
        TreeSet<Articulo> ts = new TreeSet<>(articuloComparador);// comparador para Art�culos
        ts.add(articulo3);
        ts.add(articulo2);
        ts.add(articulo1);

        System.out.println("***ORDENA POR DESCRIPCI�N");
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
         * clase an�nima
         *
         */
        TreeSet<Articulo> ts2 = new TreeSet<>(new Comparator<Articulo>() {
            @Override
            public int compare(Articulo o1, Articulo o2) {
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }

        });
        System.out.println("***ORDENA COMPARADOR CON CLASE INTERNA");
        Articulo articulo_1 = new Articulo(1, "Art�culo Z");
        Articulo articulo_2 = new Articulo(2, "Art�culo X");
        Articulo articulo_3 = new Articulo(3, "Art�culo Y");
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

    public Articulo() {// Constructor vac�o solo necesario para el comparador (m�todp COMPARE)
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
        // Ordenaci�n por n�mero de art�culo
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