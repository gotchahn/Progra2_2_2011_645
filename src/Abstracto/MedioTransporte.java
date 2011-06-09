/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Abstracto;

/**
 *
 * @author Carlos Gochez
 */
public abstract class MedioTransporte {
    protected int serial;
    protected String via;
    protected int capacidad;
    protected String marca;
    public static final String TIPO_MEDIO_MAR = "MARITIMO";
    public static final String TIPO_MEDIO_AIR = "AEREO";
    public static final String TIPO_MEDIO_TER = "TERRESTRE";

    public MedioTransporte(int s, String v){
        serial = s;
        via = v;
        capacidad = 0;
    }

    public final void setCapacidad(int capa){
        capacidad = capa;
    }

    public void imprimir(){
        System.out.println("Serial: " + serial + " via: " + via+
                " capacidad " + capacidad + " marca " + marca);
    }

    public abstract void moverse();

}
