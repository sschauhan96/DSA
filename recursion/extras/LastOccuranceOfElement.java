package day2.extras;

public class LastOccuranceOfElement {
    public static void main(String[] args){
        int[] arr = {2,0,4,2,2,2,1,4,5};
        System.out.println(lastOccurance(arr, 0, 0));
    }

    private static int lastOccurance(int[] arr, int element, int idx) {
        if(idx==arr.length){
            return -1;
        }
        int sp = lastOccurance(arr, element, idx+1);
        if(sp!=-1){
            return sp;
        }
        if(arr[idx] == element){
            return idx;
        }else{
            return -1;
        }
    }   
}
