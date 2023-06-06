package puzzlegame.windows.components;

import javax.swing.*;

public class SubImagen {
    private ImageIcon subimagen;
    private int posicionCorrecta, posicionActual;
    private JLabel JLabelSubimagen;
    public SubImagen (ImageIcon img, int pos){
        JLabelSubimagen =  new JLabel(img);
        JLabelSubimagen.setBorder(null);
        subimagen = img;
        posicionCorrecta = pos;
        posicionActual = pos;
    }

    public int getPosicionCorrecta(){
        return posicionCorrecta;
    }
    public int getPosicionActual(){ return posicionActual; }
    public ImageIcon getSubimagen(){
        return subimagen;
    }
    public JLabel getJLabelSubimagen(){
        return JLabelSubimagen;
    }
    
    public void setPosicionActual(int posA) {
        posicionActual = posA;
    }

}
