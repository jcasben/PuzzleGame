package puzzlegame.entidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Imagen extends JPanel {
    private final int ANCHO = 1150;
    private final int ALTO = 700;
    private int filas, columnas;
    private Image img;
    private SubImagen[] divisiones;



    public Imagen(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        BufferedImage imgSinEscala;
        try{
            imgSinEscala = ImageIO.read(new File("resources/assets/puzzles/" + nombreImagen()  + ".jpg"));
            img = imgSinEscala.getScaledInstance(ANCHO,ALTO,Image.SCALE_DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
        dividir(filas,columnas);
    }

    private void dividir(int filas, int columnas){
        divisiones = new SubImagen[filas*columnas];
        int contador = 0;
        for (int i = 0; i < filas ; i++) {
            for (int j = 0; j < columnas; j++) {
                Image imagen = createImage(new FilteredImageSource(img.getSource(),
                        new CropImageFilter(j*(ANCHO/columnas),i*(ALTO/filas),ANCHO/columnas,ALTO/filas)));
                divisiones[contador] = new SubImagen(new ImageIcon(imagen), contador);
                contador++;
            }
        }
        desordenarSubImag(divisiones, filas,columnas);
    }

    private void desordenarSubImag(SubImagen[] s, int a, int b) {
        Random ran = new Random();
        SubImagen aux;
        for (int i = 0; i < (a*b); i++) {
            int k = ran.nextInt(a*b);
            aux = s[k];
            s[k] = s[i];
            s[i] = aux;
        }
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
    public Image getImg() { return img; }
    public SubImagen [] getDivisiones(){ return divisiones; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }

}
