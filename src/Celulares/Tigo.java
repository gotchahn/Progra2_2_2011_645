/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Celulares;

import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class Tigo {
    private static PlanCliente pcs[];
    private static int contador=0;
    private static Scanner lea = new Scanner(System.in);

    public static void main(String args[]){
        System.out.print("De cuantos planes?: ");
        int cuantos = lea.nextInt();
        int op;
        pcs = new PlanCliente[cuantos];

        do{
            System.out.println("MENU\n--------------------");
            System.out.println("1- Agregar Plan");
            System.out.println("2- Buscar Cliente");
            System.out.println("3- Estadistica");
            System.out.println("4- Cobros Mensuales");
            System.out.println("5- Imprimir Todo");
            System.out.println("6- SubMenu para un PlanAmigo");
            System.out.println("7- Salir");

            System.out.println("Ingrese Opcion: ");
            op = lea.nextInt();

            switch( op ){
                case 1:
                    char tipo;
                    do{
                        System.out.println("De Que tipo? (A o B)");
                        tipo = lea.next().charAt(0);
                    }while( tipo != 'A' && tipo != 'B' );

                    if( agregarPlan(tipo) )
                        System.out.println("Se Agrego Muy Bien");
                    else
                        System.out.println("Ya no hay espacio en el arreglo");

                    break;
                case 2:
                    System.out.print("Quien quiere buscar?: ");
                    String n = lea.next();

                    if( buscarCliente( n ) )
                        System.out.println("Se encontro el plan");
                    else
                        System.out.println("No Se encontro el plan");

                    break;
                case 3:
                    estadistica();
                    break;
                case 4:
                    cobrosTotales();
                    break;
                case 5:
                    imprimirTodo();
                    break;
                case 6:
                    menuPlanAmigos();
                    break;
            }

        }while( op != 7);
    }

    private static boolean agregarPlan(char tipo) {
        if( contador < pcs.length ){
            //hay espacio
            //pido los datos comunes
            System.out.print("Ingrese Nombre: ");
            String n = lea.next();
            System.out.print("Ingrese Numero: ");
            int num = lea.nextInt();

            if( tipo == 'A' )
                pcs[ contador ] = new PlanAmigos(n,num);
            else{
                //pedir lo extra
                System.out.print("Ingrese Pin: ");
                int pin = lea.nextInt();
                System.out.print("Es Social? (s/n) ");
                char social = lea.next().charAt(0);

                pcs[ contador ] = new PlanBlackBerry(n,num,pin, social == 's' ? true : false );
            }

            contador++;
            return true;
        }
        return false;
    }

    //--------------------------------------------------------
    private static boolean buscarCliente(String n) {
        return buscarCliente(n,0);
    }

    private static boolean buscarCliente(String n, int pos) {
        if( pos < pcs.length ){
            if( pcs[pos] != null && pcs[pos].getNombre().equals(n) ){
                return true;
            }
            return buscarCliente(n,pos+1);
        }
        return false;
    }

    //------------------------------------------

    private static void estadistica() {
        int ca = 0, cb = 0;

        for( PlanCliente pc : pcs ){
            if( pc instanceof PlanAmigos )
                ca++;
            else if( pc instanceof PlanBlackBerry )
                    cb++;
        }

        System.out.printf("Hay %d Planes Amigos y %d BlackBerries\n",ca,cb);
    }

    //-------------------------------------
    private static void imprimirTodo() {
        imprimirTodo(0);
    }

    private static void imprimirTodo(int pos) {
        if( pos < pcs.length ){
            if( pcs[pos] != null ){
                pcs[pos].imprimir();

                imprimirTodo(pos+1);
            }
        }
    }
    //------------------------------------------

    private static void cobrosTotales() {
        double total = 0;

        for( PlanCliente pc : pcs ){
            if( pc != null ){
                System.out.println("Cargos para " + pc.getNombre() +
                        "\n--------------------");
                System.out.print("Cuantos Minutos consumio?: ");
                int mins = lea.nextInt();
                System.out.print("Cuantos Msgs Consumio?: ");
                int msgs = lea.nextInt();

                double monto = pc.getPago(mins, msgs);

                System.out.println("El cliente " + pc.getNombre() +
                        " tendra que pagar L." + monto);

                total += monto;
            }
        }

        System.out.println("\nTotal generado: " + total);
    }

    private static void menuPlanAmigos() {
        int op;
        do{
            System.out.println("1- Agregar Amigo");
            System.out.println("2- Borrar Numero");
            System.out.println("3- Regresar al Menu");

            System.out.println("\nIngrese Opcion: ");
            op = lea.nextInt();

            switch( op ){
                case 1:
                    agregarAmigo();
                    break;
                case 2:
                    borrarAmigo();
                    break;
            }
        }while( op != 3);
    }

    //Para ambas funciones RECUERDEN que los objetos creados de tipo PlanAmigos
    //ya tienen las funciones para agregar y borrar un numero, asi que usenlas aqui
    //lo mas seguro tengan que hacer DownCasting del objeto PlanCliente del
    //arreglo al objeto especifico de PlanAmigos.
    
    private static void agregarAmigo() {
        //TODO = Poder agregar un amigo en un plan de Amigos.
        //Pero ojo necesitar encontrar el plan al cual le van agregar el numero
        //amigo, y deben de ASEGURARSE que ese plan de verdad sea de tipo
        //PlanAmigos y no PlanBlackBerry
    }

    private static void borrarAmigo() {
        //TODO = similar a la funcion anterior solo que ahora vamos a eliminar
        //un amigo del plan.
    }




}
