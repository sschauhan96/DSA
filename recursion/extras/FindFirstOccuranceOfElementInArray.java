package day2.extras;

public class FindFirstOccuranceOfElementInArray {

    public static void main(String[] args){
        int[] arr = {1,2,4,5,3,2,5};
        System.out.println(findFirstOccurance(arr, 10, 0));
    }

    private static int findFirstOccurance(int[] arr, int element, int idx) {
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == element){
            return idx;
        }else{
            return findFirstOccurance(arr, element, idx+1);
        }
    }


    
}
