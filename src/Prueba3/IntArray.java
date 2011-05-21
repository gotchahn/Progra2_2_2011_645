/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prueba3;

/**
 *
 * @author Carlos Gochez
 */
public class IntArray implements DynamicArray {
    private int array[];
    private int cont = 0;

    public boolean addValue(Object val) {
        try{
            if( val instanceof Integer ){
                array[cont] = (Integer)val;
                cont++;
            }
            else{
                throw new InvalidValueException("No es de tipo entero el valor");
            }

            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public int length() {
        return array.length;
    }

}
