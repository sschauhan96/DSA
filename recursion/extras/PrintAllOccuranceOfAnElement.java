package day2.extras;

import java.util.Arrays;

public class PrintAllOccuranceOfAnElement {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,2,2,3,2};
        System.out.println(Arrays.toString(findAllOccurance(arr, 0, 2, 0)));
    }

    private static int[] findAllOccurance(int[] arr, int idx, int element, int totalFound) {
        if(idx == arr.length){
            return new int[totalFound];
        }
        int[] res = null;
        if(arr[idx] == element){
            res = findAllOccurance(arr, idx+1, element, totalFound+1);
            res[totalFound] = idx;
        }else{
            res = findAllOccurance(arr, idx+1, element, totalFound);
        }
        return res;
    }
}
