package puzzlegame.windows.components;

import puzzlegame.Partida;
import puzzlegame.entidades.Imagen;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class PanelContenidos extends JPanel {
    private JToolBar iconosMenu;
    private JSplitPane jsp;
    private Imagen imagenPartida;

    private static final PanelContenidos panelContenidos = new PanelContenidos();

    public PanelContenidos() {
        setLayout(new BorderLayout());
        this.jsp = jsp;

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
        JButton nuevaPartidaIcono = new JButton();
        nuevaPartidaIcono.setIcon(new ImageIcon("resources/assets/icons/newGame.jpg"));
        nuevaPartidaIcono.addActionListener(e -> {
            if (Partida.partida != null) {
                JOptionPane.showMessageDialog(null,"DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            Partida.iniPartida();
        });
        nuevaPartidaIcono.setFocusPainted(false);
        iconosMenu.add(nuevaPartidaIcono);

        JButton clasificacionIcono = new JButton();
        clasificacionIcono.setIcon(new ImageIcon("resources/assets/icons/generalHist.jpg"));
        clasificacionIcono.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.CLASIFICACION));
        clasificacionIcono.setFocusPainted(false);
        iconosMenu.add(clasificacionIcono);

        JButton historialIcono = new JButton();
        historialIcono.setIcon(new ImageIcon("resources/assets/icons/selectiveHist.jpg"));
        historialIcono.addActionListener(e -> PanelContenidos.getInstance().cambiarAClasificacion(PanelClasificacion.HISTORIAL_SELECTIVO));
        historialIcono.setFocusPainted(false);
        iconosMenu.add(historialIcono);

        JButton cambiarDirectorioIcono = new JButton();
        cambiarDirectorioIcono.setIcon(new ImageIcon("resources/assets/icons/changeDir.jpg"));
        cambiarDirectorioIcono.setFocusPainted(false);
        iconosMenu.add(cambiarDirectorioIcono);

        JButton salirIcono = new JButton();
        salirIcono.setIcon(new ImageIcon("resources/assets/icons/exit.jpg"));
        salirIcono.setFocusPainted(false);
        salirIcono.addActionListener(e -> System.exit(0));
        iconosMenu.add(salirIcono);

        return iconosMenu;
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
