// lectura de un fichero
package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Streams {

    public static void main(String[] args) {
        Lectura l = new Lectura();
        try {
            l.leer();
        } catch (IOException ex) { // Obligatorio por el cierre de FileReader
            System.out.println("Problema IOException: " + ex.getMessage());
        }
    }

}

class Lectura {

    public void leer() throws IOException {
        int codigo;
        FileReader reader = null;

        try {
            reader = new FileReader("C:\\Users\\jmr\\Desktop\\ejemplo.txt");
            do {
                codigo = reader.read();
                char c = (char) codigo;
                System.out.print(c);
            } while (codigo != -1);
            System.out.println("");
            //reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex.getMessage());
        } finally {
            reader.close(); // Se puede poner al final del bucle o aquí, en finally. sería el caso deun fichero largo con TimeOut
        }
    }
}
