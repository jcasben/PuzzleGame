package puzzlegame.ventana.components;

import puzzlegame.io.FicheroPartidaIn;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasben
 * @author Marc Link
 * Permite ver el historial de partidas.
 */
public class PanelHistorial extends JPanel {
    public static final int HISTORIAL_GENERAL = 0;
    public static final int HISTORIAL_SELECTIVO = 1;

    /**
     * Crea un {@link JTextArea} y escribe en el el historial de partidas. Tiene 2 modos:
     *   - Historial general (0)
     *   - Historial Selectivo (1)
     * @param mode indica el modo.
     * @param nombreBuscado nombre que tendrá que buscar el historial selectivo.
     */
    public PanelHistorial(int mode, String nombreBuscado) {
        setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        if (mode == HISTORIAL_GENERAL) {
            jta.setText(new FicheroPartidaIn().leerPartidas());
        } else if (mode == HISTORIAL_SELECTIVO) {
            jta.setText(new FicheroPartidaIn().leerSelectivo(nombreBuscado));
        }
        jta.setFont(new Font("Monospaced",Font.BOLD,25));
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        setVisible(true);
        add(sp);
    }
}
