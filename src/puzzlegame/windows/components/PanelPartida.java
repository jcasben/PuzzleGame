package puzzlegame.windows.components;

import puzzlegame.entidades.Imagen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class PanelPartida extends JPanel {

    public PanelPartida(Imagen img) {
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new PanelSubImagen(img.getDivisiones(), img.getFilas(), img.getColumnas()), new FooterPanel());
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }

    public void actualizar () {

    }

}