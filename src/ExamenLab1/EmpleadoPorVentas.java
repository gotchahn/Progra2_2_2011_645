/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLab1;

/**
 *
 * @author Carlos Gochez
 */
public class EmpleadoPorVentas extends Empleado {
    private char zona;
    private double ventas;

    public EmpleadoPorVentas(int c, String n, double s, char z){
        super(c,n,s);
        zona = z;
        ventas = 0;
    }

    public void setVentas(double v){
        ventas = v;
    }

    @Override
    public double getSalario(){
        switch( zona ){
            case 'A':
                return salario + (ventas*0.05);
            case 'B':
                return salario + (ventas*0.03);
            default:
                System.out.println("Zona Incorecta\n");
                return 0;
        }
    }
}
