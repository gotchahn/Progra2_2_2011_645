
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Gochez
 */
public abstract class Carta extends JLabel{

    protected Icon cartaFondo;

    public Carta(Icon fondo){

        super( fondo );
        //set el
        cartaFondo = fondo;
    }

    public Icon getIcon(){
        return cartaFondo;
    }

}
