/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLab2;

/**
 *
 * @author Gotcha
 */
public class ServidorDominios extends Servidor{
    
    public ServidorDominios(String n){
        super(n);
    }

    @Override
    public String getProtocolo() {
        return "DNS";
    }

    @Override
    public Object devolverPeticion(String key) throws Exception {
        for(ServidorEntry se : registros){
            if( se != null ){
                if( se.key.equals(key) )
                    return se.entry;
            }
        }
        
        throw new Exception("Key " + key + " No existe");
    }

    @Override
    public boolean addEntry(String key, Object reg) {
        try{
            registros[contador++] = new ServidorEntry( key , reg );
            registros[contador++] = new ServidorEntry( reg.toString() , key );
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ya no hay espacio");
          
        }
        
        return false;
    }
    
}
