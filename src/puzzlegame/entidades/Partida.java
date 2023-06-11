package puzzlegame.entidades;

import puzzlegame.io.FicheroPartidaOut;
import puzzlegame.ventana.components.PanelContenidos;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jcasben
 * @author Marc Link
 */
public class Partida {
    public static Partida partida;
    private final JTextField name = new JTextField();
    private final JTextField campoDivisionesHorizontales = new JTextField();
    private final JTextField campoDivisionesVerticales = new JTextField();
    private int divisionesHorizontales;
    private int divisionesVerticales;
    private String nombreUsuario;
    private final String fecha;
    private boolean partidaGanada = false;


    public Partida() {
        nuevaVentanaPrepartida();
        DateFormat formater = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        fecha = formater.format(new Date());
    }

    public static void iniPartida() {
        partida = new Partida();
    }

    private void nuevaVentanaPrepartida() {
        JFrame askingFrame = new JFrame("INTRODUCCIÓN DATOS");
        askingFrame.setBounds(300,350,700,150);
        askingFrame.setLayout(new BorderLayout());
        askingFrame.setResizable(false);
        askingFrame.setLocationRelativeTo(null);
        askingFrame.setVisible(true);

        JPanel textFields = new JPanel();
        textFields.setLayout(new GridLayout(3,2));
        textFields.setBackground(Color.DARK_GRAY);
        JLabel nj = new JLabel("NOMBRE DEL JUGADOR");
        nj.setForeground(Color.WHITE);
        textFields.add(nj);
        textFields.add(name);
        JLabel nsh = new JLabel("NÚMERO DE SUBDIVISIONES HORIZONTALES");
        nsh.setForeground(Color.WHITE);
        textFields.add(nsh);
        textFields.add(campoDivisionesHorizontales);
        JLabel nsv = new JLabel("NÚMERO DE SUBDIVISIONES VERTICALES");
        nsv.setForeground(Color.WHITE);
        textFields.add(nsv);
        textFields.add(campoDivisionesVerticales);
        askingFrame.add(textFields, BorderLayout.CENTER);

        JPanel button = new JPanel();
        button.setSize(new Dimension(700,38));
        button.setLayout(new GridLayout(1,1));
        JButton b = new JButton("CONFIRMAR");
        b.addActionListener(e -> {
            if(guardarInputJugador()) {
                askingFrame.dispose();
                Imagen puzzlePartida = new Imagen(divisionesHorizontales, divisionesVerticales); //crear imagen
                PanelContenidos.getInstance().cambiarAPartida(puzzlePartida); //mostrar juego puzzle
            }
        });
        button.add(b);
        askingFrame.add(button, BorderLayout.SOUTH);
    }

    private boolean guardarInputJugador() {
        String message = "HAY ERRORES EN LOS DATOS INTRODUCIDOS. POR FAVOR, CORRIGELOS.\n" +
                        "\nRECUERDA QUE EL NOMBRE NO SE PUEDE DEJAR EN BLANCO Y QUE LAS " +
                        "\nSUBDIVISIONES TIENEN QUE SER NÚMEROS ENTEROS MAYORES QUE 1";
        boolean bname, bHDivs, bVDivs;
        bname = bHDivs = bVDivs = false;

        if(!name.getText().equals("")) {
            nombreUsuario = name.getText();
            bname = true;
        }

        try {
            divisionesHorizontales = Integer.parseInt(campoDivisionesHorizontales.getText());
            if(divisionesHorizontales > 1){
                bHDivs = true;
            }
            divisionesVerticales = Integer.parseInt(campoDivisionesVerticales.getText());
            if(divisionesVerticales > 1){
                bVDivs = true;
            }
        } catch(NumberFormatException nfe) {
            //ignore
        }

        if(!bname || !bHDivs || !bVDivs) {
            JOptionPane.showMessageDialog(null,message);
        } else {
            System.out.println(nombreUsuario + "\n" + divisionesHorizontales + "\n" + divisionesVerticales);
            return true;
        }
        return false;
    }

    public void guardarPartida(boolean haGanado) {
        partidaGanada = haGanado;
        new FicheroPartidaOut().escribirPartida(this);
        partida = null;
    }

    public int getPuntuacion() {
        return partidaGanada ? (divisionesHorizontales * divisionesVerticales) : 0;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombreUsuario;
    }
}
