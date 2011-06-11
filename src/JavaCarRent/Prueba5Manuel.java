/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package JavaCarRent;

/**
 *
 * @author Roberto
 */
public class Prueba5Manuel {
    public static String getOpcion(){
        return "Pasar a Archivo TXT";
    }

    public static void funcion(FilesControl fc)throws IOException{
        fc.rautos.seek(0);
        while(fc.rautos.getFilePointer()<fc.rautos.length()){
            String placa=fc.rautos.readUTF();
            String nombre=fc.rautos.readUTF();
            int anio=fc.rautos.readInt();
            boolean nuevo=fc.rautos.readBoolean();
            String desc=nuevo ? "Nuevo" : "Viejo";
            if(fc.rautos.readBoolean()){
                FileWriter fw=new FileWriter("C/prueba.txt");
                fw.write(placa);
                fw.write(nombre);
                fw.write(anio);
                fw.write(desc);
            }
        }


    }

}

