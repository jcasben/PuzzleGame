package puzzlegame.ventana.components;

import puzzlegame.entidades.Partida;
import puzzlegame.entidades.Imagen;
import puzzlegame.gestores.GestorEventos;
import puzzlegame.ventana.components.relacionado_juego.PanelPartida;
import puzzlegame.ventana.components.relacionado_juego.PanelSolucion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static puzzlegame.ventana.components.PanelClasificacion.*;

/**
 * @author jcasb
 * @author Marc Link
 */
public class PanelContenidos extends JPanel {
    private JToolBar iconosMenu;
    private final JSplitPane jsp;
    private Imagen imagenPartida;
    private final String pathIconos = "resources/assets/icons/";

    private static final PanelContenidos panelContenidos = new PanelContenidos();

    public PanelContenidos() {
        setLayout(new BorderLayout());

        //Declaración de JSplitPanes
        this.jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        this.jsp.setLeftComponent(new PanelBotones());
        this.jsp.setRightComponent(new PanelStandBy());
        this.jsp.setDividerLocation(180);
        this.jsp.setEnabled(false);

        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, iniciarBarraTareas(),this.jsp);
        jsp2.setEnabled(false);

        add(jsp2);
        setVisible(true);
    }

    public static PanelContenidos getInstance() {
        return panelContenidos;
    }

    /**
     * Crea e inicializa una barra de herramientas que contiene los botones requeridos para realizar las opciones que
     * debe incluir el menu.
     * @return objeto de la clase {@link JToolBar}
     */
    private JToolBar iniciarBarraTareas() {
        iconosMenu = new JToolBar();
        iconosMenu.setFloatable(false);
        // ---------------------------------------- Creación de los botones ----------------------------------------
        addBoton(
                new ImageIcon(pathIconos + "newGame.jpg"),
                new GestorEventos().nuevaPartida()
        );

        addBoton(
                new ImageIcon(pathIconos + "generalHist.jpg"),
                new GestorEventos().clasificacion(CLASIFICACION)
        );

        addBoton(
                new ImageIcon(pathIconos + "selectiveHist.jpg"),
                new GestorEventos().clasificacion(HISTORIAL_SELECTIVO)
        );

        addBoton(
                new ImageIcon(pathIconos + "changeDir.jpg"),
                new GestorEventos().cambiarDirectorio()
        );

        addBoton(
                new ImageIcon(pathIconos + "exit.jpg"),
                e -> System.exit(0)
        );

        return iconosMenu;
    }

    private void addBoton(ImageIcon imagen, ActionListener e) {
        JButton boton = new JButton();
        boton.setIcon(imagen);
        boton.setFocusPainted(false);
        boton.addActionListener(e);
        iconosMenu.add(boton);
    }

    public void cambiarAPartida(Imagen img) {
        imagenPartida = img;
        jsp.setRightComponent(new PanelPartida(imagenPartida));
        jsp.setDividerLocation(180);
    }
    public void cambiarASolucion(boolean esSol) {
        jsp.setRightComponent(new PanelSolucion(imagenPartida, esSol));
        jsp.setDividerLocation(180);
    }

    public void cambiarAClasificacion(int mode) {
        String nombreBuscado = "";
        if (mode == PanelClasificacion.HISTORIAL_SELECTIVO){
            nombreBuscado = JOptionPane.showInputDialog(
                    null,
                    "INTRODUCE EL NOMBRE DEL JUGADOR BUSCADO"
            );
        }
        if (nombreBuscado != null){
            jsp.setRightComponent(new PanelClasificacion(mode, nombreBuscado));
            jsp.setDividerLocation(180);
        } else {
            PanelContenidos.getInstance().cambiarAInicio();
        }
    }

    public void cambiarAInicio() {
        jsp.setRightComponent(new PanelStandBy());
        jsp.setDividerLocation(180);
    }
}
