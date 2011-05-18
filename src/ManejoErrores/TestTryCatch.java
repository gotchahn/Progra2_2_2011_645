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
        r.nextFloat();
        try{
            //r.nextInt();
            System.out.println("Aqui empieza el bloque TRY");
            vals[0] = lea.nextInt();
            System.out.println("Aqui termina el bloque TRY");
        }
        catch(ArrayIndexOutOfBoundsException eb){
            System.out.println("Invalido rango en el arreglo");
        }
       catch(Exception e){
            System.out.println("Aqui empieza el bloque CATCH");
            System.out.println("Msg: " + e.getMessage());
            System.out.println("Error no identificado");
            e.printStackTrace();
        }
        finally{
            System.out.println("Codigo del finally");
        }

        System.out.println("Aqui sigue el programa");
    }
}
