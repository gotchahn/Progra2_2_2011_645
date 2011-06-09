
import java.util.Calendar;
import java.util.Date;


//package VideoStore;

public class Prueba5Erick {

    public static String getOpcion(){
        return "Reporte de Dvds con Cero Copias";
    }

    public static void funcion(DvdFilesControl dfc){
        int Temporal = 0;
        String Nombre = "";
        
        System.out.println("-----------------------------Informe de Dvds sin copias en Inventario-----------------------------");

        try{
            dfc.ram.seek(0);

            while(dfc.ram.getFilePointer()<dfc.ram.length()){
                Temporal = dfc.ram.readInt();
                Nombre = dfc.ram.readUTF();

                if(dfc.ram.readInt()==0){
                    System.out.print("\n\nEl DVD "+Nombre+" con codigo "+Temporal+" no posee copias en inventario. \n\n");
                    funcionAuxiliar(dfc,Temporal);
                }

                dfc.ram.readBoolean();
                dfc.ram.readLong();
            }
        }catch(Exception e){
            System.out.println("Hubo un problema en la operacion, intente de nuevo");
        }
    }

    private static void funcionAuxiliar(DvdFilesControl dfc, int Codigo){
       Date d;
       Long Fecha;

        try{
            dfc.rtran.seek(0);

            while(dfc.rtran.getFilePointer()<dfc.rtran.length()){
                Fecha = dfc.rtran.readLong();

                if(dfc.rtran.readInt()==Codigo){
                    d = new Date(Fecha);
                    System.out.print("\tUna copia fue rentada en la fecha "+d.toString()+"\n\t");
                }

                dfc.rtran.readDouble();
                dfc.rtran.readUTF();
            }
        }catch(Exception e){
            System.out.println("ERROR = "+e.getMessage());
        }
    }

}
