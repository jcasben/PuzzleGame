package puzzlegame.windows;

import puzzlegame.Game;
import puzzlegame.windows.components.HistorialPanel;
import puzzlegame.windows.components.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class GameWindow extends JFrame {
    JSplitPane jsp = new JSplitPane();
    public GameWindow() {
        initFrame("PUZZLE GAME - PRACTICA FINAL PROGRAMACION II 2022-2023",1300,850);
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
        setContentPane(new MainPanel(jsp,this));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JMenuBar initMenuBar(JSplitPane jsp) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

        JMenuItem mNewGame = new JMenuItem("NUEVA PARTIDA");
        mNewGame.addActionListener(e -> new Game(jsp));
        menu.add(mNewGame);

        JMenuItem mClasif = new JMenuItem("HISTORIAL GENERAL");
        mClasif.addActionListener(e -> jsp.setRightComponent(new HistorialPanel()));
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
}
