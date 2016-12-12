package colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * LINKED LIST
 * Dos listas que se mezclan
 * 
 */
public class Linked {

    public static void main(String[] args) {
        LinkedList<String> paises = new LinkedList<>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Perú");

        LinkedList<String> capitales = new LinkedList<>();
        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("DF");
        capitales.add("Lima");

        ListIterator<String> itPaises = paises.listIterator();
        ListIterator<String> itCapitales = capitales.listIterator();

        //MEZCLAR LAS DOS LISTAS
        while (itCapitales.hasNext()) {
            if (itPaises.hasNext()) {
                itPaises.next();
            }
            itPaises.add(itCapitales.next());

        }
        System.out.println(paises);

        //ELIMINAR LAS POSICIONES PARES
        System.out.println(capitales);
        itCapitales = capitales.listIterator(); // Pongo el iterador al principio
        while (itCapitales.hasNext()) { // Si hay otro elemento
            itCapitales.next();         // salto
            if (itCapitales.hasNext()) {
                itCapitales.next();
                itCapitales.remove();
            }

        }

        System.out.println(capitales);

        // Eliminar las capitales de la lista mezclada
        paises.removeAll(capitales);
        System.out.println(paises);

    }

}
