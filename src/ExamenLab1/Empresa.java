/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLab1;

import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class Empresa {
    private static Empleado emps[];
    private static Scanner lea = new Scanner(System.in);

    public static void main(String args[]){
        emps = new Empleado[100];

        agregarEmpleado('T');
        agregarEmpleado('V');
        agregarEmpleado('T');
        agregarEmpleado('T');

        detalle();

        if( buscarEmpleado(1) )
            System.out.println("Si esta");
        else
            System.out.println("No lo esta!");
    }

    private static void agregarEmpleado(char tipo) {
        agregarEmpleado(tipo,0);
    }

    private static void agregarEmpleado(char tipo, int pos) {
        if( pos < emps.length ){
            if( emps[pos] == null ){
                //hay espacio pedir los datos
                int cod = lea.nextInt();
                String n = lea.next();
                double sal = lea.nextDouble();

                //ver de q tipo
                if( tipo == 'T')
                    emps[pos] = new EmpleadoTemporal(cod,n,sal);
                else if( tipo == 'V' ){
                    char z = lea.next().charAt(0);
                    emps[pos] = new EmpleadoPorVentas(cod,n,sal,z);
                }
                else
                    System.out.println("Zona Incorrecta");
            }
            else
                agregarEmpleado(tipo,pos+1);
        }
    }

    private static void detalle() {
        int ct=0,cv=0,vacants=0;

        for( Empleado e : emps ){
            if( e != null ){
                if( e instanceof EmpleadoTemporal )
                    ct++;
                else if( e instanceof EmpleadoPorVentas)
                    cv++;
            }
            else
                vacants++;
        }

        System.out.println("\nDETALLE\n--------");
        System.out.println("Temporales: " + ct);
        System.out.println("Ventas: " + cv);
        System.out.println("Vacantes: " + vacants);
    }

    private static boolean buscarEmpleado(int cod) {
        return buscarEmpleado(cod,0);
    }

    private static boolean buscarEmpleado(int cod, int pos) {
        if( pos < emps.length ){
            if( emps[pos] != null ){
                if( emps[pos].getCodigo() == cod )
                    return true;
                return buscarEmpleado(cod,pos+1);
            }
        }

        return false;
    }

}
