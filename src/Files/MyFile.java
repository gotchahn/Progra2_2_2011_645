/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Files;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gochez
 */
public class MyFile {
    private File f = null;

    public void setFile(String path){
        f = new File( path );
    }

    public void createFile(){
        try {
            if( f.createNewFile() )
                System.out.println("Se creo");
            else
                System.out.println("No Se pudo crear");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        catch( NullPointerException n){
            System.out.println("Instancie primero el objeto filr");
        }
    }

    public void info(){
        try{
            if( f.exists() ){
                System.out.println("Archivo Existente");

                if( f.isFile() )
                    System.out.println("Es un Archivo");
                if( f.isDirectory())
                    System.out.println("Es un Directorio");
                System.out.println("Mide: " + f.length() );

                System.out.println("GetName: " + f.getName() );
                System.out.println("GetPath: " + f.getPath() );
                System.out.println("Get Absoluta: " + f.getAbsolutePath() );
            }
            else
                System.out.println("Archivo Inexistente");
        }
        catch(NullPointerException n){
            System.out.println("Instancie primero el objeto File");
        }
    }

    public void createDir(){
        try{
            if( f.mkdirs() )
                System.out.println("Directorio creado con exito");
            else
                System.out.println("No se pudo Crear directorio");
        }
        catch(NullPointerException n){
            System.out.println("Instancie primero el objeto File");
        }
    }

    public void deleteFile(){
        try{
            if( f.delete() )
                System.out.println("Se borro bien");
            else
                System.out.println("No se pudo borrar");
        }
        catch(NullPointerException n){
            System.out.println("Instancie primero el objeto File");
        }
    }

    public void DirCommand(){
        try{
            if( f.exists() && f.isDirectory() ){

                File files[] = f.listFiles();
                int cf = 0, cd = 0;
                long tb = 0;
                
                for( File fi : files ){
                    //fecha de modif
                    Date modif = new Date( fi.lastModified() );
                    System.out.print(modif.toString() + "   ");

                    //ver si es dir o file
                    if( fi.isDirectory() ){
                        System.out.print("<DIR>    ");
                        cd++;
                    }

                    //size
                    if( fi.isFile()  ){
                        System.out.print( fi.length()+ "   ");
                        cf++;
                        tb += fi.length();
                    }

                    //nombre
                    System.out.println(fi.getName());
                }

                System.out.println("(" + cd + ") dirs");
                System.out.println("(" + cf + ") files");
                System.out.println(tb + " total bytes");
            }
            else
                System.out.println("No existe o no es directorio");
        }
        catch(NullPointerException n){
            System.out.println("Instancie primero el objeto File");
        }
    }
    
    public void renameMove(String newPath){
        try{
            File nuevo = new File(newPath);
            
            if( f.renameTo(nuevo) ){
                System.out.println("Se pudo modificar");
                this.setFile(newPath);
            }
            else
                System.out.println("No se pudo modificar");
            
            System.out.println("COntrolo: " + f.getName());
        }
        catch(NullPointerException n){
            System.out.println("Instancie primero el objeto File");
        }
    }

}












