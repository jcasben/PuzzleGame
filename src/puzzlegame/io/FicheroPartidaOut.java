package puzzlegame.io;

import puzzlegame.Partida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jcasben
 */
public class FicheroPartidaOut {
    private RandomAccessFile raf;
    private final int MAXLONGNOMBRE = 15;

    public FicheroPartidaOut() {
        try {
            raf = new RandomAccessFile(new File("resources/partidas.dat"),"rw");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void escribirPartida(Partida partida) {
        try {
            String nombre = partida.getNombre();

            if (raf.length() != 0) {
                raf.seek(raf.length());
            }

            if (nombre.length() < MAXLONGNOMBRE) {
                for (int i = 0; i < MAXLONGNOMBRE - nombre.length(); i++) {
                    nombre += " ";
                }
            } else {
                nombre = nombre.substring(0,MAXLONGNOMBRE - 1);
            }

            raf.writeChars(nombre);
            raf.writeChars(partida.getFecha());
            raf.writeInt(partida.getPuntuacion());
            raf.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
