
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package VideoStore;

/**
 *
 * @author ViCoOo
 */
public class Prueba5Victoria {
    public static String descripcion;

    public static String getOpcion(){
        descripcion="Reporte de dvd's mas rentados";
                return descripcion;
    }

    public static void funcion(DvdFilesControl dfc)throws IOException{
        int total=0;

        dfc.rtran.seek(0);

        while(dfc.rtran.getFilePointer()<dfc.rtran.length()){

            dfc.rtran.readLong();

            int codigo=dfc.rtran.readInt();
            if(codigo==codigo){
                total++;
            }

            dfc.rtran.readDouble();
            dfc.rtran.readUTF();
        }
    }


}
