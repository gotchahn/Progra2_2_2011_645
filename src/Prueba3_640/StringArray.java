/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prueba3_640;

import Prueba3.InvalidValueException;

/**
 *
 * @author Carlos Gochez
 */
public class StringArray extends Arreglo implements DynamicArray{

    public StringArray(int longi){
        super(longi);
    }

    public boolean addValue(Object val) {
        try{
            return agregarString( val );
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private boolean agregarString(Object val) throws InvalidValueException{
        if( val instanceof String ){
            valores[ contador ] = val;
            contador++;
            return true;
        }
        else{
            throw new InvalidValueException("Valor Incorrecto");
        }
    }

}
