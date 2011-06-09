/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package videostore;

import java.io.*;

/**
 *
 * @author CARLOS TALENO
 */
public class Prueba5carlos{
      static DvdFilesControl fc = new DvdFilesControl();
 public static void RegistrarCopiasNuevas(int codigo, int copiasnuevas)throws IOException{
           long posicion = fc.busqueda(codigo);
           if(posicion > 0){
             int copiasactuales = fc.ram.readInt();
             //agregar nuevas copias
             fc.ram.seek( fc.ram.getFilePointer() - 4 );
            fc.ram.writeInt(copiasactuales + copiasnuevas);
            System.out.println("Las copias nuevas has sido agregadas");
           } else {
            System.out.println("El codigo del dvd no existe");
           }
    }
}
