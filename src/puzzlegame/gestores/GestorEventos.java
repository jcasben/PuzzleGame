package puzzlegame.gestores;

import puzzlegame.entidades.Imagen;
import puzzlegame.entidades.Partida;
import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author jcasben
 * @author Marc Link
 * Clase encargada de gestionar los eventos del menu.
 */
public class GestorEventos {
    /**
     * Gestiona el evento de crear una nueva partida.
     * @return ActionListener que controla este evento.
     */
    public ActionListener nuevaPartida() {
        return e -> {
            if (Partida.enPartida) {
                JOptionPane.showMessageDialog(null,"DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            Partida.iniPartida();
        };
    }

    /**
     * Gestiona el evento de entrar a la clasificación.
     * @param mode modo de CLASIFICACIÓN o HISTORIAL SELECTIVO.
     * @return ActionListener que controla este evento.
     */
    public ActionListener clasificacion(int mode) {
        return e -> {
            if(Partida.enPartida) {
                JOptionPane.showMessageDialog(null, "DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            PanelContenidos.getInstance().cambiarAHistorial(mode);
        };
    }

    /**
     * Gestiona el evento de cambiar el directorio.
     * @return ActionListener que controla este evento.
     */
    public ActionListener cambiarDirectorio() {
        return e -> {
            if (Partida.enPartida){
                JOptionPane.showMessageDialog(null, "DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }

            JFileChooser selectorDirectorios = new JFileChooser();
            selectorDirectorios.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            selectorDirectorios.setDialogTitle("SELECCIONA EL DIRECTORIO DESEADO");
            selectorDirectorios.setCurrentDirectory(new File(Imagen.path));

            int resultado = selectorDirectorios.showOpenDialog(null);

            if (resultado != JFileChooser.CANCEL_OPTION) {
                File fileName = selectorDirectorios.getSelectedFile();
                if ((fileName == null) || (fileName.getName().equals(""))) {
                    JOptionPane.showMessageDialog(null,
                            "NO SE HA PODIDO CAMBIAR EL DIRECTORIO.\n" +
                                    "INTÉNTALO DE NUEVO.");
                } else {
                    Imagen.path = fileName.getPath();
                    JOptionPane.showMessageDialog(null,
                            "EL DIRECTORIO SE HA CAMBIADO CORRECTAMENTE.");
                }
            }
        };
    }
}
