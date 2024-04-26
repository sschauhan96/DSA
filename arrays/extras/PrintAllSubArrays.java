package arrays.extras;

public class PrintAllSubArrays {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("[");
                for (int s = i; s <= j; s++) {
                    System.out.print(arr[s] + " ");
                }
                System.out.println("]");
            }
            System.out.println();
        }
    }
}