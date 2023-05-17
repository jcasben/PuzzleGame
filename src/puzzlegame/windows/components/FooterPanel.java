package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    private JSplitPane jsp;
    public FooterPanel(JSplitPane jsp) {
        this.jsp = jsp;
        setVisible(true);
        footerButton();
        setLayout(new GridLayout(1,1));
    }

    private void footerButton() {
        JButton bcontinue = new JButton("CONTINUAR");
        this.add(bcontinue);
        bcontinue.addActionListener(e -> jsp.setRightComponent(new StandByPanel()));
    }
}
