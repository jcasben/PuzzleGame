package puzzlegame.windows.components;

import puzzlegame.entidades.Imagen;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanelSubImagen extends JPanel {
    public PanelSubImagen(Imagen img) {
        setLayout(new GridLayout(img.getFilas(),img.getColumnas()));
        for (int i = 0; i < img.getDivisiones().length; i++) {
            add(img.getDivisiones()[i].getJLabelSubimagen());
        }
    }
}
