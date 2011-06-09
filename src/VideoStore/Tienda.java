/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VideoStore;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Tienda {
    public static Scanner lea = new Scanner(System.in);
    
    public static void main(String args[]){
           System.out.println("Bienvenido a la Video Strore\n-----------");
           DvdFilesControl dfc = new DvdFilesControl("VideoStars",40,60);
           int op;
           
           do{
               System.out.println("Menu Principal\n----------------");
               
               System.out.println("1- AgregarDvd");
               System.out.println("2- Rentar Dvd");
               System.out.println("3- Devolver Dvd");
               System.out.println("4- Imprimir All");
               System.out.println("5- Pasar a Normal");
               System.out.println("6- Mirar Transacciones");
               System.out.println("7- Dennis");
               System.out.println("8- Salir");
               System.out.println("\nEscoja opcion: ");
               op = lea.nextInt();
               Prueba5Dennis dennis = new Prueba5Dennis();
            
               
               try{
                   switch( op ){
                       case 1:
                            dfc.agregarDvd();
                            break;
                       case 2:
                           System.out.println("Ingresa Codigo: ");
                           int cod = lea.nextInt();
                           dfc.rentaDvd(cod);
                           break;
                       case 3:
                           System.out.println("Ingresa Codigo: ");
                           cod = lea.nextInt();
                           dfc.devolverDvd(cod);
                           break;
                       case 4:
                           dfc.imprimir();
                           break;
                       case 5:
                           Calendar c = Calendar.getInstance();
                           System.out.println("Anio: ");
                           int anio = lea.nextInt();
                           System.out.println("Mes: ");
                           int mes = lea.nextInt();
                           System.out.println("Dia: ");
                           int dia = lea.nextInt();
                           c.set(anio, mes - 1, dia);
                           
                           dfc.pasarNormal( c.getTime() );
                           break;
                       case 6:
                           dfc.imprimirTrans();
                           break;
                       case 7:
                              dennis.funcion(dfc);

                   }
               }
               catch(Exception e){
                   System.out.println("Error: " + e.getMessage());
               }
           }while( op != 8);
    }
}