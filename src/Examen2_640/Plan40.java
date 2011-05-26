/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2_640;

/**
 *
 * @author Gotcha
 */
public class Plan40 extends PlanAbstracto implements IPlan{
    
    public Plan40(double pmin,double pmsg){
        super(pmin,pmsg);
    }

    public double getPrecio(int cantmin, int cantmsg) {
        double total = 40 + (cantmsg *  this.precioxmsg );
        
        if( cantmin > 160 )
            total += (cantmin - 160 ) * this.precioxmin;
        
        if( cantmin < 30 )
            total -= total * 0.05;
        
        return total;
    }
    
}
