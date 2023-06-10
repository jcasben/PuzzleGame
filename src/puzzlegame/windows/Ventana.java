package puzzlegame.windows;

import puzzlegame.Partida;
import puzzlegame.entidades.Imagen;
import puzzlegame.windows.components.PanelClasificacion;
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
        setIconImage(new ImageIcon("resources/assets/icono.jpg").getImage());
        setTitle(name);
        setSize(new Dimension(width,height));
        setResizable(false);
        setVisible(true);
        setContentPane(PanelContenidos.getInstance());
        setJMenuBar(initMenuBar());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

        JMenuItem nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
        nuevaPartidaMenu.addActionListener(e -> {
            if (Partida.partida != null) {
                JOptionPane.showMessageDialog(null,"DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            Partida.iniPartida();
        });
        menu.add(nuevaPartidaMenu);

        JMenuItem clasificacionMenu = new JMenuItem("HISTORIAL GENERAL");
        clasificacionMenu.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.CLASIFICACION));
        menu.add(clasificacionMenu);

        JMenuItem historialMenu = new JMenuItem("HISTORIAL");
        historialMenu.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.HISTORIAL_SELECTIVO));
        menu.add(historialMenu);

        JMenuItem cambiarDirectorioMenu = new JMenuItem("CAMBIAR DIRECTORIO DE IMÁGENES");
        menu.add(cambiarDirectorioMenu);

        JMenuItem salirMenu = new JMenuItem("SALIR");
        salirMenu.addActionListener(e -> System.exit(0));
        menu.add(salirMenu);

        menuBar.add(menu);

       return menuBar;
    }
}
