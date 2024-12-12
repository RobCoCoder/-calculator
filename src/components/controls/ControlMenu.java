package src.components.controls;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlMenu extends JPanel {
    private final int MARGIN_BOTTOM = 20, MARGIN_HORIZONTAL = 10;
    private int width = 10;
    private int height = 10;

    public ControlMenu(int width, int height){
        super();
        if(width >= 0 && height >= 0){
            this.width = width - 2 * MARGIN_HORIZONTAL;
            this.height = height - MARGIN_BOTTOM;
        }

        setSize(this.width, this.height);
        setBorder(BorderFactory.createEmptyBorder(0, 0, MARGIN_BOTTOM, 0));
        setBackground(Color.RED);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
