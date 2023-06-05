package puzzlegame.windows.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class PanelPartida extends JPanel {

    public PanelPartida(int filas, int columnas) {
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, iniPanelPartida(filas, columnas), new FooterPanel());
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }

    private JPanel iniPanelPartida(int filas, int columnas) {
        //PanelSubImagen puzzle = new PanelSubImagen(filas,columnas);

        JPanel puzzle = new JPanel();
        puzzle.setLayout(new GridLayout(filas,columnas,5,5));
        Imagen img  = new Imagen(nombreImagen());
        SubImagen [] subImagenes = img.dividir(filas, columnas); //Generamos las subimagenes.
        for (int i = 0; i < filas*columnas; i++) {

            puzzle.add(subImagenes[i].getJLabelSubimagen());
        }
        return puzzle;
    }
    private String nombreImagen() {
        Random ran = new Random();
        String nombre  = null;
        int i = ran.nextInt(3);
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
        }
        return nombre;

    }
}



/*

        panelPartida = new JPanel();


        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("resources/assets/puzzles/" + nombreImagen() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(1200,850,Image.SCALE_DEFAULT)));
        panelPartida.add(picLabel);

        return panelPartida;

        --------------------------------------------------------------------------------

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

