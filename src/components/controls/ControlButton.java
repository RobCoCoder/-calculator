package src.components.controls;

import src.state.OutputData;
import src.utilities.ArrayUtils;
import src.utilities.ExpEvaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButton extends JButton {
    private static final ScriptEngineManager sem = new ScriptEngineManager();
    private static final ScriptEngine scriptEngine = sem.getEngineByName("JavaScript");

    public ControlButton(String type) {
        super(type);
        setBackground(new Color(0, 0, 0));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char lastChar = OutputData.getCommandInput().charAt(OutputData.getCommandInput().length()-1);

                switch (type){
                    case "AC":
                        OutputData.setCalculatedOutput("");
                        OutputData.setCommandInput("0");
                        break;
                    case "+/-":
                        // last char entered must be either a digit or .
                        if(Character.isDigit(lastChar) || lastChar == '.'){
                            int lastPlusIndex = OutputData.getCommandInput().lastIndexOf("+");
                            int lastMinusIndex = OutputData.getCommandInput().lastIndexOf("-");
                            int lastMultipIndex = OutputData.getCommandInput().lastIndexOf("x");
                            int lastDivisionIndex = OutputData.getCommandInput().lastIndexOf("÷");
                            int lastModIndex = OutputData.getCommandInput().lastIndexOf("%");
                            int lastDotIndex = OutputData.getCommandInput().lastIndexOf(".");

                            int[] indicesArr = {lastPlusIndex, lastMinusIndex, lastMultipIndex, lastDivisionIndex, lastModIndex, lastDotIndex};
                            int whereToAddMinus = ArrayUtils.findMax(indicesArr, 0, indicesArr.length-1);

                            OutputData.setCommandInput(OutputData.getCommandInput().substring(0, whereToAddMinus+1) + "(-" + OutputData.getCommandInput().substring(whereToAddMinus+1) + ")");
                        }
                        break;
                    case "=":
                        OutputData.setCalculatedOutput("" + ExpEvaluator.evaluateComplexExp(OutputData.getCommandInput()));
                        OutputData.setCommandInput("0");
                        break;
                    case "+", "-", "x", "÷", "%", ".":
                        if(lastChar == '+' || lastChar == '-' || lastChar == 'x' || lastChar == '÷' || lastChar == '%'){
                            if(type.equals(".")){
                                OutputData.setCommandInput(OutputData.getCommandInput() + "0" + type);
                            }
                            else{
                                OutputData.setCommandInput(OutputData.getCommandInput().substring(0, OutputData.getCommandInput().length()-1) + type);
                            }
                        }
                        else if(type.equals(".")){
                            int lastPlusIndex = OutputData.getCommandInput().lastIndexOf("+");
                            int lastMinusIndex = OutputData.getCommandInput().lastIndexOf("-");
                            int lastMultipIndex = OutputData.getCommandInput().lastIndexOf("x");
                            int lastDivisionIndex = OutputData.getCommandInput().lastIndexOf("÷");
                            int lastModIndex = OutputData.getCommandInput().lastIndexOf("%");
                            int lastDotIndex = OutputData.getCommandInput().lastIndexOf(".");
                            int[] indicesArr = {lastPlusIndex, lastMinusIndex, lastMultipIndex, lastDivisionIndex, lastModIndex, lastDotIndex};

                            if(ArrayUtils.findMax(indicesArr, 0, indicesArr.length-1) != lastDotIndex){
                                OutputData.setCommandInput(OutputData.getCommandInput() + type);
                            }
                        }
                        else{
                            OutputData.setCommandInput(OutputData.getCommandInput() + type);
                        }
                        break;
                    default:
                        if(OutputData.getCommandInput().equals("0")){
                            if(!type.equals("0")){
                                OutputData.setCommandInput(type);
                            }
                        }
                        else {
                            OutputData.setCommandInput(OutputData.getCommandInput() + type);
                            System.out.println(OutputData.getCommandInput());
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.green);
        setBackground(Color.green);
        super.paintComponent(g);
    }
}
