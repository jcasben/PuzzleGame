package puzzlegame.entidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Marc Link
 * @author jcasben
 * Clase encargada de coger imágenes de dentro de un directorio y dividirlas.
 */
public class Imagen extends JPanel {
    private final int ANCHO = 1150;
    private final int ALTO = 700;
    private int filas, columnas;
    private Image img;
    private SubImagen[] divisiones;
    //Path predeterminado para el directorio de imágenes.
    public static String path = "resources/assets/puzzles/";

    /**
     * Crea una nueva imagen dividida en partes.
     * @param filas divisiones horizontales.
     * @param columnas divisiones verticales.
     */
    public Imagen(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        BufferedImage imgSinEscala;
        String imga = escogerImagenAleatoria();
        System.out.println(path);
        try{
            /*
             * Si el método escogerImagenAleatoria() devuelve null, se volverá al path predeterminado de imágenes y se
             * jugará la partida con una de las imágenes extraídas de ese directorio.
             */
            if (imga == null) {
                JOptionPane.showMessageDialog(null, "NO SE HA PODIDO OBTENER NINGUNA IMAGEN \n" +
                        "SE HA VUELTO AL DIRECTORIO PREDETERMINADO");
                path = "resources/assets/puzzles/";
                imga = escogerImagenAleatoria();
            }
            imgSinEscala = ImageIO.read(new File(path  + "/" + imga));
            img = imgSinEscala.getScaledInstance(ANCHO, ALTO, Image.SCALE_DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
        dividir(filas,columnas);
    }

    /**
     * Divide las imagenes en tantas filas y columnas como se indique.
     * @param filas cantidad de filas.
     * @param columnas cantidad de columnas.
     */
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

    /**
     * Desordena el conjunto el divisiones de una imagen.
     * @param s conjunto de divisiones.
     * @param a cantidad de filas.
     * @param b cantidad de columnas.
     */
    private void desordenarSubImag(SubImagen[] s, int a, int b) {
        Random ran = new Random();
        SubImagen aux;
        for (int i = 0; i < (a*b); i++) {
            int k = ran.nextInt(a*b);
            aux = s[k];
            s[k] = s[i];
            s[i] = aux;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].getPos() != i) {
                return;
            }
        }
        desordenarSubImag(s,a,b);
    }

    /**
     * Realizado un listado de los ficheros que están dentro del path actual, guarda los que son imágenes y devuelve
     * una aleatoria.
     * @return nombre de la imagen aleatoria de dentro del directorio.
     */
    private String escogerImagenAleatoria() {
        ArrayList<String> imagenes = new ArrayList<>();
        File [] archivos = new File(path).listFiles(File::isFile);

        if(archivos != null) {
            for (File f : archivos) {
                //Comprobamos si la extensión pertenece al de una imagen.
                if ((f != null) && (f.getName().endsWith(".jpg") ||
                        f.getName().endsWith(".png") ||
                        f.getName().endsWith(".gif") ||
                        f.getName().endsWith(".jpeg"))) {

                    imagenes.add(f.getName());
                }
            }
        }
        Random ran = new Random();

        if (imagenes.size() > 0) {
            int i = ran.nextInt(imagenes.size());
            return imagenes.get(i);
        }
        //Si no hay imagenes en el fichero, devuelve null.
        return null;
    }

    public Image getImg() { return img; }
    public SubImagen [] getDivisiones(){ return divisiones; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }

}
