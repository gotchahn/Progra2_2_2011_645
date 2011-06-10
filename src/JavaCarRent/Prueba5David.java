/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaCarRent;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author David
 */
public class Prueba5David {

   public static String getOpcion(){
        return "Reporte de ganancias";
    }

    public static double funcion(FilesControl fc) throws Exception{
                           Calendar c = Calendar.getInstance();
                           System.out.println("Anio: ");
                           int anio = FilesControl.lea.nextInt();
                           System.out.println("Mes: ");
                           int mes = FilesControl.lea.nextInt();
                           System.out.println("Dia: ");
                           int dia = FilesControl.lea.nextInt();
                           c.set(anio, mes - 1, dia);



        if( c.getTime() == null )
            throw new Exception("Mandar Fecha Correcta");

        fc.rtrans.seek(0);
        double total = 0;
        while( fc.rtrans.getFilePointer() < fc.rtrans.length() ){
            fc.rtrans.readInt();
            long fecha = fc.rtrans.readLong();
            if(fecha <= c.getTime().getTime()){
                fc.rtrans.readInt();
                fc.rtrans.readUTF();
                fc.rtrans.readInt();
                total+=fc.rtrans.readDouble();
                fc.rtrans.readBoolean();
            }
            else{
                fc.rtrans.readInt();
                fc.rtrans.readUTF();
                fc.rtrans.readInt();
                fc.rtrans.readDouble();
                fc.rtrans.readBoolean();
            }
        }

        return total;
    }
}
