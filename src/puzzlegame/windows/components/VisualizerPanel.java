package puzzlegame.windows.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisualizerPanel extends JPanel {


    public VisualizerPanel() {
        setLayout(new BorderLayout());
        //setBackground(Color.BLUE);
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
