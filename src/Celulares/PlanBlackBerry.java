/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Celulares;

/**
 *
 * @author Carlos Gochez
 */
public class PlanBlackBerry extends PlanCliente{

    private int pin;
    private boolean isSocial;

    public PlanBlackBerry(String n,int num,int p,boolean is){
        super(n,num);
        pin = p;
        isSocial = is;
    }

    public void setPin(int p){
        pin = p;
    }

    public void setIsSocial(boolean is){
        isSocial = is;
    }

    public int getPin(){
        return pin;
    }

    public boolean isSocial(){
        return isSocial;
    }

    @Override
    public double getPago(int cmin, int cmsg) {
        double pago = (cmin*1.2) + (cmsg*0.3);
        pago += isSocial ? 15 : 20;
        return pago;
    }

    @Override
    public void imprimir(){
        System.out.println("\nPlan Blackberry\n--------------");
        super.imprimir();
        System.out.println("Pin: " + pin );
        System.out.println("Tipo " + (isSocial ? "Social" : "FULL") );
    }

}
