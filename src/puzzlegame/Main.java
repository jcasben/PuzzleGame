package puzzlegame;

import puzzlegame.windows.Ventana;

import java.awt.*;

public class Main {
    public static Ventana window;
    public static void main(String[] args) {EventQueue.invokeLater(() -> window = new Ventana());
    }
}
