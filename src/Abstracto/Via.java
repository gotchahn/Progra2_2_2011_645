/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstracto;

/**
 *
 * @author Carlos Gochez
 */
public class Via {
    public static void main(String args[]){
        MedioTransporte m[] = new MedioTransporte[3];

        m[0] = new Auto(123);
        m[1] = new Avion(12);
        m[2] = new Barco();
    
        for( MedioTransporte me : m ){
            me.moverse();
        }
    }
}
