package puzzlegame.ventana.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author jcasben
 * @author Marc Link
 * Panel que representa el panel de StandBy del programa.
 */
public class PanelStandBy extends JPanel {
    /**
     * Crea un panel y le añade un {@link JLabel} que contiene la imagen de fondo la UIB.
     */
    public PanelStandBy() {
        setLayout(new BorderLayout());
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("resources/assets/backgroundUIB.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);

        setVisible(true);
    }
}
