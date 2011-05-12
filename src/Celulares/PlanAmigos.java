/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Celulares;

/**
 *
 * @author Carlos Gochez
 */
public class PlanAmigos extends PlanCliente {

    private int amigoscell[] = {0,0,0};

    public PlanAmigos(String n,int num){
        super(n,num);
    }

    /**
     * Funcion de ayuda para el agregar amigo y el borrar
     * @param busco Valor a buscar dentro del arreglo
     * @param asigno Valor a asignar en la posicion del arreglo si encontramos
     *          el valor a buscar
     * @return  TRUE si lo encontro o FALSE si no.
     */
    private boolean recorro(int busco,int asigno){
        for(int c=0; c < 3; c++){
            if( amigoscell[c] == busco ){
                //pos vacia
                amigoscell[c] = asigno;
                return true;
            }
        }
        return false;
    }

    public boolean agregarAmigo(int num){
        return recorro(0,num);
    }

    public boolean borrarAmigo(int num){
        return recorro(num,0);
    }

    /**
     * Cuantos Amigos tengo agregados
     * @return La cantidad de amigos agregados
     */
    private int cuantos(){
        int cuant = 0;
        for(int c : amigoscell ){
            if( c != 0 )
                cuant++;
        }
        return cuant;
    }

    @Override
    public double getPago(int cmin,int cmsg) {
        double pago = (cmin * 1.5 ) * (cmsg * 0.5 );
        pago += cuantos();
        return pago;
    }

    @Override
    public void imprimir(){
        System.out.println("Plan Amigos\n------------");
        super.imprimir();
        System.out.println("\nAmigos\n----------------");

        for(int c: amigoscell){
            System.out.println("Numero: " + c);
        }
    }

}
