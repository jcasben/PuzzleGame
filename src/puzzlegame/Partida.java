package puzzlegame;

import puzzlegame.windows.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;

public class Partida {
    private JTextField name = new JTextField();
    private String playerName;
    private JTextField horizontalDivs = new JTextField();
    private int playerHDivs;
    private JTextField verticalDivs = new JTextField();
    private int playerVDivs;

    public Partida() {
        newGameWindow();
    }

    private void newGameWindow() {
        JFrame askingFrame = new JFrame("INTRODUCCIÓN DATOS");
        askingFrame.setBounds(300,350,700,150);
        askingFrame.setLayout(new BorderLayout());
        askingFrame.setResizable(false);
        askingFrame.setLocationRelativeTo(null);
        askingFrame.setVisible(true);

        JPanel textFields = new JPanel();
        textFields.setLayout(new GridLayout(3,2));
        textFields.add(new JLabel("NOMBRE DEL JUGADOR"));
        textFields.add(name);
        textFields.add(new JLabel("NÚMERO DE SUBDIVISIONES HORIZONTALES"));
        textFields.add(horizontalDivs);
        textFields.add(new JLabel("NÚMERO DE SUBDIVISIONES VERTICALES"));
        textFields.add(verticalDivs);
        askingFrame.add(textFields, BorderLayout.CENTER);

        JPanel button = new JPanel();
        button.setSize(new Dimension(700,38));
        button.setLayout(new GridLayout(1,1));
        JButton b = new JButton("CONFIRMAR");
        b.addActionListener(e -> {
            if(savePlayerInput()) {
                askingFrame.dispose();
                PanelContenidos.getInstance().cambiarAPartida(playerHDivs, playerVDivs);
            }
        });
        button.add(b);
        askingFrame.add(button, BorderLayout.SOUTH);
    }

    private boolean savePlayerInput() {
        String message = "HAY ERRORES EN LOS DATOS INTRODUCIDOS. POR FAVOR, CORRIGELOS.\n\n RECUERDA QUE EL " +
                "NOMBRE NO SE PUEDE DEJAR EN BLANCO Y QUE LAS \nSUBDIVISIONES TIENEN QUE SER NÚMEROS ENTEROS";
        boolean bname, bHDivs, bVDivs;
        bname = bHDivs = bVDivs = false;

        if(!name.getText().equals("")) {
            playerName = name.getText();
            bname = true;
        }

        try {
            playerHDivs = Integer.parseInt(horizontalDivs.getText());
            bHDivs = true;
            playerVDivs = Integer.parseInt(verticalDivs.getText());
            bVDivs = true;
        } catch(NumberFormatException nfe) {
            //ignore
        }

        if(!bname || !bHDivs || !bVDivs) {
            JOptionPane.showMessageDialog(null,message);
        } else {
            System.out.println(playerName + "\n" + playerHDivs + "\n" + playerVDivs);
            return true;
        }
        return false;
    }
}
