package puzzlegame.windows.components;

import javax.swing.*;

public class SubImagen extends JLabel {
    private ImageIcon subimagen;
    private int posicion;
    private JLabel JLabelSubimagen;
    public SubImagen (ImageIcon img, int pos){
        JLabelSubimagen =  new JLabel(img);
        subimagen = img;
        posicion = pos;
    }

    public int getPosicion(){
        return posicion;
    }
    public ImageIcon getSubimagen(){
        return subimagen;
    }
    public JLabel getJLabelSubimagen(){
        return JLabelSubimagen;
    }

}
