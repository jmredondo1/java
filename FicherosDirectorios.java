// recorrido recursivo de directorios (solo 2 niveles)
package ficherosdirectorios;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import java.io.File;

public class FicherosDirectorios {

    public static void main(String[] args) {

        File f = new File("C:\\Users\\José María\\Desktop");

        System.out.println(f.getAbsolutePath());
        System.out.println(f.exists());

        String[] lista = f.list();
        for (String string : lista) {
            
            File f2 = new File(f, string);
            if (!f2.isDirectory()) {
                System.out.println(string);
            }else{
                System.out.println("-D-"+string);
                String[] subcarpeta = f2.list();
                for (String string1 : subcarpeta) {
                    System.out.println(string1);
                }
            }

        }
    }

}
