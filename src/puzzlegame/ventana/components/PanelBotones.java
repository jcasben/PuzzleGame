package puzzlegame.ventana.components;

import puzzlegame.entidades.Partida;
import puzzlegame.gestores.GestorEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static puzzlegame.ventana.components.PanelClasificacion.CLASIFICACION;
import static puzzlegame.ventana.components.PanelClasificacion.HISTORIAL_SELECTIVO;

/**
 * @author jcasb
 * @author Marc Link
 */
public class PanelBotones extends JPanel {

    public PanelBotones() {
        setLayout(new GridLayout(4,1));

        addBoton(
                "NUEVA PARTIDA",
                new GestorEventos().nuevaPartida()
        );

        addBoton(
                "CLASIFICACIÓN GENERAL",
                new GestorEventos().clasificacion(CLASIFICACION)
        );

        addBoton(
                "HISTORIAL",
                new GestorEventos().clasificacion(HISTORIAL_SELECTIVO)
        );

        addBoton(
                "SALIR",
                e -> System.exit(0)
        );

        setVisible(true);
    }

    private void addBoton(String texto, ActionListener e) {
        JButton boton = new JButton(texto);
        boton.setBackground(Color.DARK_GRAY);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.addActionListener(e);
        add(boton);
    }
}
