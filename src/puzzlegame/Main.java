package puzzlegame;

import puzzlegame.windows.GameWindow;

import java.awt.*;

public class Main {
    public static GameWindow window;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> window = new GameWindow());
    }
}
