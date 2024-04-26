package arrays.extras;

public class ReverseWord {
    public static void main(String[] args) {
        String str = "My name is Sandeep Singh Chauhan";
        reverseWord(str.trim());
    }

    private static void reverseWord(String str) {
        int lastSpace = str.lastIndexOf(" ");
        if (lastSpace == -1) {
            System.out.println(str);
        } else {
            System.out.println(str.substring(lastSpace + 1));
            reverseWord(str.substring(0, lastSpace));
        }
    }
}
