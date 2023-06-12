package puzzlegame.ventana.components;

import puzzlegame.gestores.GestorEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static puzzlegame.ventana.components.PanelHistorial.HISTORIAL_GENERAL;
import static puzzlegame.ventana.components.PanelHistorial.HISTORIAL_SELECTIVO;

/**
 * @author jcasb
 * @author Marc Link
 * Panel que contiene los botones del panel lateral del menú.
 */
public class PanelBotones extends JPanel {
    //Crea y añade los botones al panel lateral.
    public PanelBotones() {
        setLayout(new GridLayout(4,1));

        addBoton(
                "NUEVA PARTIDA",
                new GestorEventos().nuevaPartida()
        );

        addBoton(
                "HISTORIAL GENERAL",
                new GestorEventos().clasificacion(HISTORIAL_GENERAL)
        );

        addBoton(
                "HISTORIAL SELECTIVO",
                new GestorEventos().clasificacion(HISTORIAL_SELECTIVO)
        );

        addBoton(
                "SALIR",
                e -> System.exit(0)
        );

        setVisible(true);
    }

    /**
     * Método que genera botones y los añade al panel.
     * @param texto texto que contendrá el botón.
     * @param e ActionListener que tendrá el botón.
     */
    private void addBoton(String texto, ActionListener e) {
        JButton boton = new JButton(texto);
        boton.setBackground(Color.DARK_GRAY);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.addActionListener(e);
        add(boton);
    }
}
