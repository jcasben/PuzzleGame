package puzzlegame.gestores;

import puzzlegame.entidades.SubImagen;
import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Marc Link
 * @author jcasben
 * Gestiona los eventos de ratón.
 */
public class GestorRaton extends MouseAdapter {
    private final SubImagen [] piezas;
    private JLabel primerClick;

    /**
     * Guarda las diferentes subimagenes para tratarlas.
     * @param piezas conjunto de subimagenes del puzzle.
     */
    public GestorRaton (SubImagen [] piezas) {
        this.piezas = piezas;
    }

    /**
     * Gestor del evento de ratón. Cambia las imágenes de posición.
     * @param e evento que hay que procesar.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (primerClick == null) {
            primerClick = ((JLabel) e.getComponent());
            primerClick.setBorder(BorderFactory.createLineBorder(Color.RED,3));
            return;
        }

        SubImagen aux;
        JLabel segundoClcik = ((JLabel) e.getComponent());
        int posprimer = (Integer.parseInt(primerClick.getName()));
        int possegund = (Integer.parseInt(segundoClcik.getName()));
        System.out.println(posprimer + "primer");
        System.out.println(possegund + "segundo");

        aux = piezas[posprimer];
        piezas[posprimer] = piezas[possegund];
        piezas[possegund] = aux;

        Icon aux1 = primerClick.getIcon();
        primerClick.setIcon(segundoClcik.getIcon());
        segundoClcik.setIcon(aux1);

        if(esCorrecto()){
            PanelContenidos.getInstance().cambiarASolucion(true);
        }

        primerClick.setBorder(BorderFactory.createEmptyBorder());
        primerClick = null;
    }

    /**
     * Comprueba si el puzzle está bien hecho.
     * @return true si está bien hecho, false si sigue desordenado.
     */
    private boolean esCorrecto() {
        boolean esCorrecto = true;

        for (int i = 0; i < piezas.length; i++) {
            if(piezas[i].getPos() != i){
                esCorrecto = false;
                break;
            }
        }
        return esCorrecto;
    }
}
