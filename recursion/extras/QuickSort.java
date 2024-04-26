package day2.extras;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;
        int left = s;
        int right = e;
        int pivot = nums[mid];

        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, s, right);
        quickSort(nums, left, e);
    }
}
