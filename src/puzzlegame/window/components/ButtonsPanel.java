package puzzlegame.window.components;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    public ButtonsPanel() {
        setLayout(new GridLayout(5,1));
        JButton b1 = new JButton("b1");
        b1.addActionListener(e -> System.out.println("b1"));
        add(b1);

        JButton b2 = new JButton("b2");
        b2.addActionListener(e -> System.out.println("b2"));
        add(b2);

        JButton b3 = new JButton("b3");
        b3.addActionListener(e -> System.out.println("b3"));
        add(b3);

        JButton b4 = new JButton("b4");
        b4.addActionListener(e -> System.out.println("b4"));
        add(b4);

        JButton b5 = new JButton("b5");
        b5.addActionListener(e -> System.out.println("b5"));
        add(b5);
    }
}
