/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java221;

/**
 *
 * @author jmr
 */
public class Java221 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Empleados empleado1 = new Empleados("Nombre1", 50000, 1, 2, 2001);
//        Empleados empleado2 = new Empleados("Nombre2", 60000, 3, 4, 2002);
//        Empleados empleado3 = new Empleados("Nombre3", 70000, 5, 6, 2003);
//        
//        System.out.println(empleado1.toString());
//        System.out.println(empleado2.toString());
//        System.out.println(empleado3.toString());
//        

        Empleados[] empleados = new Empleados[3];
        for (int i = 0; i < 3; i++) {
            empleados[i] = new Empleados("Nombre" + (i+1), (i+1) * 10000, i + 1, i + 3, 2001 + i);
            System.out.println(empleados[i].toString());
        }

        System.out.println("SUBIDA");
        for (Empleados empleado : empleados) {
            empleado.subirSueldo(5);
            System.out.println(empleado.toString());
        }
        
       
        
    }

}
