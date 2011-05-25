/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

/**
 *
 * @author Carlos Gochez
 */
public class Twitter extends RedSocial{

    String tweets = "";

    public Twitter(int lo){
        super(lo);
    }

    @Override
    public void createStatus(String status) {
        tweets += "\n" + status;
    }

}
