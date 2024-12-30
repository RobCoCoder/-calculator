package src.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpEvaluatorTest {
    public static void main(String[] args){
        evaluateTest();
        lookForNestedBracesTest();
    }

    public static void evaluateTest(){
        assert Math.abs(ExpEvaluator.evaluateComplexExp("25x8.8-(-6.2x(-11.2))+(-3)") - 147.56) < 0.0001;

        assert Math.abs(ExpEvaluator.evaluateComplexExp("0-2+5.2") - 3.2) < 0.0001;

        assert Math.abs(ExpEvaluator.evaluateComplexExp("1+2") - 3.0) < 0.0001;
        assert Math.abs(ExpEvaluator.evaluateComplexExp("1+2x4") - 9.0) < 0.0001;

        assert Math.abs(ExpEvaluator.evaluateComplexExp("0-2.0+20.2x4.8") - 94.96) < 0.001;
        assert Math.abs(ExpEvaluator.evaluateComplexExp("1x(2.0-5)") + 3.0) < 0.0001;

        assert Math.abs(ExpEvaluator.evaluateComplexExp("2+(-3)") + 1.0) < 0.0001;
    }

    public static void lookForNestedBracesTest(){
        ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(new String[] {"(", "1", "x", "(", "2.0", "+", "5", ")", ")"}));
        CoordinatePair bracesCoordinates = ExpEvaluator.lookForNestedBraces(tokens, 0, tokens.size()-1);
        assert bracesCoordinates.getCoordinateX() == 3;
        assert bracesCoordinates.getCoordinateY() == 7;

        tokens = new ArrayList<String>(Arrays.asList(new String[] {"(", "25", "x", "8.8", "-", "(", "-", "6.2", "x", "(", "-", "11.2", ")", ")", "+", "(", "-", "3", ")", ")"}));
        bracesCoordinates = ExpEvaluator.lookForNestedBraces(tokens, 0, tokens.size()-1);
        assert bracesCoordinates.getCoordinateX() == 9;
        assert bracesCoordinates.getCoordinateY() == 12;
    }
//
//    public static void findRelatedClosingBraceTest(){
//        ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(new String[] {"(", "1", "x", "(", "2.0", "+", "5", ")", ")"}));
//
//        assert ExpEvaluator.findRelatedClosingBrace(tokens, 0) == 8;
//        assert ExpEvaluator.findRelatedClosingBrace(tokens, 3) == 7;
//
//        tokens = new ArrayList<String>(Arrays.asList(new String[] {"(", "25", "x", "8.8", "-", "(", "-", "6.2", "x", "(", "-", "11.2", ")", ")", "+", "(", "-", "3", ")", ")"}));
//        assert  ExpEvaluator.findRelatedClosingBrace(tokens, 15) == 18;
//        assert  ExpEvaluator.findRelatedClosingBrace(tokens, 9) == 12;
//    }
}
