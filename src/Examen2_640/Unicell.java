/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2_640;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Unicell {
    Scanner lea = new Scanner(System.in);
        
    public static final int MAX_CLIENTS = 100;
    public int contador = 0;
    public Cliente clients[];
    
    public Unicell(){
        clients = new Cliente[MAX_CLIENTS];
    }
    
    public void adicionCliente(Cliente c){
        try{
            clients[contador] = c;
            contador++;
        }
        catch(ArrayIndexOutOfBoundsException ar){
            System.out.println("No hay espacio ya");
        }
    }
    
    public boolean setPlan(String nombre){
        
        try{
            for(int c=0; c < clients.length; c++ ){
                if( clients[c].nombre.equals(nombre) ){
                    System.out.println("Ingrese tipo plan: ");
                    String tipo = lea.next();
                    System.out.println("Precio x Minuto: ");
                    double pmin = lea.nextDouble();
                    System.out.println("Precio x Msg: ");
                    double pmsg = lea.nextDouble();

                    if( tipo.equals(IPlan.TIPO_40) ){
                        clients[c].setPlan( new Plan40(pmin,pmsg) );
                    }
                    else if( tipo.equals(IPlan.TIPO_80)){
                        System.out.println("Tiene Internet");
                        boolean b = lea.nextBoolean();

                        clients[c].setPlan( new Plan80(pmin,pmsg,b) );
                    }

                    return true;

                }
            }
        }
        catch(TipoInvalidoException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public double pagoTotalmes(){
        double total = 0;
        
        for( Cliente c : clients ){
            System.out.println("Pago para " + c.nombre );
            System.out.println("Ingrese cantidad minutos");
            int cmin = lea.nextInt();
            System.out.println("Ingrese Cantidad de msgs: ");
            int msgs = lea.nextInt();
            
            double pago = 0;
            
            if( c.plan instanceof Plan40 )
                pago = ((Plan40)c.plan).getPrecio(cmin, msgs);
            else if( c.plan instanceof Plan80 )
                pago = ((Plan80)c.plan).getPrecio(cmin, msgs);
            
            System.out.println("Pagara: " + pago);
            
            total += pago;
        }
        
        return total;
    }
}
