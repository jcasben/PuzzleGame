package puzzlegame.windows.components;

import puzzlegame.Game;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class ButtonPanel extends JPanel {


    public ButtonPanel(JSplitPane jsp) {
        setLayout(new GridLayout(4,1));

        JButton b1 = new JButton("NUEVA PARTIDA");
        b1.addActionListener(e -> new Game(jsp));
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        add(b1);

        JButton b2 = new JButton("HISTORIAL GENERAL");
        b2.addActionListener(e -> jsp.setRightComponent(new HistorialPanel()));
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        add(b2);

        JButton b3 = new JButton("HISTORIAL");
        b3.addActionListener(e -> System.out.println("b3"));
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.setFocusPainted(false);
        add(b3);

        JButton b4 = new JButton("SALIR");
        b4.addActionListener(e -> System.out.println("b4"));
        b4.setBackground(Color.DARK_GRAY);
        b4.setForeground(Color.WHITE);
        b4.setFocusPainted(false);
        b4.addActionListener(e -> System.exit(0));
        add(b4);

        setVisible(true);
    }
}
