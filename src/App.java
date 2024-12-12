package src;

import src.components.IOViewer;
import src.components.TextField;
import src.components.controls.ControlMenu;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){

        // sets up the frame
        EventQueue.invokeLater(() -> {
            var frame = new AppFrame(); // main app frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit when closing window
            frame.setVisible(true);
            frame.setResizable(false);
        });
    }
}

class AppFrame extends JFrame {
    static int frameWidth;
    static int frameHeight;
    Toolkit kit = Toolkit.getDefaultToolkit();

    public AppFrame(){
        // sets up frame size depending on screen dimensions
        Dimension screenSize = kit.getScreenSize();
        frameWidth = (int) (screenSize.width / 4.0);
        frameHeight = (int) (screenSize.height / 1.5);

        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null); // center the frame

        // styling frame
        getContentPane().setBackground(new Color(44, 43, 43));
        setLayout(new FlowLayout());

        //panels
        add(new IOViewer(frameWidth, frameHeight * 20 / 100)); // adds the calculator input/output screen
        add(new ControlMenu(frameWidth, frameHeight * 80 / 100));

    }
}

