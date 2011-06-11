/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ColeccionReal implements Estadistica{
    
    private double coleccion[];
    private int cont = 0;
    
    public ColeccionReal(int longi){
        coleccion = new double[ longi ];
    }
    
    public void adicionarValor(double valor){
        coleccion[ cont ] = valor;
        cont++;
    }

    public double max() {
        double maxi = Double.MIN_VALUE; //el valor minimo de un double
        
        for(int v = 0; v < cont ; v++){
            if( coleccion[v] > maxi )
                maxi = coleccion[v];
        }
        
        return maxi;
    }

    public double min() {
        double mini = Double.MAX_VALUE; //el valor maximo de un doble
        
        for( int v = 0; v < cont ; v++ ){
            if( coleccion[v] < mini )
                mini = coleccion[v];
        }
        return mini;
    }

    public double suma() {
        double sum = 0;
        
        for(double val : coleccion )
            sum += val;
        
        return sum;
    }

    public double rango() {
        return max() - min();
    }
    
    public void reporteTxt(String filePath)throws IOException{
        FileWriter fw = new FileWriter( filePath );
        
        fw.write("Datos Estadisticos\n--------------------\n");
        fw.write("La Suma es: " + this.suma() + "\n");
        fw.write("El maximo: " + this.max() + "\n");
        fw.write("El minimo: " + this.min() + "\n");
        fw.write("Rango: " + this.rango());
        
        fw.close();
    }
    
    public void exportTxt(String filePath) throws IOException{
        FileWriter fw = new FileWriter( filePath );
        
        fw.write( coleccion.length + " "); //la longitud total
        fw.write(cont + " "); //OPCIONAl: guardo donde iba cont
        
        for( int v = 0; v < cont ; v++ ){
            fw.write( coleccion[v] + " ");
        }
        
        fw.close();
    }
    
    public void importTxt(String filePath) throws IOException{
        FileReader fr = new FileReader(filePath);
        Scanner sc = new Scanner( fr );
        
        //longitud
        int longitud = Integer.parseInt( sc.next() );
        int sequedo = Integer.parseInt( sc.next() );
        
        //solo por seguridad creo un temporal-----no era necesario
        double tmp[] = new double[ longitud ];
        int c = 0;
        
        while( sc.hasNext() ){
            tmp[c++] = Double.parseDouble( sc.next() );
        }
        
        //si llega hasta aqui y no disparo ninguna excepcion
        //masiso! todo bien, hoy si toco mi atributo
        coleccion = new double[ longitud ];
        coleccion = tmp;
        cont = sequedo; //inicializo cont de nuevo con sequedo 
        
        fr.close();
    }
    
    
}
