package puzzlegame.windows.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

public class Imagen extends JPanel {
    private final int ANCHO = 1000;
    private final int ALTO = 700;
    private int width, height;
    private int contador = 0;
    private Image img; //imagen sin la dimension generica



    public Imagen(String nombreImagen){
        BufferedImage imgSinEscala;
        try{
            imgSinEscala = ImageIO.read(new File("resources/assets/puzzles/" + nombreImagen  + ".jpg"));
            img = imgSinEscala.getScaledInstance(ANCHO,ALTO,Image.SCALE_DEFAULT);
            width = img.getWidth(null);
            height = img.getHeight(null);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public SubImagen[] dividir(int filas, int columnas){
        SubImagen [] divisiones = new SubImagen[filas*columnas];
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < columnas; j++) {
                Image imagen = createImage(new FilteredImageSource(img.getSource(),
                        new CropImageFilter(j*(width/columnas),i*(height/filas),width/columnas,height/filas)));
                divisiones[contador++] = new SubImagen(new ImageIcon(imagen), contador);
            }
        }
        return divisiones;
    }


}
