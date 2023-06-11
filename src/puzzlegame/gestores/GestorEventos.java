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
 */
public class GestorEventos {
    public ActionListener nuevaPartida() {
        return e -> {
            if (Partida.partida != null) {
                JOptionPane.showMessageDialog(null,"DEBES ACABAR LA PARTIDA PRIMERO");
                return;
            }
            Partida.iniPartida();
        };
    }

    public ActionListener clasificacion(int mode) {
        return e -> {
            if(Partida.partida != null) return;
            PanelContenidos.getInstance().cambiarAClasificacion(mode);
        };
    }

    public ActionListener cambiarDirectorio() {
        return e -> {
            if (Partida.partida != null) return;

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle("Directorio de las imágenes");
            fileChooser.setCurrentDirectory(new File(Imagen.path));

            int result = fileChooser.showOpenDialog(null);

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    JOptionPane.showMessageDialog(null,
                            "Error, no se ha podido cambiar el directorio");
                } else {
                    Imagen.path = fileName.getPath();
                    JOptionPane.showMessageDialog(null,
                            "Directorio cambiado con éxito");
                }
            }
        };
    }
}
