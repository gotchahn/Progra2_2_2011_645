/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2_640;

/**
 *
 * @author Gotcha
 */
public class Cliente {
    public String nombre;
    public String numTell;
    public PlanAbstracto plan;
    
    public Cliente( String n, String tel){
        nombre = n;
        numTell = tel;
    }
    
    public void setPlan(PlanAbstracto p) throws TipoInvalidoException{
        if( p instanceof Plan40 || p instanceof Plan80 )
            plan = p;
        else
            throw new TipoInvalidoException();
    }
}
