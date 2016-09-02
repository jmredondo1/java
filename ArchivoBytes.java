// LEER Y ESCRIBIR BYTES
package streambytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StreamBytes {

    public static void main(String[] args) {

        FileInputStream entrada = null;
        int n = 0;
        int i=0;
        int[] in = new int[1776857];
        FileOutputStream salida=null;
        
        try {
            entrada = new FileInputStream("C:\\Users\\José María\\Desktop\\imagen.jpg");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean finArchivo = false;
        while (!finArchivo) {
            try {
                n = entrada.read();
                in[i]=n;
                i++;
                //System.out.println(n);
                
            } catch (IOException ex) {
                Logger.getLogger(StreamBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (n == -1) {
                finArchivo = true;
                //System.out.println(n);
                System.out.println("Número de bytes: " + i);
            }

        }
        
        try {
            salida = new FileOutputStream("C:\\Users\\José María\\Desktop\\imagen2.jpg");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int j = 0; j < in.length; j++) {
            try {
                salida.write(in[j]);
            } catch (IOException ex) {
                Logger.getLogger(StreamBytes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
