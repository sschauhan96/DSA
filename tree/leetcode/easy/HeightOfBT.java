package leetcode.easy;

public class HeightOfBT {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sp1 = maxDepth(root.left);
        int sp2 = maxDepth(root.right);
        return Math.max(sp1, sp2) + 1;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
    }
}
