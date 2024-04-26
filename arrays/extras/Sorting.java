package arrays.extras;

public class Sorting {

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currMaxIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[currMaxIdx] > nums[j]) {
                    currMaxIdx = j;
                }
            }
            if (currMaxIdx != i) {
                swap(nums, i, currMaxIdx);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int currElement = nums[i];
            int prevIdx = i - 1;
            while (prevIdx >= 0 && nums[prevIdx] > currElement) {
                nums[prevIdx + 1] = nums[prevIdx];
                prevIdx--;
            }
            nums[prevIdx + 1] = currElement;
        }
        return nums;
    }
}
