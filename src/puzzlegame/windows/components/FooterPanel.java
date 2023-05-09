package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        setVisible(true);
        setLayout(new GridLayout(1,1));
        //initProgressBar();
        add(new JButton("CONTINUAR"));
    }

    private void initProgressBar() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setSize(new Dimension(400,30));
        progressBar.setValue(0);
        int i = 0;
        while(i<100) {
            progressBar.setValue(i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        add(progressBar);
    }

    private void footerButton() {

    }
}
