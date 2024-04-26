package arrays.leetcode.medium;

public class CircularMaxSubArraySum {
    public int maxSubarraySumCircular(int[] nums) {
        int max1 = maxSubArraySum(nums);
        if (max1 < 0) {
            return max1;
        }
        int totalSum = getTotalSumAndMakeArrNeg(nums);
        int max2 = totalSum + maxSubArraySum(nums);
        return Math.max(max1, max2);
    }

    private int getTotalSumAndMakeArrNeg(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] *= -1;
        }
        return sum;
    }

    private int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
