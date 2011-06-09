/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package VideoStore;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class DvdFilesControl {
    private RandomAccessFile ram = null;
    private RandomAccessFile rtran = null;
    public String nameStore;
    public double precioNormal,precioEstreno;
    Scanner lea = new Scanner(System.in);
        
    public DvdFilesControl(String name,double pn,double pe){
        nameStore = name;
        precioNormal = pn;
        precioEstreno = pe;
        
        try{
            ram = new RandomAccessFile("dvds.vid","rw");
            rtran = new RandomAccessFile("transacciones.vid","rw");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene el codigo secuancial proximo disponible
     * @return el codigo disponible
     */
    public int getCodigo(){
        try{
            RandomAccessFile cod = new RandomAccessFile("codigos.vid","rw");
            int codigo;
            
            if( cod.length() > 0 ){
                codigo = cod.readInt();
            }
            else{
                codigo = 1;
            }
            
            cod.seek( 0 );
            cod.writeInt(codigo + 1);
            cod.close();
            
            return codigo;
        }
        catch(IOException e){
            System.out.println("error: " + e.getMessage());
            return -1;
        }
    }
    
    public void agregarDvd()throws IOException{
        
        ram.seek( ram.length() );
        
        int codigo = this.getCodigo();
        
        if( codigo > 0 ){
            //codigo
            ram.writeInt(codigo);
            //nombre
            System.out.print("Ingrese Nombre: ");
            String name = lea.next();
            ram.writeUTF( name );
            //cantidad copias
            System.out.print("Cuantas Copias: ");
            ram.writeInt( lea.nextInt() );
            //estreno
            ram.writeBoolean(true);
            //date
            Date d = new Date();
            ram.writeLong( d.getTime() );
        }
        
    }
    
    private long busqueda(int cod)throws IOException{
        ram.seek(0);
        
        while( ram.getFilePointer() < ram.length() ){
            if( cod == ram.readInt() )
                return ram.getFilePointer();
            else{
                ram.readUTF();
                ram.seek( ram.getFilePointer() + 13);
            }
        }
        System.out.println("DVD NO EXISTE");
        return -1;
    }
    
    public void registrarTransaccion(int cdvd,boolean est,String nomb)throws IOException{
        rtran.seek(rtran.length());
        
        //fecha
        Date t = new Date();
        rtran.writeLong( t.getTime() );
        //codigo
        rtran.writeInt(cdvd);
        //monto
        rtran.writeDouble( est ? precioEstreno : precioNormal );
        //nombre
        rtran.writeUTF(nomb);
    }
    
    public void rentaDvd(int cod)throws IOException{
        long found = this.busqueda(cod);
        
        if( found >= 0 ){
            String name = ram.readUTF();
            //ver las copias disponibles
            int copias = ram.readInt();
            
            if( copias > 0 ){
                System.out.println("DVD a Rentar: " + name);
                System.out.print("Cliente: ");
                String cliente = lea.next();
                
                boolean est = ram.readBoolean();
                double precio = est ? precioEstreno : precioNormal;
                
                System.out.println("Monto a Pagar: " + precio);
                
                //registrarTrans
                this.registrarTransaccion(cod, est, cliente );
                //disminuir copias dondeestor - 1(bool) - 4(copias)
                ram.seek( ram.getFilePointer() - 5 );
                ram.writeInt( copias - 1 );
            }
            else{
                System.out.println("NO HAY COPIAS DISPONIBLES, LO SIENTO\n");
            }
        }
        
    }
    
    public void devolverDvd(int cont)throws IOException{
        long pos = this.busqueda(cont);
        
        if( pos > 0 ){
            //lo encontre!
            String dvd = ram.readUTF();
            int copias = ram.readInt();
            
            //actualizar copias + 1
            ram.seek( ram.getFilePointer() - 4 );
            ram.writeInt(copias + 1);
            
            System.out.println("Gracias por devolver el DVD de " + dvd);
        }
        else
            System.out.println("DVD no existe");
    }
    
    public void imprimir( )throws IOException{
        ram.seek(0);
        
        while( ram.getFilePointer() < ram.length() ){
            System.out.println( ram.readInt() + " - " + ram.readUTF() + " - " +
                    ram.readInt() + " copias - " + 
                    (ram.readBoolean() ? " Estreno - " : "Normal - ") + 
                    (new Date( ram.readLong())).toString() );
        }
    }
    
    public void imprimirTrans()throws Exception{
        rtran.seek(0);
        
        while( rtran.getFilePointer() < rtran.length() ){
            Date d = new Date( rtran.readLong());
            int dvd = rtran.readInt();
            double monto = rtran.readDouble();
            String cliente = rtran.readUTF();
            
            System.out.println(d.toString() + " - " + 
                    dvd + " - L." + monto + " Cliente: " +
                    cliente);
        }
    }
    
    public void pasarNormal(Date tope)throws Exception{
        
        if( tope == null )
            throw new Exception("Mandar Fecha Correcta");
        
        ram.seek(0);
        
        while( ram.getFilePointer() < ram.length() ){
            ram.readInt();
            ram.readUTF();
            ram.readInt();
            long pos = ram.getFilePointer();
            boolean nuevo = ram.readBoolean();
            long inicial = ram.readLong();
            
            if( nuevo && inicial <= tope.getTime() ){
                ram.seek(pos);
                ram.writeBoolean(false);
                ram.readLong();
            }
        }
        
    }
    
       
    
}
