
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Gochez
 */
public class Juego {
    public static final ImageIcon fondoRevez = new ImageIcon("images/tome4.jpeg");
    private Carta baraja1[];
    
    public void voltiar(int turno){
        for( Carta c : baraja1 ){
            if( turno == 0)
            c.setIcon(fondoRevez);
            else
                 c.setIcon( c.cartaFondo );
        }
    }

    public void showCartas(){
        for( Carta c: baraja1 )
            c.setIcon( c.cartaFondo );
    }

    public static void main(String args[]){
        ArrayList<Carta> al = new java.util.ArrayList<Carta>();
        Carta c1 = new Tome4();
        al.add(c1);
        al.add(c1);
        al.remove(c1);
        JOptionPane.showConfirmDialog(null,"Hello World","" + al.size(),JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, c1.getIcon());

    }
}
