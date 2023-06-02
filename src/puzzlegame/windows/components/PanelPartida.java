package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class PanelPartida extends JPanel {
    public PanelPartida() {
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JPanel(), new FooterPanel());
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }
}
