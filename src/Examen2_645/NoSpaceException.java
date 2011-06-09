/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

/**
 *
 * @author Carlos Gochez
 */
public class NoSpaceException extends Exception {
    public NoSpaceException(){
        super("Ya no hay espacio en el arreglo");
    }
}
