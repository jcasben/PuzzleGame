package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanelSubImagen extends JPanel {
    public PanelSubImagen(int filas, int columnas) {
        setLayout(new GridLayout(filas,columnas,0,5));
        Imagen img  = new Imagen(nombreImagen());
        SubImagen [] subImagenes = img.dividir(filas, columnas); //Generamos las subimagenes.
        desordenarSubImag(subImagenes, filas, columnas);
        for (int i = 0; i < filas*columnas; i++) {

            add(subImagenes[i].getJLabelSubimagen());
        }
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
}
