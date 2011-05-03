
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Gochez
 */
public class CampoBatalla {

    public static Marciano soldiers[] = new Marciano[10];
    public static Scanner lea = new Scanner(System.in);

    public static void main(String args[]){
        

        int op;
        do{
            System.out.println("1- Enlistar Marciano");
            System.out.println("2- Lista de Marcianos Enlistados");
            System.out.println("3- Verificar Ataque");
            System.out.println("4- Salir");
            System.out.println("\nIngrese opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    addMarciano();
                    break;
                case 3:
                    verificarAtaque();
                    break;
            }
        
        }while(op != 4);
    }

    private static void addMarciano() {
        int pos = -1;

        for(int m=0; m < soldiers.length; m++ ){
            if( soldiers[m] == null ){
                pos = m;
                break;
            }
        }

        if( pos != -1 ){
            System.out.print("\nIngrese el nombre del Marciano: ");
            String n = lea.next();
            soldiers[pos] = new Marciano(n);
        }
        else{
            System.out.println("Batallon Lleno");
        }
    }

    private static void verificarAtaque() {
        for( int m=0; m < soldiers.length; m++ ){
            if( soldiers[m] != null )
                soldiers[m].Atacar();
        }
        System.out.println("");
    }

    

    



}
