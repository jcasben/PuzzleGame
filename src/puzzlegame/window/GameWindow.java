package puzzlegame.window;

import puzzlegame.window.components.ButtonsPanel;
import puzzlegame.window.components.VisualizationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class GameWindow extends JFrame {
    private Container container;
    private ButtonsPanel buttons = new ButtonsPanel();
    private VisualizationPanel visualizer = new VisualizationPanel();
    private JToolBar tb = new JToolBar();

    public GameWindow() {
        initFrame("test",0,0,1400,800);

        container = this.getContentPane();
        tb.add(new JButton("Menu"));
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttons, visualizer);
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tb,jsp);

        container.add(jsp2);
    }

    /**
     * Inicializa los parametros principales de una ventana.
     * @param name titulo de la ventana
     * @param x posicion respecto al eje X
     * @param y posicion respecto al eje Y
     * @param width ancho de la ventana
     * @param height alto de la ventana
     */
    private void initFrame(String name, int x, int y, int width, int height) {
        setTitle(name);
        setBounds(x,y,width,height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
