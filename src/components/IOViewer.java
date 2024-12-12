package src.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import src.state.OutputData;

// calculator input/output screen class
public class IOViewer extends JPanel {
    private final int MARGIN_TOP = 10, MARGIN_HORIZONTAL = 10;

    // dimensions of the panel
    private int width = 10;
    private int height = 10;

    public IOViewer(int width, int height) {
        if(width >= 0 && height >= 0) {
            this.width = width - 2 * MARGIN_HORIZONTAL;
            this.height = height;
        }

        setSize(this.width, this.height);
        setBorder(BorderFactory.createEmptyBorder(0, 0, MARGIN_TOP, 0));

        // styling panel
        setBackground(new Color(2, 2, 2));
        setLayout(new GridLayout(2, 1));

        // adds output line component
        TextField outputField = new TextField(this.width, this.height / 2, OutputData.getCalculatedOutput());
        add(outputField);

        // adds input line component
        TextField inputField = new TextField(this.width, this.height / 2, OutputData.getCommandInput());
        add(inputField);
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