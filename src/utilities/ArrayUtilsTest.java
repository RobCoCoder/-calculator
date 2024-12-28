package src.utilities;

public class ArrayUtilsTest {
    public static void main(String[] args){
        findMaxTest();
    }

    public static void findMaxTest(){
        int[] arr;

        // Test 1
        arr = new int[] {};
        assert ArrayUtils.findMax(arr, 0, 1) == -1;

        // Test 2
        arr = new int[] {1, 2};
        assert ArrayUtils.findMax(arr, 1, 1) == 2;

        // Test 3
        arr = new int[] {1, 2, 10, -1, 50, 100, 22, 99, -1};
        assert ArrayUtils.findMax(arr, 0, 8) == 100;
    }
}
