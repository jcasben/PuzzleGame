package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class InGamePanel extends JPanel {
    public InGamePanel() {
        setVisible(true);
        setLayout(new BorderLayout());
        JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JPanel(), new FooterPanel());
        jsp.setEnabled(false);
        jsp.setDividerLocation(675);
        add(jsp);
    }
}
