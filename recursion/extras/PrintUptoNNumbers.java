package day2.extras;

public class PrintUptoNNumbers {
    public static void main(String[] args){
        printUptoN(10);
    }

    private static void printUptoN(int n) {
        if(n==0){
            return;
        }
        printUptoN(n-1);
        System.out.println(n);
    }
}
