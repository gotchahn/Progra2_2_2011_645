/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

/**
 *
 * @author Carlos Gochez
 */
public class Post {
    public String status;
    public String comments[];

    public Post(String s){
        status = s;
        comments = new String[Comentable.MAX_COMMENTS];
    }
    
}
