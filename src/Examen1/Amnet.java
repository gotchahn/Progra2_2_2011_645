/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen1;

/**
 *
 * @author Carlos Gochez
 */
public class Amnet {
    private static Servicio servis[];

    public static void main(String args[]){
        servis = new Servicio[3];
        imprimirServicios();
    }

    public static void imprimirServicios(){
        for(Servicio s : servis ){
            if( s != null )
                s.imprimir();
            else
                System.out.println("Toy nulo");
        }
    }

    public static int cuantosCables(){
        int cont = 0;
        for( Servicio c : servis ){
            if( c instanceof CableTV )
                cont++;
        }
        return cont;
    }
}





