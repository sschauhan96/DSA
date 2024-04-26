package arrays.leetcode.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int breakPoint = getBreakPoint(nums);
        if (breakPoint == -1) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int idxToSwap = getIdxToSwap(nums, breakPoint);
            swap(nums, idxToSwap, breakPoint);
            reverseArray(nums, breakPoint + 1, nums.length - 1);
        }
    }

    private void reverseArray(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getIdxToSwap(int[] nums, int breakPoint) {
        for (int i = nums.length - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                return i;
            }
        }
        return -1;
    }

    private int getBreakPoint(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
