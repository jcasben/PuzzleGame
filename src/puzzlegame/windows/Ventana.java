package puzzlegame.windows;

import puzzlegame.Partida;
import puzzlegame.windows.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class Ventana extends JFrame {
    public Ventana() {
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
        setContentPane(PanelContenidos.getInstance());
        initMenuBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

        JMenuItem mNewGame = new JMenuItem("NUEVA PARTIDA");
        mNewGame.addActionListener(e -> new Partida());
        menu.add(mNewGame);

        JMenuItem mClasif = new JMenuItem("HISTORIAL GENERAL");
        mClasif.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion());
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
