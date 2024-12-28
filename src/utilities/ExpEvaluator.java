package src.utilities;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpEvaluator {
    private static final String[] operators = new String[] {"x", "÷", "%", "-", "+"};

    public static double evaluate(String exp){
        if(!Character.isDigit(exp.charAt(0))){
            exp = "0" + exp;
        }

        double result = 0;

        ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(exp.split("(?<=[-+x÷%])|(?=[-+x÷%])")));

        while(tokens.size() != 1){
            for(String currOperator : operators){
                while(tokens.contains(currOperator)) {
                    for (int j = 0; j < tokens.size(); j++) {
                        String currToken = tokens.get(j);

                        // checking if current token is the operator and hasn't been performed
                        if (currToken.equals(currOperator) && j != 0 && isNumeric(tokens.get(j - 1)) && j != tokens.size() - 1 && isNumeric(tokens.get(j + 1))) {
                            double operand1 = Double.parseDouble(tokens.get(j - 1));
                            double operand2 = Double.parseDouble(tokens.get(j + 1));

                            double calculation = applyOperator(operand1, operand2, currOperator);
                            tokens.set(j, Double.toString(calculation));
                            tokens.remove(j - 1);
                            tokens.remove(j);
                        }
                    }
                }
            }
        }

        result = Double.parseDouble(tokens.getFirst());

        return result;
    }

    public static String[] getTokens(String exp){
        return exp.split("(?<=[-+x÷])|(?=[-+x÷])");
    }

    public static boolean[] constructInvalidTokensIndices(String[] tokens){
        boolean[] invalidTokensIndices = new boolean[tokens.length];
        Arrays.fill(invalidTokensIndices, true);

        return invalidTokensIndices;
    }

    public static double applyOperator(double a, double b, String op){
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "x" -> a * b;
            case "÷" -> a / b;
            case "%" -> a % b;
            default -> 0;
        };
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
