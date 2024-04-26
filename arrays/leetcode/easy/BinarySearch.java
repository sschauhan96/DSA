package arrays.leetcode.easy;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch.Solution sol = new BinarySearch().new Solution();
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(sol.search(arr, target));
    }

    class Solution {
        public int search(int[] nums, int target) {
            int s = 0;
            int e = nums.length - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            return -1;
        }
    }
}
