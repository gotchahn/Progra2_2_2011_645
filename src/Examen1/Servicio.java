/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen1;

import java.util.Date;

/**
 *
 * @author Carlos Gochez
 */
public class Servicio {
    protected String nombre;
    protected int codigo;
    protected Date inicio;
    protected double monto;

    public Servicio(String n,int c){
        nombre = n;
        codigo = c;
        inicio = new Date();
        monto = 0;
    }

    public double getMonto(){
        return monto;
    }

    public void imprimir(){
        System.out.println(nombre+codigo+inicio.toString()+monto);
    }




}
