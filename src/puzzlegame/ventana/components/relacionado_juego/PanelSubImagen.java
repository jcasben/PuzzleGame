package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.gestores.GestorRaton;
import puzzlegame.entidades.SubImagen;
import javax.swing.*;
import java.awt.*;

/**
 * @author Marc Link
 * @author jcasben
 * Contenedor donde se colocarán las subdivisiones de las imágenes.
 */
public class PanelSubImagen extends JPanel {
    /**
     * Crea el panel con las subimágenes dentro colocadas.
     * @param x conjunto de subimágenes.
     * @param filas cantidad de filas.
     * @param columnas cantidad de columnas.
     */
    public PanelSubImagen(SubImagen [] x, int filas, int columnas) {
        setLayout(new GridLayout(filas,columnas,5,5));
        GestorRaton ml = new GestorRaton(x);
        for (SubImagen sub : x) {
            add(sub.getSubimagen(ml));
        }
    }
}
