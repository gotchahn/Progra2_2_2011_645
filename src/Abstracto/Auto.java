/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstracto;

/**
 *
 * @author Carlos Gochez
 */
public class Auto extends MedioTransporte {
    private String color;

    public Auto(int serial){
        super(serial,TIPO_MEDIO_TER);
        color = "neutro";
    }

    public void setColor(String c){
        color = c;
    }

    public String getColor(){
        return color;
    }

    public final void moverse(){
        System.out.println("1- Meta la llave\n2-Dele vuelta a la llave para que encienda\n"+
                "3-Sacara chispas el motor para encender\n4-Meta Closh saca closh\n" +
                "5-Acelere y vamonos");
    }
}
