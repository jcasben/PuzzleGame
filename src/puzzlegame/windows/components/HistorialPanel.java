package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class HistorialPanel extends JPanel {
    public HistorialPanel() {
        setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        jta.setFont(new Font("calibri",1,30));
        jta.setEditable(false);
        JScrollPane sp = new JScrollPane(jta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        setVisible(true);
        add(sp);
    }
}
