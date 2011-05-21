/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class Juego {
    private String currentColor;
    Scanner lea = new Scanner(System.in);

    public void jugar() throws InvalidMoveException{
        currentColor = "Azul";

        while( true ){
            System.out.print("Ingrese el color: ");
            Carta nueva = new Carta( lea.next() );

            validarCarta( nueva );
            System.out.println("");
        }
    }

    private void validarCarta(Carta nueva) throws InvalidMoveException,NullPointerException {
        if( nueva.color.equals( this.currentColor ) )
            System.out.println("Buena Jugada!");
        else
            throw new InvalidMoveException("Color Incorrecto");
    }

}
