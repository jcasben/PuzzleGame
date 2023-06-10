package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.entidades.Imagen;

import javax.swing.*;
import java.awt.*;

public class PanelPartida extends JPanel {

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