package puzzlegame.windows.components;

import javax.swing.*;
import java.awt.*;

/**
 * @author jcasb
 */
public class MainPanel extends JPanel {
    private JToolBar toolBar;

    public MainPanel() {
        setLayout(new BorderLayout());

        //JSplitPanes
        JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new VisualizerPanel(),new FooterPanel());
        jsp.setDividerLocation(675);
        jsp.setEnabled(false);

        JSplitPane jsp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new ButtonPanel(),jsp);
        jsp2.setEnabled(false);

        JSplitPane jsp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,initToolBar(),jsp2);
        jsp3.setEnabled(false);

        add(jsp3);
        setVisible(true);
    }

    /**
     * Crea e inicializa una barra de herramientas que contiene los botones requeridos para realizar las opciones que
     * debe incluir el menu.
     * @return objeto de la clase {@link JToolBar}
     */
    private JToolBar initToolBar() {
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        // ---------------------------------------- Creación de los botones ----------------------------------------
        JButton tbNewGame = new JButton();
        tbNewGame.setIcon(new ImageIcon("resources/assets/icons/newGame.jpg"));
        toolBar.add(tbNewGame);

        JButton tbHistory = new JButton();
        tbHistory.setIcon(new ImageIcon("resources/assets/icons/generalHist.jpg"));
        toolBar.add(tbHistory);

        JButton tbSelHistory = new JButton();
        tbSelHistory.setIcon(new ImageIcon("resources/assets/icons/selectiveHist.jpg"));
        toolBar.add(tbSelHistory);

        JButton tbChangeDir = new JButton();
        tbChangeDir.setIcon(new ImageIcon("resources/assets/icons/changeDir.jpg"));
        toolBar.add(tbChangeDir);

        JButton tbExit = new JButton();
        tbExit.setIcon(new ImageIcon("resources/assets/icons/exit.jpg"));
        tbExit.addActionListener(e -> System.exit(0));
        toolBar.add(tbExit);

        return toolBar;
    }
}
