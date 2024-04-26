package arrays.leetcode.medium;

public class DivisibleSubArrayByK {

    public static void main(String[] args) {
        DivisibleSubArrayByK.Solution sol = new DivisibleSubArrayByK().new Solution();
        int[] arr = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(sol.subarraysDivByK(arr, k));
    }

    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int[] remArray = new int[k];
            int sum = 0;
            int count = 0;

            remArray[0] = 1;
            for (int num : nums) {
                sum += num;
                int rem = sum % k;
                if (rem < 0) {
                    rem += k;
                }
                count += remArray[rem];
                remArray[rem] = remArray[rem] + 1;
            }
            return count;
        }
    }
}
