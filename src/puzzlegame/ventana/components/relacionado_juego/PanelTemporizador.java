package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTemporizador extends JPanel implements ActionListener {
    private final Timer TIMER;
    private JProgressBar progressBar;
    private int tick;
    private int maxTicks;
    public static PanelTemporizador panTemp;

    public PanelTemporizador(int tempMax) {
        setLayout(new BorderLayout());
        maxTicks = tempMax;
        TIMER = new Timer(1000,this);
        TIMER.start();
        progressBar = new JProgressBar();
        progressBar.setBackground(Color.PINK);
        progressBar.setForeground(Color.DARK_GRAY);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        add(progressBar);
    }

    public static PanelTemporizador iniPanTemp(int tempMax) {
        return panTemp = new PanelTemporizador(tempMax);
    }

    public void pararTemp() {
        TIMER.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tick == maxTicks) PanelContenidos.getInstance().cambiarASolucion(false);
        System.out.println(tick + " " + maxTicks + " " + 100/maxTicks);

        if (tick == 1) progressBar.setValue(progressBar.getValue() + (100 % maxTicks));

        progressBar.setValue(progressBar.getValue() + (100 / maxTicks));
        tick++;
    }
}
