package puzzlegame.ventana;

import puzzlegame.gestores.GestorEventos;
import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;

import static puzzlegame.ventana.components.PanelHistorial.*;

/**
 * @author jcasb
 * @author Marc Link
 * Crea el Frame principal del programa.
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

    /**
     * Inicializa un JMenuBar y le añade las opciones necesarias.
     * @return objeto {@link JMenuBar}.
     */
    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.DARK_GRAY);
        JMenu menu = new JMenu("MENU");
        menu.setBackground(Color.DARK_GRAY);
        menu.setForeground(Color.WHITE);

        JMenuItem nuevaPartidaMenu = new JMenuItem("NUEVA PARTIDA");
        nuevaPartidaMenu.addActionListener(new GestorEventos().nuevaPartida());
        menu.add(nuevaPartidaMenu);

        JMenuItem clasificacionMenu = new JMenuItem("HISTORIAL GENERAL");
        clasificacionMenu.addActionListener(new GestorEventos().clasificacion(HISTORIAL_GENERAL));
        menu.add(clasificacionMenu);

        JMenuItem historialMenu = new JMenuItem("HISTORIAL SELECTIVO");
        historialMenu.addActionListener(new GestorEventos().clasificacion(HISTORIAL_SELECTIVO));
        menu.add(historialMenu);

        JMenuItem cambiarDirectorioMenu = new JMenuItem("CAMBIAR DIRECTORIO DE IMAGENES");
        cambiarDirectorioMenu.addActionListener(new GestorEventos().cambiarDirectorio());
        menu.add(cambiarDirectorioMenu);

        JMenuItem salirMenu = new JMenuItem("SALIR");
        salirMenu.addActionListener(e -> System.exit(0));
        menu.add(salirMenu);

        menuBar.add(menu);

       return menuBar;
    }
}
