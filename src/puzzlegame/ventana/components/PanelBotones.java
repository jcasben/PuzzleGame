package puzzlegame.ventana.components;

import puzzlegame.entidades.Partida;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class PanelBotones extends JPanel {


    public PanelBotones() {
        setLayout(new GridLayout(4,1));

        JButton nuevaPartidaBoton = new JButton("NUEVA PARTIDA");
        nuevaPartidaBoton.addActionListener(e -> {
            if (Partida.partida != null) {
                JOptionPane.showMessageDialog(null,"DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            Partida.iniPartida();
        });
        nuevaPartidaBoton.setBackground(Color.DARK_GRAY);
        nuevaPartidaBoton.setForeground(Color.WHITE);
        nuevaPartidaBoton.setFocusPainted(false);
        add(nuevaPartidaBoton);

        JButton clasificacionBoton = new JButton("CLASIFICACIÓN GENERAL");
        clasificacionBoton.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.CLASIFICACION));
        clasificacionBoton.setBackground(Color.DARK_GRAY);
        clasificacionBoton.setForeground(Color.WHITE);
        clasificacionBoton.setFocusPainted(false);
        add(clasificacionBoton);

        JButton historialBoton = new JButton("HISTORIAL");
        historialBoton.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.HISTORIAL_SELECTIVO));
        historialBoton.setBackground(Color.DARK_GRAY);
        historialBoton.setForeground(Color.WHITE);
        historialBoton.setFocusPainted(false);
        add(historialBoton);

        JButton salirBoton = new JButton("SALIR");
        salirBoton.setBackground(Color.DARK_GRAY);
        salirBoton.setForeground(Color.WHITE);
        salirBoton.setFocusPainted(false);
        salirBoton.addActionListener(e -> System.exit(0));
        add(salirBoton);

        setVisible(true);
    }
}
