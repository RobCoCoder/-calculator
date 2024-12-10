package src;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            var frame = new AppFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class AppFrame extends JFrame {
    static int frameWidth;
    static int frameHeight;
    Toolkit kit = Toolkit.getDefaultToolkit();

    public AppFrame(){
        Dimension screenSize = kit.getScreenSize();
        frameWidth = (int) (screenSize.width / 2.2);
        frameHeight = (int) (screenSize.height / 1.1);

        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
    }
}

