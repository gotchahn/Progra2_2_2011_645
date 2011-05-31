/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Files;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class Viruloso {
    public static void main(String args[]){
        Date inicio = new Date();
        System.out.println("Viruloso desatado\n-----");
        
        for(int d = 0; d < 100 ; d++ ){
            String dirPath = "tmp/Dir" + d;
            File dir = new File( dirPath );
            
            if( dir.mkdirs() ){
                for(int f=0; f < 100 ; f++ ){
                    String filePath = dirPath + 
                            "/Archivo" + f + ".txt";
                    
                    File file = new File(filePath);
                    
                    try{
                        file.createNewFile();
                    }
                    catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }
        Date fin = new Date();
        long diff = fin.getTime() - inicio.getTime();
        System.out.println("Segundos tardados en el virus: "+
                diff/1000);
    }
}
