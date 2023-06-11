package puzzlegame.entidades;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * @author Marc Link
 * @author jcasben
 * Representa cadda una de las subdivisiones de un puzzle.
 */
public class SubImagen {
    private final int pos;
    private final JLabel JLabelSubimagen;

    /**
     * Genera una nueva subdivisión que conformará un puzzle.
     * @param img trozo de imagen que representará esa subimagen
     * @param pos posicion que ocupa ese trozo de imagen cuando todas las divisiones están ordenadas.
     */
    public SubImagen (ImageIcon img, int pos){
        JLabelSubimagen =  new JLabel(img);
        JLabelSubimagen.setBorder(null);
        JLabelSubimagen.setName(String.valueOf(pos));
        this.pos = pos;
    }

    public JLabel getSubimagen(MouseListener ml){
        JLabelSubimagen.addMouseListener(ml);
        return JLabelSubimagen;
    }

    public int getPos() {
        return pos;
    }
}
