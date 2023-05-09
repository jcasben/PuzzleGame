package puzzlegame;

import puzzlegame.windows.GameWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameWindow());
    }
}
