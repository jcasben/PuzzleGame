package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        setVisible(true);
        footerButton();
        setLayout(new GridLayout(1,1));
    }

    private void footerButton() {
        JButton bcontinue = new JButton("CONTINUAR");
        this.add(bcontinue);
        bcontinue.addActionListener(e -> PanelContenidos.getInstance().cambiarAInicio());
    }
}
