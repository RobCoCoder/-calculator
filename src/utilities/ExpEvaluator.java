package src.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpEvaluator {
    private static final String[] operators = new String[] {"x", "÷", "%", "-", "+"};

    public static double evaluateComplexExp(String exp){
        // if first character is an operator, add initial 0 to the left
        if(!Character.isDigit(exp.charAt(0))){
            exp = "0" + exp;
        }

        // surrounding expression with braces
        exp = "(" + exp + ")";

        // result of calculations
        double result = 0;

        // tokens of the given expression
        ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(getTokens(exp)));

        // while there are tokens to be evaluated
        while(tokens.size() != 1){
            CoordinatePair nestedBracesCoordiantes = lookForNestedBraces(tokens, 0, tokens.size()-1);

            // forming the nested expression
            ArrayList<String> nestedTokens = new ArrayList<String>(tokens.subList(nestedBracesCoordiantes.getCoordinateX(), nestedBracesCoordiantes.getCoordinateY()+1));

            double nestedExpResult = evaluateSimpleExp(nestedTokens);

            // removing nested expression, replacing it with nestedExpResult
            for(int i = nestedBracesCoordiantes.getCoordinateX(); i < nestedBracesCoordiantes.getCoordinateY(); i++){
                tokens.remove(nestedBracesCoordiantes.getCoordinateX());
            }
            tokens.set(nestedBracesCoordiantes.getCoordinateX(), Double.toString(nestedExpResult));
        }

        // convert final result to double
        result = Double.parseDouble(tokens.getFirst());

        return result;
    }

    private static double evaluateSimpleExp(ArrayList<String> tokens){
        /**
         * A simple expression is a mathematical expression that contians no inner pair of braces
         * Function evaluates such a simple expression and returns the result
         * Expression must be passed surrounded by braces
         */

        // result of calculations
        double result = 0;

        // while there are operator tokens to evaluate
        while(tokens.size() != 1){
            // going through each operator
            for(String currOperator : operators){
                /* while tokens have this current operator and the tokens are not of form (x) or (-x)
                 * when tokens become of form (x), (-x), no operator is to be performed; it must be
                 * converted to x or -x
                 */
                while(tokens.contains(currOperator) && tokens.size() != 3 && tokens.size() != 4) {
                    // going through each token, finding current operator and performing operation if possible
                    for(int j = 0; j < tokens.size(); j++){
                        String currToken = tokens.get(j);

                        // if current token matches the operator and has two operands
                        if (currToken.equals(currOperator) && j > 0 && j < tokens.size() - 1) {
                            // if left- and right-side operands are numeric
                            if(isNumeric(tokens.get(j - 1)) && isNumeric(tokens.get(j + 1))) {
                                double operand1 = Double.parseDouble(tokens.get(j - 1));
                                double operand2 = Double.parseDouble(tokens.get(j + 1));

                                double calculation = applyOperator(operand1, operand2, currOperator);

                                // replace evaluated expression with the result in the list of tokens
                                tokens.set(j, Double.toString(calculation));
                                tokens.remove(j - 1); // removing j - 1
                                tokens.remove(j); // removing j + 1
                            }
                            // else if right-hand operator is of form -x, making the operands y*-x
                            else if(j != tokens.size() - 2 && isNumeric(tokens.get(j-1)) && tokens.get(j+1).equals("-") && isNumeric(tokens.get(j+2))){
                                double operand1 = Double.parseDouble(tokens.get(j - 1));
                                double operand2 = (-1) * Double.parseDouble(tokens.get(j + 2));

                                double calculation = applyOperator(operand1, operand2, currOperator);

                                // replace evaluated expression with the result in the list of tokens
                                tokens.set(j, Double.toString(calculation));
                                tokens.remove(j - 1); // removing j - 1
                                tokens.remove(j); // removing j + 1
                                tokens.remove(j); // removing j + 2
                            }
                        }
                    }
                }
            }

            // tokens have become of form (x) or (-x)
            tokens.removeFirst(); // removing (
            tokens.removeLast(); // removing )
            if(tokens.size() == 2){
                tokens.removeFirst(); // removing - sign
                tokens.set(0,"" + ((-1) * Double.parseDouble(tokens.getFirst())));
            }
        }
        return Double.parseDouble(tokens.getFirst());
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

    /**
     * Finds the innermost nested pair of braces, the expression inside which needs to be
     * evaluated first, prior to the rest of the expression
     * Returns the coordinate pair of the braces as an instance of CoordinatePair class
     */
    public static CoordinatePair lookForNestedBraces(ArrayList<String> tokens, int startIndex, int endIndex){
        CoordinatePair bracesCoordinates = new CoordinatePair(-1, -1);
        CoordinatePair nestedBracesCoordinates = bracesCoordinates; // the brace coordinates of the nested braces inside current pair

        // if valid parameters
        if(tokens != null && !tokens.isEmpty() && startIndex >= 0 && endIndex < tokens.size() && startIndex <= endIndex){
            int leftBraceIndex = startIndex + tokens.subList(startIndex, endIndex+1).indexOf("("); // when not found, yields startIndex-1
            int rightBraceIndex = findRelatedClosingBrace(tokens, leftBraceIndex); // -1 if not found

            boolean isLeftBraceIndexFound = (leftBraceIndex != startIndex-1);
//             boolean isRightBraceIndexFound = (rightBraceIndex != -1);

            // while not getting invalid coordinate pairs (-1, -1) or (startIndex-1, -1)
            while(isLeftBraceIndexFound && leftBraceIndex != -1 && rightBraceIndex != -1){
                bracesCoordinates = new CoordinatePair(leftBraceIndex, rightBraceIndex);

                nestedBracesCoordinates = lookForNestedBraces(tokens, leftBraceIndex + 1, rightBraceIndex - 1);
                leftBraceIndex = nestedBracesCoordinates.getCoordinateX();
                rightBraceIndex = nestedBracesCoordinates.getCoordinateY();
            }
        }

        return bracesCoordinates;
    }

    private static String[] getTokens(String exp) {
        return exp.split("(?<=[-+x÷%()])|(?=[-+x÷%()])");
//        return exp.split("(?<=\\d)(?=[-+x÷%()])|(?=[-+x÷%()])|(?<=\\()(?=-\\d)|(?<=\\D)(?=-\\d)");
    }

    private static void removeRedundantBraces(ArrayList<String> tokens, int startIndex, int endIndex){
        tokens.remove(startIndex);
        tokens.remove(endIndex-1);

        if(endIndex - startIndex == 2) {
            tokens.set(startIndex, tokens.get(startIndex) + Double.parseDouble(tokens.get(startIndex + 1)));
            tokens.remove(startIndex+1);
        }
    }

    private static int findRelatedClosingBrace(ArrayList<String> tokens, int leftBraceIndex){
        int index = -1; // index of related closing brace

        // if parameters are valid
        if(tokens != null && leftBraceIndex >= 0 && leftBraceIndex < tokens.size()-1){
            int leftBracesCount = 1; // the number of opening braces encountered so far
            int rightBracesCount = 0; // the number of closing braces encountered so far
            int currentIndex = leftBraceIndex+1; // index to start search from

            while(leftBracesCount != rightBracesCount && currentIndex < tokens.size()){
                String currToken = tokens.get(currentIndex);
                if(currToken.equals("("))
                    leftBracesCount++;
                else if(currToken.equals(")"))
                    rightBracesCount++;

                currentIndex++;
            }

            // if exited while loop because of exact brace pairs found
            if(leftBracesCount == rightBracesCount) {
                index = (--currentIndex); // current index will be one after the closing brace needed
            }
        }

        return index;
    }
}
