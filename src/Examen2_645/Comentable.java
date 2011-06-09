/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

/**
 *
 * @author Carlos Gochez
 */
public interface Comentable {
    int MAX_COMMENTS = 1000;
    void postComment(String comm,int idPost);
    void printPost(int idPost);
}
