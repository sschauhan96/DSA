package arrays.leetcode.medium;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();

        for (String str : strArray) {
            sb.append(str);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
