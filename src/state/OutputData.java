package src.state;

public class OutputData {
    private static String commandInput = "Default value";
    private static String calculatedOutput = "Default value";

    public static String getCommandInput(){
        return commandInput;
    }

    public static void setCommandInput(String str){
        if(str != null) {
            commandInput = str;
        }
    }

    public static String getCalculatedOutput(){
        return calculatedOutput;
    }

    public static void setCalculatedOutput(String str){
        if(str != null){
            calculatedOutput = str;
        }
    }


}
