package arrays.leetcode.medium;

public class SortColorInLinearTime {
     public void sortColors(int[] nums) {
          int[] ref = new int[3];
          for (int i = 0; i < nums.length; i++) {
               ref[nums[i]] += 1;
          }

          int idx = 0;
          for (int i = 0; i < ref.length; i++) {
               while (ref[i] > 0) {
                    nums[idx++] = i;
                    ref[i] -= 1;
               }
          }
     }
}
