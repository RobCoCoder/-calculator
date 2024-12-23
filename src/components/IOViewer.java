package src.components;

import javax.swing.*;
import java.awt.*;

import src.state.OutputData;

// calculator input/output screen class
public class IOViewer extends JPanel {
    private final int MARGIN_TOP = 10, MARGIN_HORIZONTAL = 10;

    // dimensions of the panel
    private int width = 10;
    private int height = 10;

    // components
    private JTextField outputField;
    private JTextField inputField;


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
        outputField = new JTextField();
        outputField.setText(OutputData.getCalculatedOutput());
        outputField.setSize(this.width, this.height / 2);
        outputField.setHorizontalAlignment(SwingConstants.RIGHT);
        outputField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        outputField.setEnabled(false);
        OutputData.addSubscriber(outputField);
        add(outputField);

        // adds input line component
        inputField = new JTextField();
        inputField.setText(OutputData.getCommandInput());
        inputField.setSize(this.width, this.height / 2);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        inputField.setEnabled(false);
        OutputData.addSubscriber(inputField);
        add(inputField);
    }

    @Override
    public void repaint() {
        if(outputField != null){
            outputField.setText(OutputData.getCalculatedOutput());
            outputField.repaint();
        }
        if(inputField != null){
            inputField.setText(OutputData.getCommandInput());
            inputField.repaint();
        }
        super.repaint();
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