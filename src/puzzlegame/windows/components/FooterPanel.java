package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        setVisible(true);
        setLayout(new GridLayout(1,1));
    }

    private void footerButton() {
        JButton bcontinue = new JButton("CONTINUAR");
        //bcontinue.addActionListener(e -> new MainPanel());
    }
}
