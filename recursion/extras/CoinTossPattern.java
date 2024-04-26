package day2.extras;

public class CoinTossPattern {
    public static void main(String[] args){
        coinToss(3, "");
    }

    private static void coinToss(int coins, String pattern) {
        if(coins == 0){
            System.out.println(pattern);
            return;
        }
        coinToss(coins-1, pattern+'H');
        coinToss(coins-1, pattern+'T');
    }
}
