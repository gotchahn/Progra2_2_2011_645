/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Files;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class LeerTest {
    public static void main(String args[]){
        FileReader fr = null;
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter(System.getProperty("line.separator"));
        
        do{
            System.out.println("Ingrese Direccion de Archivo: ");
            String file = lea.next();
            
            try{
                fr = new FileReader( file );
                File f = new File( file );
                
                System.out.println("Contenido del Archivo\n-----------");
                
                char buff[] = new char[ (int)f.length() ];
                
                if( fr.read( buff ) > 0 ){
                    System.out.println(buff);
                }
                else
                    System.out.println("El Archino no tenia NADA");
                
                //con Scanner
                System.out.println("\n-----------------");
                
                fr = new FileReader( file );
                //------------------------------
                
                Scanner leaFile = new Scanner(fr);
                leaFile.useDelimiter(System.getProperty("line.separator"));
                
                while( leaFile.hasNext() ){
                    System.out.println( leaFile.next() );
                }
                
                System.out.println("Desea Probar otro archivo: ");
                fr.close();
                
                if( lea.next().charAt(0) != 's' )
                    break;
                
                
            }
            catch(Exception e){
                System.out.println("Archivo no Existe: ");
                System.out.println(e.getMessage());
            }
            
        }while( true );
    }
}
