package src.components.controls;

import src.state.OutputData;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButton extends JButton {
    private static ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    private static ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

    public ControlButton(String type) {
        super(type);
        setBackground(new Color(0, 0, 0));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type){
                    case "AC":
                        OutputData.setCalculatedOutput("");
                        OutputData.setCommandInput("0");
                        break;
                    case "+/-":
                        //FIXME
                        break;
                    case "=":
                        try {
                            String result = (scriptEngine.eval(OutputData.getCommandInput())).toString();
                            OutputData.setCalculatedOutput(result);
                        } catch (ScriptException ex) {
                            OutputData.setCalculatedOutput("Error");
                        }
                        OutputData.setCommandInput("0");
                        break;
                    case "+", "-", "x", "÷", "%", ".":
                        OutputData.setCommandInput(OutputData.getCommandInput() + type);
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
