/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

/**
 *
 * @author Carlos Gochez
 */
public class InvalidZoneException extends RuntimeException {
    public InvalidZoneException(char zona){
        super("Zona Invalida: " + zona);
    }
}
