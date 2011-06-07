/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package JavaCarRent;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class FilesControl {
    private RandomAccessFile rautos;
    private RandomAccessFile rtrans;
    public static Scanner lea = new Scanner(System.in);
    double pxdn; //precio por dia nuevo
    double pxdv; //precio por dia viejo
    
    public FilesControl(double pn,double pv){
        pxdn = pn;
        pxdv = pv;
        
        try{
            rautos = new RandomAccessFile("autos.car","rw");
            rtrans = new RandomAccessFile("trans.car","rw");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void agregarAuto()throws IOException{
        rautos.seek( rautos.length() );
        
        System.out.println("Ingrese Placa: ");
        String placa = lea.next();
        System.out.println("Nombre o descripcion: ");
        String nombre = lea.next();
        System.out.println("Anio del Carro: ");
        int year = lea.nextInt();
        
        //escribir
        rautos.writeUTF( placa );
        rautos.writeUTF(nombre);
        rautos.writeInt(year);
        rautos.writeBoolean(true); //nuevo o viejo
        rautos.writeBoolean(true); // disponible o no
    }
    
    public void imprimirDispos()throws IOException{
        rautos.seek(0);
        
        System.out.println("Autos Disponibles\n------------");
        
        while( rautos.getFilePointer() < rautos.length() ){
            String placa = rautos.readUTF();
            String nombre = rautos.readUTF();
            int anio = rautos.readInt();
            boolean nuevo = rautos.readBoolean();
            String desc = nuevo ? "Nuevo" : "Viejo";
            
            if( rautos.readBoolean() ){
                System.out.println(placa + " - " + nombre + 
                        " - " + anio + " - " + desc);
            }
        }
    }
}
