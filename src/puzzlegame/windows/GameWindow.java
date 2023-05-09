package puzzlegame.windows;

import puzzlegame.windows.components.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class GameWindow extends JFrame {
    private JToolBar tb = new JToolBar();

    public GameWindow() {
        initFrame("test",1300,850);
    }

    /**
     * Inicializa los parametros principales de una ventana.
     * @param name titulo de la ventana
     * @param width ancho de la ventana
     * @param height alto de la ventana
     */
    private void initFrame(String name, int width, int height) {
        setTitle(name);
        setSize(new Dimension(width,height));
        setResizable(false);
        setVisible(true);
        setJMenuBar(initMenuBar());
        setContentPane(new MainPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

        JMenuItem mNewGame = new JMenuItem("NUEVA PARTIDA");
        menu.add(mNewGame);

        JMenuItem mClasif = new JMenuItem("CLASIFICACIÓN GENERAL");
        menu.add(mClasif);

        JMenuItem mHistory = new JMenuItem("HISTORIAL");
        menu.add(mHistory);

        JMenuItem mChangeDir = new JMenuItem("CAMBIAR DIRECTORIO DE IMÁGENES");
        menu.add(mChangeDir);

        JMenuItem mExit = new JMenuItem("SALIR");
        mExit.addActionListener(e -> System.exit(0));
        menu.add(mExit);

        menuBar.add(menu);

       return menuBar;
    }
    /*private void addComponents() {
        container = this.getContentPane();
        //tb.add(new JButton("Menu"),NORTH);
        container.add(new ButtonPanel(),WEST);
        //container.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT),CENTER);
        //container.add(new VisualizationPanel(),EAST);
    }*/
}
