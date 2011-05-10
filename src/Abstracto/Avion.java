/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstracto;

/**
 *
 * @author Carlos Gochez
 */
public class Avion extends MedioTransporte {
    public Avion(int serial){
        super(serial,TIPO_MEDIO_AIR);
    }

    public void moverse(){
        System.out.println("Agarrar envion, suspenderse, y luego meter llantas");
    }
}
