/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Examen1;

import java.util.Scanner;

/**
 *
 * @author Carlos Gochez
 */
public class CableTV extends Servicio{
    private String canales[];
    private boolean isDigital;
    private Scanner lea = new Scanner(System.in);

    public CableTV(String n,int c,int l,boolean is){
        super( n , c );
        canales = new String[ l ];
        isDigital = is;
    }

    public void agregarCanales(){
        agregarCanales(0);
    }

    private void agregarCanales(int pos) {
        if( pos < canales.length ){
            canales[pos] = lea.next();
            agregarCanales(pos + 1);
        }
    }

    public boolean buscarCanal(String canal){
        return buscarCanal(canal,0);
    }

    private boolean buscarCanal(String canal, int pos) {
        if( pos < canales.length ){
            if( canal.equals(canales[pos]))
                return true;
            return buscarCanal(canal,pos+1);
        }
        return false;
    }

    @Override
    public double getMonto(){
        monto = canales.length * 5;
        monto += isDigital ? 5 : 0;
        return monto;
    }

    public void imprimir(){
        super.imprimir();

        for(String c : canales){
            System.out.println("Canal: " + c);
        }

        System.out.println((isDigital ? " Digital " : " No Digital "));
    }
}










