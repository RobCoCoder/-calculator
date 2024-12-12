package src.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextField extends JComponent {
    private final int MARGIN_TOP = 10, MARGIN_HORIZONTAL = 10;

    private int width = 10;
    private int height = 10;
    private String textToView = "";

    public TextField(int width, int height, String textToView){
        if(width >= 0 && height >= 0){
            this.width = width;
            this.height = height;
            if(textToView != null){
                this.textToView = textToView;
            }
        }

        setLayout(new GridLayout());
        setBorder(new EmptyBorder(MARGIN_TOP, MARGIN_HORIZONTAL, 0, MARGIN_HORIZONTAL));


        // adding output label
        JLabel outputLabel = new JLabel("<html><font color = 'white'>" + textToView + "</font></html>", JLabel.RIGHT);
        outputLabel.setBackground(Color.WHITE);
        outputLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        outputLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        add(outputLabel);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setSize(this.width, this.height);

        setBackground(new Color(0, 0, 0, 0));
        g.fillRoundRect(0, 0, this.width, this.height, 10, 10);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));

//        g.setColor(Color.WHITE);
//        g.drawString(OutputData.getCalculatedOutput(), this.width - (int) (1.2 * getFontMetrics(g.getFont()).stringWidth(OutputData.getCalculatedOutput())), (this.height - getFontMetrics(g.getFont()).getHeight()) / 2);


    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
