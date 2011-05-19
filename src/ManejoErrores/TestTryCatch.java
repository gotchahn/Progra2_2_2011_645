/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class TestTryCatch {
    public static void main(String args[]){
        Scanner lea = new Scanner(System.in);
        int vals[] = {1,2,3};
        Random r = null;
      //  r.nextFloat();

        try{
            //r.nextInt();
            System.out.println("Aqui empieza el bloque TRY");
            vals[8] = lea.nextInt();
            System.out.println("Aqui termina el bloque TRY");
        }
        catch(ArrayIndexOutOfBoundsException ai ){
                System.out.println("Por favor utilize una posicion valida del arreglo");
                System.out.println("Pos: " + ai.getMessage());
                ai.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Aqui empieza el bloque CATCH");
            System.out.println("ERROR!!!!");
        }
        

        System.out.println("Aqui sigue el programa");
    }
}
