/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

/**
 *
 * @author Carlos Gochez
 */
public class Cliente {
    public String nombre;
    public char zona;

    public Cliente(String n){
        nombre = n;
    }

    public void setZona( char zona ){
        switch( zona ){
            case 'a':
            case 'b':
                this.zona = zona;
                break;
            default:
                throw new InvalidZoneException(zona);
        }
    }
}
