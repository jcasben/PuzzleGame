package puzzlegame;

import puzzlegame.windows.components.Imagen;
import puzzlegame.windows.components.PanelContenidos;
import puzzlegame.windows.components.SubImagen;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Partida {
    private JTextField name = new JTextField();
    private final JTextField horizontalDivs = new JTextField();
    private final JTextField verticalDivs = new JTextField();
    private int playerHDivs;
    private int playerVDivs;
    private SubImagen[] subImagenes;
    private String nombreUsuario;
    private String fecha;
    private boolean partidaGanada = false;

    public Partida() {
        newGameWindow();
        DateFormat formater = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        fecha = formater.format(new Date());
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
                Imagen puzzlePartida = new Imagen(playerHDivs,playerVDivs); //crear imagen
                subImagenes = puzzlePartida.getDivisiones();
                PanelContenidos.getInstance().cambiarAPartida(puzzlePartida); //mostrar imagen
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
            nombreUsuario = name.getText();
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
            System.out.println(nombreUsuario + "\n" + playerHDivs + "\n" + playerVDivs);
            return true;
        }
        return false;
    }

    public int getPuntuacion() {
        return partidaGanada ? (playerHDivs * playerVDivs) : 0;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombreUsuario;
    }
}
