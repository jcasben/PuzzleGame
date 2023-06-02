package puzzlegame.windows.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PanelPartida extends JPanel {
    private JPanel panelPartida;
    public PanelPartida(int filas, int columnas) {
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,iniPanelPartida(filas,columnas), new FooterPanel());
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }
    // hay que dividir las imagenes
    private JPanel iniPanelPartida(int filas, int columnas) {
        panelPartida = new JPanel();
        /*
        panelPartida.setLayout(new GridLayout(filas,columnas));
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("resources/assets/puzzles/" + nombreImagen() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panelPartida.add(picLabel);

         */


        return panelPartida;
    }
    private String nombreImagen() {
        Random ran = new Random();
        String nombre  = null;
        int i = ran.nextInt(4);
        switch (i){
            case 0:
                nombre = "911";
                break;
            case 1:
                nombre = "elefante";
                break;
            case 2:
                nombre = "mazda-rx7";
                break;
            case 3:
                nombre = "porsche";
                break;
        }
        return nombre;

    }
}



/*
        setLayout(new BorderLayout());
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("resources/assets/backgroundUIB.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);

        setVisible(true);
 */