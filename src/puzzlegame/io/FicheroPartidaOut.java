package puzzlegame.io;

import puzzlegame.entidades.Partida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author jcasben
 * @author Marc Link
 */
public class FicheroPartidaOut {
    private RandomAccessFile raf;
    private final int MAXLONGNOMBRE = 15;

    /**
     * Inicia la instancia del RandomAccessFile en modo lectura/escritura.
     */
    public FicheroPartidaOut() {
        try {
            raf = new RandomAccessFile(new File("resources/resultados.dat"),"rw");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Escribe los datos de la partida.
     * @param partida partida de la que hay que escribir los datos.
     */
    public void escribirPartida(Partida partida) {
        try {
            String nombre = partida.getNombre();

            if (raf.length() != 0) {
                raf.seek(raf.length());
            }

            if (nombre.length() < MAXLONGNOMBRE) {
                int maxLength = MAXLONGNOMBRE - nombre.length();
                for (int i = 0; i < maxLength; i++) {
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
