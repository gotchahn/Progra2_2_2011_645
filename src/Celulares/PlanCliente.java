/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Celulares;

/**
 *
 * @author Carlos Gochez
 */
public abstract class PlanCliente {
    protected String nombre;
    protected int numero;

    public PlanCliente(String n, int num){
        nombre = n;
        numero = num;
    }

    public final void setNombre(String n){
        nombre = n;
    }

    public final void setNumero(int num){
        numero = num;
    }

    public final int getNumero(){
        return numero;
    }

    public final String getNombre(){
        return nombre;
    }

    public void imprimir(){
        System.out.printf("\nLos Datos del cliente son\nNombre %s Numero %d\n",
                nombre,numero);
    }

    public abstract double getPago(int cmin,int cmsg);
}
