package src.utilities;

public class ArrayUtils {
    public static int linearSearch(int[] arr, int startIndex, int endIndex, int val){
        int index = -1;
        if(arr != null && startIndex >= 0 && endIndex < arr.length && startIndex <= endIndex){
            for(int i = startIndex; i <= endIndex && index == -1; i++){
                if(arr[i] == val)
                    index = i;
            }
        }

        return index;
    }

    public static int linearSearch(boolean[] arr, int startIndex, int endIndex, boolean val){
        int index = -1;
        if(arr != null && startIndex >= 0 && endIndex < arr.length && startIndex < endIndex){
            for(int i = startIndex; i <= endIndex && index == -1; i++){
                if(arr[i] == val)
                    index = i;
            }
        }

        return index;
    }

    public static int findMax(int[] arr, int startIndex, int endIndex){
        int max = -1;

        if(arr != null && arr.length != 0 && startIndex >= 0 && endIndex < arr.length && startIndex <= endIndex){
            max = arr[startIndex];
            if(startIndex + 1 < arr.length) {
                for (int i = startIndex + 1; i <= endIndex; i++) {
                    if (arr[i] > max)
                        max = arr[i];
                }
            }
        }

        return max;
    }
}
