package oops.leetcode;

import java.util.Stack;

public class Validate132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int kthIdx = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(kthIdx>-1 && nums[kthIdx]>nums[i]){
                return true;
            }
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                kthIdx = stack.pop();
            }
            stack.push(i);
        }
        return false;   
    }
}
