package puzzlegame.ventana.components.relacionado_juego;

import puzzlegame.entidades.Partida;
import puzzlegame.entidades.Imagen;
import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marc Link
 * @author jcasben
 * Panel donde se mostrará la solución al puzzle.
 */
public class PanelSolucion extends JPanel {
    /**
     * Al ser llamado, dependiendo de si se ha ganado o se ha perdido, se mostrará un mensaje.
     * @param solucion puzzle resuelto.
     * @param acertado boolean que indica si ha ganado o ha perdido.
     */
    public PanelSolucion(Imagen solucion, boolean acertado){
        //Cuando llega a este punto puede llegar por varios motivos:
        //  - Ha acertado (acertado = true)
        //  - Se le ha acabado el tiempo (acertado = false)
        PanelTemporizador.panTemp.pararTemp();
        if(acertado){
            JOptionPane.showMessageDialog(null,"HAS GANADO");
        } else {
            JOptionPane.showMessageDialog(null,"SE TE HA ACABADO EL TIEMPO");
        }

        //Se guarda el contenido de la partida después de haber acabado la partida.
        Partida.partida.guardarPartida(acertado);

        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                this.add(new JLabel(new ImageIcon(solucion.getImg()))),
                botonContiunar()
        );
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }

    /**
     * Contenedor en el que está el botón que conduce al inicio después de acabar la partida.
     * @return devuelve el panel con el botón.
     */
    private JPanel botonContiunar() {
        JPanel panelContinuar = new JPanel();
        JButton botonContinuar = new JButton("CONTINUAR");

        botonContinuar.setBackground(Color.DARK_GRAY);
        botonContinuar.setForeground(Color.WHITE);
        botonContinuar.addActionListener(e -> PanelContenidos.getInstance().cambiarAInicio());

        panelContinuar.setLayout(new BorderLayout());
        panelContinuar.add(botonContinuar);
        panelContinuar.setVisible(true);

        return panelContinuar;
    }
}
