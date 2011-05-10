/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLab1;

import java.util.Date;

/**
 *
 * @author Carlos Gochez
 */
public class Empleado {
    protected int codigo;
    protected String nombre;
    protected double salario;
    protected Date incorporado;

    public Empleado( int c , String n, double s){
        codigo = c;
        nombre = n;
        salario = s;
        incorporado = new Date();
    }

    public int getCodigo(){
        return codigo;
    }

    public double getSalario(){
        return salario;
    }
}
