package day2.extras;

public class SubsequenceOfString {
    public static void main(String[] args) {
        subsequence("abc", "");
    }

    private static void subsequence(String str, String pattern) {
        if (str.isEmpty()) {
            System.out.println(pattern);
            return;
        }
        subsequence(str.substring(1), pattern);
        subsequence(str.substring(1), pattern + str.charAt(0));
        subsequence(str.substring(1), pattern + (int)str.charAt(0));
    }
}
