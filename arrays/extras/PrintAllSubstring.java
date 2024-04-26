package arrays.extras;

public class PrintAllSubstring {
    public static void main(String[] args) {
        String str = "abcd";

        for (int s = 0; s < str.length(); s++) {
            for (int e = s + 1; e <= str.length(); e++) {
                System.out.println(str.substring(s, e));
            }
        }
    }
}
