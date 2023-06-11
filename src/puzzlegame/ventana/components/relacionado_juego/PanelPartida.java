package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.entidades.Imagen;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marc Link
 * @author jcasben
 * Contenedor donde se mostrarán los paneles que conforman una partida.
 */
public class PanelPartida extends JPanel {
    /**
     * Crea un nuevo {@link PanelSubImagen} e inicializa el temporizador {@link JProgressBar}. Estos dos elementos se
     * introducen en un {@link JSplitPane}.
     * @param img imagen a partir de la cual se hará el puzzle.
     */
    public PanelPartida(Imagen img) {
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new PanelSubImagen(img.getDivisiones(), img.getFilas(), img.getColumnas()),
                PanelTemporizador.iniPanTemp(img.getFilas() * img.getColumnas() * 2)
        );
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }

}