package puzzlegame.windows.components;

import puzzlegame.io.FicheroPartidaIn;

import javax.swing.*;
import java.awt.*;

public class PanelClasificacion extends JPanel {

    public static final int CLASIFICACION = 0;
    public static final int HISTORIAL_SELECTIVO = 1;

    public PanelClasificacion(int mode) {
        setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        jta.setFont(new Font("calibri",1,30));
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        if (mode == CLASIFICACION) {
            jta.setText(new FicheroPartidaIn().leerPartidas());
        } else if (mode == 1) {
            jta.setText(new FicheroPartidaIn().leerSelectivo(JOptionPane.showInputDialog(
                    null,
                    "INTRODUCE EL NOMBRE DEL JUGADOR BUSCADO:"
            )));
        }

        setVisible(true);
        add(sp);
    }
}
