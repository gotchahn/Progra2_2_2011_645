/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package JavaCarRent;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
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
    
    public boolean buscarCarro(String placa)throws IOException{
        rautos.seek(0);
        
        while( rautos.getFilePointer() < rautos.length() ){
            if( placa.equalsIgnoreCase( rautos.readUTF() ))
                return true;
            else{
                rautos.readUTF();
                rautos.seek(rautos.getFilePointer() + 6);
            }
        }
        return false;
    }
    
    public void rentarAuto(String placa)throws IOException{
        
        if( buscarCarro(placa) ){
            String carro = rautos.readUTF();
            rautos.readInt();
            boolean nuevo = rautos.readBoolean();
            
            if( rautos.readBoolean() ){
                //dispo
                //poner no disponible
                rautos.seek( rautos.getFilePointer() - 1);
                rautos.writeBoolean(false);
                //--------
                registrarTrans(placa,nuevo);
                
                System.out.println("Auto Rentado");
            }
            else{
                System.out.println(carro + "con placa: " +
                        placa + " No disponible\n");
            }
        }
        else{
            System.out.println("Carro No Existe\n");
        }
        
    }

    private void registrarTrans(String placa, boolean nuevo)throws IOException {
        rtrans.seek( rtrans.length() );
        
        int codigo = getCodigo();
        
        System.out.println("Ingresar Cantidad de dias: ");
        int dias = lea.nextInt();
        
        double preciou = nuevo ? pxdn : pxdv;
        double total = preciou * dias;
        System.out.print("Cantidad a pagar: " + total);
        
        //escribamos
        rtrans.writeInt(codigo);
        Date d = new Date();
        rtrans.writeLong( d.getTime() );
        rtrans.writeInt(dias);
        rtrans.writeUTF(placa);
        rtrans.writeDouble(total);
        rtrans.writeBoolean(false);
    }

    private int getCodigo()throws IOException {
        RandomAccessFile ram = new RandomAccessFile("codreserv.car","rw");
        
        int codigo;
        
        if( ram.length() > 0 ){
            codigo = ram.readInt();
        }
        else{
            codigo = 1;
        }
        
        ram.seek(0);
        ram.writeInt(codigo + 1);
        ram.close();
        
        return codigo;
    }
    
    public void imprimiTrans()throws IOException{
        rtrans.seek(0);
        
        while(rtrans.getFilePointer() < rtrans.length()){
            System.out.print(rtrans.readInt() + " - " );
            Date d = new Date( rtrans.readLong() );
            System.out.println(d.toString() + " - " +
                    rtrans.readInt() + " dias - placa: " +
                    rtrans.readUTF() + " - $ " +
                    rtrans.readDouble() + " - " +
                    (rtrans.readBoolean() ? "Pagado" : "Por Pagar"));
        }
    }
}
