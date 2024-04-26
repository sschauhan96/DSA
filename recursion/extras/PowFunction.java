package day2.extras;

public class PowFunction {
    
    public static void main(String[] args){
        System.out.println(pow(2, 3));
    }

    private static int pow(int a, int b) {
        if(b == 0){
            return 1;
        }
        
        if(b%2==0){
            return pow(a, b/2)*pow(a, b/2);
        }else{
            return a*pow(a, b/2)*pow(a, b/2);
        }
    }
}
