package puzzlegame.entidades;

import javax.swing.*;
import java.awt.event.MouseListener;

public class SubImagen {
    private int pos;
    private JLabel JLabelSubimagen;


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
