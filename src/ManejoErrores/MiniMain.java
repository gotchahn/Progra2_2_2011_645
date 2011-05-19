/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejoErrores;

/**
 *
 * @author Carlos Gochez
 */
public class MiniMain {
    static Cliente clients[] = new Cliente[2];
    static int contador = 0;
    
    public static void main(String args[]){
        Cliente c1 = new Cliente("joel");
        Cliente c2 = new Cliente("wilson");
        Cliente c3 = new Cliente("Daniel");

        try{
            AddCliente(c1);
            System.out.println("paso de 1");
            AddCliente(c2);
            System.out.println("paso de 2");
            AddCliente(c3);
            System.out.println("paso de 3");

            c1.setZona('a');
            System.out.println ("No deberia de abortar");
            c2.setZona('c');
        }
        catch(InvalidZoneException e){
            System.out.println("Se ingreso una zona incorrecto: " +
                    e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }

    public static void AddCliente(Cliente c){
        try{
            clients[contador] = c;
            contador++;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("NO HAY ESPACIO");
        }
    }
}
