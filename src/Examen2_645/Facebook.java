/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen2_645;

import java.util.ArrayList;

/**
 *
 * @author Carlos Gochez
 */
public class Facebook extends RedSocial implements Comentable {

    ArrayList<Post> statuses;

    public Facebook(int longi){
        super(longi);
        statuses = new ArrayList<Post>();
    }

    @Override
    public void createStatus(String status) {
        statuses.add(new Post(status));

        /*Si statuses fuera un arreglo de post
         *
         * for(int b=0; b < statuses.lengt; b++){
         *  if( statuses[b] == null ){
         *      statuses[b] = new Post(status);
         *      return;
            }
           }
         * //si llego aqui es porq no hay espacio
         * for(int b=0; b < statuses.lengt; b++){
         *  if( b == 0 )
         *      statuses[0] = new Post(status);
         *  else
         *      statuses[b] = null;
         * }
         *
         */
    }

    public void postComment(String comm, int idPost) {
        int id = 0;
        for(Post p : statuses){
            if( id == idPost ){
                if( p != null ){
                    ///-------
                    for(int c = 0; c < p.comments.length; c++ ){
                        if( p.comments[c] == null || p.comments[c] == "" ){
                            p.comments[c] = comm;
                            return;
                        }
                    }

                    System.out.println("No hay espacio para Comentarios");
                    return;
                    //--------
                }
            }
        }

        throw new NoPostFoundException();
    }

    public void printPost(int idPost) {
        int id = 0;
        for( Post p : statuses ){
            if( idPost == id ){
                if( p != null ){
                    System.out.println("Status: " + p.status);

                    //coments
                    for( String c : p.comments )
                        System.out.println(c);
                }
            }
        }
    }

}
