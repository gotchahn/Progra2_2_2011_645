/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class TextFiles {

    private static Scanner lea = new Scanner(System.in);
    private static String filePath = "";
    
    public static void main(String args[]){
        lea.useDelimiter(System.getProperty("line.separator"));
        
        int op;

        do{
            System.out.println("0- Configurar Path");
            System.out.println("1- Escribir en Archivo");
            System.out.println("2- Leer de Archivo");
            System.out.println("3- Leer con Scanner");
            System.out.println("4- Salir");
            System.out.println("\nIngrese Opcion: ");
            op = lea.nextInt();

            switch( op ){
                case 0:
                    System.out.println("Ingrese Direccion: ");
                    filePath = lea.next();
                    break;
                case 1:
                    write();
                    break;
            }
        }while( op != 4 );
    }

    private static void write() {
        FileWriter fw = null;

        try{
            fw = new FileWriter( filePath , true );
            String txt;

            do{
                System.out.println("Ingrese algo que escribir: ");
                txt = lea.next();

                if( !txt.equalsIgnoreCase("exit") ){
                    fw.write( txt + "\n");
                    fw.flush();
                }
                else
                    break;
                
            }while(true);

            fw.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
