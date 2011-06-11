/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public class MainTest {
    public static void main(String args[]){
        try{
            ColeccionReal cr = new ColeccionReal(6);
            
            cr.adicionarValor(1);
            cr.adicionarValor(2);
            cr.adicionarValor(3);
            cr.adicionarValor(4);
            cr.adicionarValor(5);
            
            cr.reporteTxt("reporte.txt");
            cr.exportTxt("arreglo.txt");
            
            //probar import
            cr.adicionarValor(6); //este deberia desaparecer
            cr.importTxt("arreglo.txt");
            
            cr.exportTxt("nuevo.txt");
            
            //probemos agregar uno nuevo
            cr.adicionarValor(6);
            cr.exportTxt("final.txt");
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}