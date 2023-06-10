package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.gestores.GestorRaton;
import puzzlegame.entidades.SubImagen;
import javax.swing.*;
import java.awt.*;

public class PanelSubImagen extends JPanel {
    public PanelSubImagen(SubImagen [] x, int filas, int columnas) {
        setLayout(new GridLayout(filas,columnas,8,8));
        GestorRaton ml = new GestorRaton(x);
        for (SubImagen sub : x) {
            add(sub.getSubimagen(ml));
        }
    }
}
