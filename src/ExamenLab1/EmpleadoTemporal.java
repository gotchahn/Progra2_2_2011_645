/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLab1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Carlos Gochez
 */
public class EmpleadoTemporal extends Empleado {
    private Date fechafin;

    public EmpleadoTemporal(int c,String n,double s){
        super(c,n,s);
        fechafin = incorporado;
    }

    public void setFechaFin(int year,int mes,int dia){
        Calendar c = Calendar.getInstance();
        c.set(year, mes, dia);
        Date now = c.getTime();

        if( now.getTime() > incorporado.getTime() ){
            fechafin = now;
        }
        else{
            System.out.println("Fecha Invalida, es menor a la fecha de Incorporacion\n");
        }

    }
}
