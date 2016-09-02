package escribirfichero;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    
    public static void main(String[] args) {
        
        try {
            Escribir e = new Escribir();
        } catch (IOException ex) {
            System.out.println("Problema de escritura");;
        }
    }
    
}

class Escribir {
    
    public Escribir() throws IOException {
        
        String frase = "Prueba de escritura";
        boolean sobreescribir = true;
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("c:/users/jmr/desktop/prueba.txt", sobreescribir);
            for (int i = 0; i < frase.length(); i++) {
                writer.write(frase.charAt(i));
            }
            writer.write("\r\n");
            System.out.println("escrito...");
            //writer.close();
        } catch (IOException ex) {
            System.out.println("No se puede escribir: " + ex.getMessage());;
        } finally {
            writer.close();
        }
    }
}
