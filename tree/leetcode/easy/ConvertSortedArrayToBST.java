package leetcode.easy;

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = createTree(nums, s, mid - 1);
        curr.right = createTree(nums, mid + 1, e);
        return curr;
    }
}
