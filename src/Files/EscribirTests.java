/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Files;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class EscribirTests {
    public static void main(String args[]){
        
        FileWriter fw = null;
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter(System.getProperty("line.separator"));
        
        try{
            
            do{
                System.out.println("Ingrese Direccion de Archivo: ");
                String file = lea.next();
                
                fw = new FileWriter( file , true);
            
                String txt = "";
                
                do{
                    System.out.println("Ingrese algo que escribir: ");
                    txt = lea.next();
                    
                    //escrio en el archivo
                    if( !txt.equalsIgnoreCase("EXIT") )
                        fw.write( txt + "\n" );
                    
                    fw.flush();
                    
                }while( !txt.equalsIgnoreCase("EXIT") );
                
                System.out.println("Desea Probar otro archivo: ");
                fw.close();
                
                if( lea.next().charAt(0) != 's' )
                    break;
                      
                        
            }while(true);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
}
