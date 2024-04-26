package arrays.leetcode.medium;

public class AllPalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int axis = 0; axis < s.length(); axis++) {
            for (int rad = 0; axis - rad >= 0 && axis + rad < s.length(); rad++) {
                int left = axis - rad;
                int right = axis + rad;
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                count++;
            }

            for (double rad = 0.5; axis - rad >= 0 && axis + rad < s.length(); rad++) {
                int left = (int) (axis - rad);
                int right = (int) (axis + rad);
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}
