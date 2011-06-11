/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package VideoStore;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;
/**
 *
 * @author Owner
 */
public class Prueba5Guillermo {
   static DecimalFormat  form= new java.text.DecimalFormat("00000");
   static DecimalFormat  cont= new java.text.DecimalFormat("000");
    
    public static String getOpcion(){
        return "Exportar a texto";
    }
    
    public static void funcion(DvdFilesControl f){
        try{
            FileWriter wr= new FileWriter("Inventario.txt");
            wr.write("\t\t ---Inventario de DVDs de tienda" + f.nameStore +"---\r\n\n"+"##   Codigo\r\n");
            int contador= 1;
            f.ram.seek(0);
            while(f.ram.getFilePointer()<f.ram.length()){
                wr.write(cont.format(contador)+": ");
                wr.write(form.format(f.ram.readInt()));
                wr.write(" Nombre de DVD: ");
                wr.write(f.ram.readUTF());
                wr.write(" Numero de copias: ");
                wr.write(f.ram.readInt());
                if(f.ram.readBoolean()){
                    wr.write(" Estreno");
                }else
                    wr.write(" Normal");
                wr.write(" Desde: ");
                Date d= new Date(f.ram.readLong());
                wr.write(d.toString() + "\n");
            }
            wr.close();
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
    }

}
