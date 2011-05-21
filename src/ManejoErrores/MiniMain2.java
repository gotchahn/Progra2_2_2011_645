/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class MiniMain2 {
    public static void main(String args[]){
        Juego j = new Juego();
Scanner lea;
RandomAccessFile r;
        try{
            j.jugar();
        }
        catch(InvalidMoveException e){
            System.out.println("Error: " + e.getMessage());
        }

        int arr[] = {1,2,3};
        imp(arr);
    }

    private static void imp(int[] arr) {
        imp(arr,0);
    }

    private static void imp(int[] arr, int i) {
        try{
            System.out.println("Pos: " +
                    arr[i]);
            imp(arr,i+1);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Se acabo Arreglo");
        }
    }


}
