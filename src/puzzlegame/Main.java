package puzzlegame;

import puzzlegame.window.GameWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameWindow());
    }
}
