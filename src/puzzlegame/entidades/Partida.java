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
 * Clase encargada de iniciar una nueva partida.
 */
public class Partida {
    //Se crea una instancia estática para podernos referir a partida desde cualquier parte del programa.
    public static Partida partida;
    public static boolean enPartida = false;
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
        //Nos permite coger la fecha y la hora en la que se inició una partida y darle un formato.
        DateFormat formater = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        fecha = formater.format(new Date());
    }

    public static void iniPartida() {
        partida = new Partida();
    }

    /**
     * Crea una ventana emergente que pide al usuario que introduzca su nombre y las divisiones horizontales y verticales
     * que desea para su puzzle.
     */
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
                //Libera los recursos dde la ventana.
                askingFrame.dispose();
                enPartida = true;
                Imagen puzzlePartida = new Imagen(divisionesHorizontales, divisionesVerticales); //crear imagen
                PanelContenidos.getInstance().cambiarAPartida(puzzlePartida); //mostrar juego puzzle
            }
        });
        button.add(b);
        askingFrame.add(button, BorderLayout.SOUTH);
    }

    /**
     * Comprueba que el input del usuario cumpla los requisitos pedidos para el correcto funcionamiento del programa.
     * @return boolean que indica si el input es válido o no.
     */
    private boolean guardarInputJugador() {
        String mensaje = "HAY ERRORES EN LOS DATOS INTRODUCIDOS. POR FAVOR, CORRIGELOS.\n" +
                        "\nRECUERDA QUE EL NOMBRE NO SE PUEDE DEJAR EN BLANCO Y QUE LAS " +
                        "\nSUBDIVISIONES TIENEN QUE SER NÚMEROS ENTEROS MAYORES QUE 1";
        //Boolean que indican si cada uno de los parámetros a introducir está bien introducido.
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
            //Ignoramos la excepción, ya que por defecto los boolean que indican si los parámetros son correctos son true.
        }

        if(!bname || !bHDivs || !bVDivs) {
            JOptionPane.showMessageDialog(null,mensaje);
        } else {
            return true;
        }
        return false;
    }

    /**
     * Guarda en el fichero el registro de la partida.
     * @param haGanado indica si el jugador ha ganado o no.
     */
    public void guardarPartida(boolean haGanado) {
        partidaGanada = haGanado;
        new FicheroPartidaOut().escribirPartida(this);
        enPartida = false;
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
