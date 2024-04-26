package day2.extras;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int[] sort(int[] arr, int s, int e) {
        if (s == e) {
            return new int[] { arr[s] };
        }

        int mid = s + (e - s) / 2;
        int[] sp1 = sort(arr, s, mid);
        int[] sp2 = sort(arr, mid + 1, e);
        return mergeArrays(sp1, sp2);
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
        }

        while (idx1 < nums1.length) {
            nums[idx++] = nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            nums[idx++] = nums2[idx2++];
        }
        return nums;
    }
}
