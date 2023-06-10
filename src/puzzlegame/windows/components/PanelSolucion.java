package puzzlegame.windows.components;

import puzzlegame.entidades.Imagen;

import javax.swing.*;
import java.awt.*;

public class PanelSolucion extends JPanel {
    public PanelSolucion(Imagen solucion, boolean esSol){
        if(esSol){
            JOptionPane.showMessageDialog(null,"HAS GANADO");
        } else {
            JOptionPane.showMessageDialog(null,"SE TE HA ACABADO EL TIEMPO");
        }
        setLayout(new BorderLayout());
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.add(new JLabel(new ImageIcon(solucion.getImg()))), new FooterPanel());
        jsp2.setEnabled(false);
        jsp2.setDividerLocation(675);
        add(jsp2);
        setVisible(true);
    }
}
