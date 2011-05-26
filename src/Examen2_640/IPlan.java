/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2_640;

/**
 *
 * @author Gotcha
 */
public interface IPlan {
    String TIPO_40 = "Tipo40";
    String TIPO_80 = "Tipo80";
    
    double getPrecio( int cantmin, int cantmsg );
}
