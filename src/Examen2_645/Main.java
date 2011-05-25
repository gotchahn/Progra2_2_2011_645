/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gochez
 */
public class Main {
    public static void Main(String args[]){
        RedSocial reds[] = new RedSocial[2];
        reds[0] = new Facebook(100);
        reds[1] = new Twitter(100);

        try {
            reds[0].addFriend(new Friend("Carlos"));
        } catch (NoSpaceException ex) {
            System.out.println("Error:  " + ex.getMessage());
        }
    }
}
