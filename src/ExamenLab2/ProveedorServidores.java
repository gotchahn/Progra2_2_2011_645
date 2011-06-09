/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class ProveedorServidores {
    private static Servidor servers[];
    
    public static void main(String args[]){
        servers = new Servidor[2];
        
        servers[0] = new ServidorWeb("Amazon");
        servers[1] = new ServidorDominios("Google DNS");
        Scanner lea = new Scanner(System.in);
        
        int op;
        
        do{
            System.out.println("1- Ingrese Entry");
            System.out.println("2- Navegador Web");
            System.out.println("3- Ver Ips o Dominios");
            System.out.println("4- Salir");
            
            System.out.print("Ingrese opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.println("Ingrese a que Server quiere: ");
                    String tipo = lea.next();
                    
                    System.out.println("Ingrese nombre de la pagina: ");
                    String page = lea.next();
                    String reg = "";
                    int pos = 0;
                    
                    if( tipo.equals("HTTP") )
                        System.out.println("Ingrese el HTML de la pagina: ");
                    else{
                        System.out.println("Ingrese Direccion IP");
                        pos = 1;
                    }
                    
                    reg = lea.next();
                    servers[ pos ].addEntry( page , reg );
                    
                    break;
                    
                case 2:
                    System.out.println("Ingrese el URL: ");
                    String url = lea.next();
                    
                    try{
                        Object html = servers[0].devolverPeticion(url);
                        System.out.println(html);
                    }
                    catch(Exception e){
                        System.out.println("PAGE NOT FOUND or ERROR");
                    }
                    break;
                    
                case 3:
                    System.out.println("Ingrese IP o URL: ");
                    String ipurl = lea.next();
                    
                    try{
                        Object regi = servers[1].devolverPeticion(ipurl);
                        System.out.print("Su registro es: ");
                        System.out.println(regi);
                    }
                    catch(Exception e){
                        System.out.println("LLAVE NO EXISTE");
                    }
                    break;
            }
        }while( op != 4 );
    }
}
