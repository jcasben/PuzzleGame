package puzzlegame;

import puzzlegame.ventana.Ventana;

import java.awt.*;

/**
 * @author Marc Link
 * @author jcasben
 */
public class Main {
    public static void main(String[] args) {
        //Espera a que los recursos estén listos para llamar a la ventana.
        EventQueue.invokeLater(Ventana::new);
    }
}
