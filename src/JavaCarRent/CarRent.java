/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package JavaCarRent;

/**
 *
 * @author Gotcha
 */
public class CarRent {
    public static void main(String args[]){
        FilesControl fc = new FilesControl(50,20);
        int op;
        
        do{
            System.out.println("Menu principal\n-----");
            System.out.println("1- Agregar Auto");
            System.out.println("2- Imprimir Disponibles");
            System.out.println("3- Salir");
            System.out.println("\nEscoja opcion: ");
            op = FilesControl.lea.nextInt();
            
            try{
                switch( op ){
                    case 1:
                        fc.agregarAuto();
                        break;
                    case 2:
                        fc.imprimirDispos();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }while( op != 3 );
    }
}
