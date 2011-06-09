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
            System.out.println("5- Entregar Auto");
            System.out.println("6-" + Prueba5Daniel.getOpcion());
            System.out.println("7-" + Prueba5Mauricio.getOpcion());
            System.out.println("8-" + Prueba5Manuel.getOpcion());
            System.out.println("9-" + Prueba5David.getOpcion());
            System.out.println("10-" + Prueba5Carlos.getOpcion());
            System.out.println("11- Salir");
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
                    case 5:
                        System.out.println("Ingrese el numero de la Factura: ");
                        int fact = FilesControl.lea.nextInt();
                        fc.entregarAuto(fact);
                        break;
                    case 6:
                        Prueba5Daniel.funcion(rautos,rtrans);
                        break;
                     case 7:
                        Prueba5Mauricio.funcion(rautos,rtrans);
                        break;
                     case 8:
                        Prueba5Manuel.funcion(rautos,rtrans);
                        break;
                     case 9:
                        Prueba5David.funcion(rautos,rtrans);
                        break;
                     case 10:
                        Prueba5Carlos.funcion(rautos,rtrans);
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }while( op != 11 );
    }
}
