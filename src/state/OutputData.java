package src.state;

import java.awt.*;
import java.util.ArrayList;

public class OutputData {
    private static ArrayList<Component> subscribers = new ArrayList<Component>();

    private static String commandInput = "0";
    private static String calculatedOutput = "";

    public static String getCommandInput(){
        return commandInput;
    }

    public static void setCommandInput(String str){
        if(str != null) {
            commandInput = str;
            repaintSubscribers();
        }
    }

    public static String getCalculatedOutput(){
        return calculatedOutput;
    }

    public static void setCalculatedOutput(String str) {
        if (str != null) {
            calculatedOutput = str;
            repaintSubscribers();
        }
    }

    public static void addSubscriber(Component c){
        subscribers.add(c);
    }

    private static void repaintSubscribers(){
        for(Component subscriber : subscribers){
            subscriber.repaint();
        }
    }
}
