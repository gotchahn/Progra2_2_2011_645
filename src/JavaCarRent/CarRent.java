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
            System.out.println("3- Rentar Auto");
            System.out.println("4- Imprimir Transacciones hechas");
            System.out.println("5- Salir");
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
                    case 3:
                        System.out.println("Ingrese Placa: ");
                        String placa = FilesControl.lea.next();
                        fc.rentarAuto(placa);
                        break;
                    case 4:
                        fc.imprimiTrans();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }while( op != 5 );
    }
}
