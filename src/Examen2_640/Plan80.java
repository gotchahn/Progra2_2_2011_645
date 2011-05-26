/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2_640;

/**
 *
 * @author Gotcha
 */
public class Plan80 extends PlanAbstracto implements IPlan{
    
    private boolean hasInternet;
    
    public Plan80( double pmin, double pmsg, boolean hi ){
        super( pmin, pmsg );
        hasInternet = hi;
    }

    public double getPrecio(int cantmin, int cantmsg) {
        double total = 80;
        
        if( cantmin > 300 )
            total += (cantmin * this.precioxmin );
        
        if( cantmsg > 150 )
            total += cantmsg * this.precioxmsg;
        
        if( hasInternet )
            total = 15;
        
        return total;
    }
    
}
