package oops.leetcode;

public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int ref = 0;
        while(true){
            ref = nums[ref];
            slow = nums[slow];
            if(slow == ref){
                break;
            }
        }
        return slow;
    }
}
