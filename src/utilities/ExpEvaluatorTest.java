package src.utilities;

public class ExpEvaluatorTest {
    public static void main(String[] args){
        evaluateTest();
    }

    public static void evaluateTest(){
        // Test 1
        assert Math.abs(ExpEvaluator.evaluate("1+2") - 3.0) < 0.0001;
        assert Math.abs(ExpEvaluator.evaluate("1+2x4") - 9.0) < 0.0001;
        assert Math.abs(ExpEvaluator.evaluate("0-2+5.2") - 3.2) < 0.0001;
        assert Math.abs(ExpEvaluator.evaluate("0-2.0+20.2x4.8") - 94.96) < 0.001;
    }
}
