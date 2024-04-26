package day2.extras;

public class FindMaxInArray {
    public static void main(String[] args){
        int[] arr = {1, 21, 113, 4, 5};
        System.out.println(findMax(arr, 0));
    }

    private static int findMax(int[] arr, int idx) {
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }
        return Math.max(arr[idx], findMax(arr, idx+1));
    }
}
