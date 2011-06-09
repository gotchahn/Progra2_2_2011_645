/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Files;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class TestFile {

    private static MyFile mf;
    private static Scanner lea = new Scanner(System.in);

    public static void main(String args[]){

        mf = new MyFile();
        lea.useDelimiter(System.getProperty("line.separator"));
        int op;
        do{
            op = menu();

            switch( op ){
                case 1:
                    System.out.println("Ingrese direccion de archivo: ");
                    mf.setFile(lea.next());
                    break;
                case 2:
                    mf.info();
                    break;
                case 3:
                    mf.createFile();
                    break;
                case 4:
                    mf.createDir();
                    break;
                case 5:
                    mf.deleteFile();
                    break;
                case 6:
                    mf.DirCommand();
                    break;
                case 7:
                    System.out.println("Ingrese la nueva direccion: ");
                    String nueva = lea.next();
                    mf.renameMove(nueva);
                    break;
                default:
                    break;
            }

        }while( op != 10 );



    }

    private static int menu() {
        System.out.println("MENU PRINCIPAL\n--------");
        System.out.println("1- Configurar Archivo");
        System.out.println("2- Informacion de Archivo");
        System.out.println("3- Crear Archivo");
        System.out.println("4- Crear Directorios");
        System.out.println("5- Borrar Archivo o Dir");
        System.out.println("6- Listar todo");
        System.out.println("7- Renombrar o Mover");
        System.out.println("\nEscoja Opcion: ");
        return lea.nextInt();
    }


}
