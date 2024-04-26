package arrays.leetcode.medium;

import java.util.Arrays;

public class ProductArrayElementExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= product;
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
