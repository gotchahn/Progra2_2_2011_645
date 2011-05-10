/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstracto;

/**
 *
 * @author Carlos Gochez
 */
public class Barco extends MedioTransporte {
    public Barco(){
        super(123,TIPO_MEDIO_MAR);
    }

    public void moverse() {
        System.out.println("1-Encender motores\n2-Mover turninas\n" +
                "3-Navegar por el mar");
    }

    public void imprimir(){
        System.out.println("Yujuu");
    }
}
