package puzzlegame.ventana.components;

import puzzlegame.io.FicheroPartidaIn;

import javax.swing.*;
import java.awt.*;

public class PanelClasificacion extends JPanel {

    public static final int CLASIFICACION = 0;
    public static final int HISTORIAL_SELECTIVO = 1;

    public PanelClasificacion(int mode, String nombreBuscado) {
        setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        if (mode == CLASIFICACION) {
            jta.setText(new FicheroPartidaIn().leerPartidas());
        } else if (mode == 1) {
            jta.setText(new FicheroPartidaIn().leerSelectivo(nombreBuscado));

        }
        jta.setFont(new Font("Monospaced",1,25));
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        setVisible(true);
        add(sp);
    }
}