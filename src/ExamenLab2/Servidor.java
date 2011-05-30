/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author Gotcha
 */
public abstract class Servidor {
    protected String nombre;
    protected ServidorEntry registros[];
    protected int contador = 0;
    
    public Servidor(String n){
        nombre = n;
        registros = new ServidorEntry[100];
    }
    
    public abstract String getProtocolo();
    public abstract Object devolverPeticion(String key) throws Exception;
    public abstract boolean addEntry(String key,Object reg);
    
    public void printInfo(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Info de Registros\n-----------");
        
        for(ServidorEntry se : registros ){
            if( se != null ){
                System.out.println("Key: " + se.key + "Dato: " 
                        + se.entry.toString() );
            }
        }
    }
    
}
