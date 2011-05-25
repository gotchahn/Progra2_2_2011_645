/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

/**
 *
 * @author Carlos Gochez
 */
public abstract class RedSocial {
    protected Friend buddies[];

    public RedSocial( int longi ){
        buddies = new Friend[longi];
    }

    public abstract void createStatus(String status);

    public boolean addFriend( Friend f ) throws NoSpaceException{
        for(int b=0; b < buddies.length; b++ ){
            if( buddies[b] == null ){
                //pos vacia
                buddies[b] = f;
                return true;
            }
        }
        throw new NoSpaceException();
    }
}
