package src.components.controls;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ControlMenu extends JPanel {
    private final int MARGIN_BOTTOM = 20, MARGIN_HORIZONTAL = 10;
    private int width = 10;
    private int height = 10;
    private GridBagConstraints gbc = new GridBagConstraints();

    public ControlMenu(int width, int height) {
        super();

        if (width >= 0 && height >= 0) {
            this.width = width - 2 * MARGIN_HORIZONTAL;
            this.height = height - MARGIN_BOTTOM;
        }

        setSize(this.width, this.height);
        setLayout(new GridBagLayout());
        gbc.weightx = this.width - 2 * MARGIN_HORIZONTAL;
        gbc.weighty = this.height - 21 * MARGIN_BOTTOM;

        // decorations
        setBorder(BorderFactory.createEmptyBorder(0, 0, MARGIN_BOTTOM, 0));
        setBackground(Color.WHITE);

        // buttons: row 1
        var button1 = new ControlButton("AC");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button1, gbc);

        var button2 = new ControlButton("+/-");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button2, gbc);

        var button3 = new ControlButton("%");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button3, gbc);

        var button4 = new ControlButton("÷");
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button4, gbc);

        // buttons: row 2
        var button5 = new ControlButton("7");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button5, gbc);

        var button6 = new ControlButton("8");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button6, gbc);

        var button7 = new ControlButton("9");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button7, gbc);

        var button8 = new ControlButton("x");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button8, gbc);

        // buttons: row 3
        var button9 = new ControlButton("4");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button9, gbc);

        var button10= new ControlButton("5");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button10, gbc);

        var button11 = new ControlButton("6");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button11, gbc);

        var button12 = new ControlButton("-");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button12, gbc);

        // row 4
        var button13 = new ControlButton("1");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button13, gbc);

        var button14 = new ControlButton("2");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button14, gbc);

        var button15 = new ControlButton("3");
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button15, gbc);

        var button16 = new ControlButton("+");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button16, gbc);

        // row 5
        var button17 = new ControlButton("0");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(button17, gbc);

        var button18 = new ControlButton(".");
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button18, gbc);

        var button19 = new ControlButton("=");
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(button19, gbc);
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
