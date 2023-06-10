package puzzlegame.io;

import puzzlegame.Partida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FicheroPartidaIn {
    private RandomAccessFile raf;
    private final int MAXLONGSTRING = 15;

    public FicheroPartidaIn() {
        try {
            raf = new RandomAccessFile(new File("resources/partidas.dat"),"r");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public String leerPartidas() {
        final int LONGREG = 2 * (2 * MAXLONGSTRING) + 4 * 1;
        String s = "";
        try {
            long numReg = raf.length() / LONGREG;
            for(int r = 0; r < numReg; r++) {
                String nombre = "";
                String fecha = "";
                int puntuacion;
                for(int i = 0; i < MAXLONGSTRING; i++) {
                    nombre += raf.readChar();
                }

                for(int i = 0; i < MAXLONGSTRING; i++) {
                    fecha += raf.readChar();
                }

                puntuacion = raf.readInt();

                s += "NOMBRE: " + nombre + " - FECHA: " + fecha + " - PUNTOS: " + puntuacion + "\n";
            }
            raf.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return s;
    }

    public String leerSelectivo(String nombreBuscado) {
        String s = "";
        final int LONGREG = 2 * (2 * MAXLONGSTRING) + 4 * 1;

        if (nombreBuscado.length() < MAXLONGSTRING) {
            for (int i = 0; i < MAXLONGSTRING - nombreBuscado.length(); i++) {
                nombreBuscado += " ";
            }
        } else {
            nombreBuscado = nombreBuscado.substring(0,MAXLONGSTRING - 1);
        }

        try {
            long numReg = raf.length() / LONGREG;
            for(int r = 0; r < numReg; r++) {
                String nombre = "";
                String fecha = "";
                int puntuacion;
                for(int i = 0; i < MAXLONGSTRING; i++) {
                    nombre += raf.readChar();
                }

                for(int i = 0; i < MAXLONGSTRING; i++) {
                    fecha += raf.readChar();
                }

                puntuacion = raf.readInt();

                if(nombre.equals(nombreBuscado)) {
                    s += "NOMBRE: " + nombre + " - FECHA: " + fecha + " - PUNTOS: " + puntuacion + "\n";
                }
            }
            raf.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return s;
    }
}
