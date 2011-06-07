/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package VideoStore;

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
               System.out.println("5- Salir");
               System.out.println("\nEscoja opcion: ");
               op = lea.nextInt();
               
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
                   }
               }
               catch(Exception e){
                   System.out.println("Error: " + e.getMessage());
               }
           }while( op != 5);
    }
}