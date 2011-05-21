/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

/**
 *
 * @author Carlos Gochez
 */
public class InvalidMoveException extends Exception {
    public InvalidMoveException(String msg){
        super(msg);
    }
}
