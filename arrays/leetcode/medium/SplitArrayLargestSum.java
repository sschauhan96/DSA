package arrays.leetcode.medium;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int total = Arrays.stream(nums)
                .reduce((a, b) -> a + b).getAsInt();
        int curr = nums[0];
        int res = total;
        while (curr <= total) {
            int mid = curr + (total - curr) / 2;
            if (isPossible(nums, mid, k)) {
                total = mid - 1;
                res = mid;
            } else {
                curr = mid + 1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] nums, int mid, int k) {
        int load = 0;
        int curr = 1;
        for (int i = 0; i < nums.length;) {
            load += nums[i];
            if (load > mid) {
                load = 0;
                curr++;
            } else {
                i++;
            }
            if (curr > k) {
                return false;
            }
        }
        return true;
    }
}
