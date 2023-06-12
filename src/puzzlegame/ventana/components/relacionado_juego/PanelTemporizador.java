package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Marc Link
 * @author jcasben
 * Panel que contiene el temporizador de la partida.
 */
public class PanelTemporizador extends JPanel implements ActionListener {
    private final Timer TIMER;
    private final JProgressBar progressBar;
    private int tick;
    private final int maxTicks;
    public static PanelTemporizador panTemp;

    /**
     * Crea un nuevo {@link Timer} que se actualiza cada segundo. También inicializa el {@link JProgressBar}.
     * @param tempMax tiempo que tiene que durar el {@link Timer}.
     */
    public PanelTemporizador(int tempMax) {
        setLayout(new BorderLayout());
        maxTicks = tempMax;
        TIMER = new Timer(1000,this);
        TIMER.start();
        progressBar = new JProgressBar();
        progressBar.setBackground(Color.DARK_GRAY);
        progressBar.setForeground(Color.RED);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        add(progressBar);
    }

    /**
     * Instancia estática de {@link PanelTemporizador} para poder referirnos al temporizador desde cualquier parte del
     * programa.
     * @param tempMax tiempo que tiene que durar el {@link Timer}.
     * @return instancia de {@link PanelTemporizador}.
     */
    public static PanelTemporizador iniPanTemp(int tempMax) {
        return panTemp = new PanelTemporizador(tempMax);
    }

    /**
     * Para el {@link Timer}.
     */
    public void pararTemp() {
        TIMER.stop();
    }

    /**
     * Método que ejecuta en cada segundo el {@link Timer}. Este hace avanzar visualmente el {@link JProgressBar}.
     * @param e evento a tratar.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (tick == maxTicks) PanelContenidos.getInstance().cambiarASolucion(false);

        if (tick == 1) progressBar.setValue(progressBar.getValue() + (100 % maxTicks));

        progressBar.setValue(progressBar.getValue() + (100 / maxTicks));
        tick++;
    }
}
