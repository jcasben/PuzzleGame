package puzzlegame.window.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisualizationPanel extends JPanel {
    private ImageIcon bacgroundUIB = new ImageIcon("resources/backgroundUIB.jpg");
    public VisualizationPanel() {
        repaint();
        setVisible(true);
    }
}
