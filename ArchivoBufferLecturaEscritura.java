// Lectura y escritura de un fichero mediante BUFFER
package leerfirchero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFichero {

    public static void main(String[] args) {

        // LECTURA
//        Lectura l = new Lectura();
//        try {
//            l.leer();
//        } catch (IOException ex) { // Obligatorio por el cierre de FileReader
//            System.out.println("Problema IOException: " + ex.getMessage());
//        }
        // ESCRITURA
        try {
            Escritura e = new Escritura();
        } catch (IOException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

class Escritura {

    public Escritura() throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\jmr\\Desktop\\ejemploEscritura.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < 10; i++) {
                bw.write("Hola mundo\r\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class Lectura {

    public void leer() throws IOException {
        int codigo;
        FileReader reader = null;

        try {
            reader = new FileReader("C:\\Users\\jmr\\Desktop\\ejemplo.txt");
            BufferedReader br = new BufferedReader(reader);
            String linea = "";
            while (linea != null) {
                linea = br.readLine();// Lee línea a línea
                System.out.println(linea == null ? "" : linea);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex.getMessage());
        } finally {
            reader.close(); // Se puede poner al final del bucle o aquí, en finally. sería el caso deun fichero largo con TimeOut
        }
    }
}
