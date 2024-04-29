package leetcode.easy;

public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        return solve(root).isBalanced;
    }

    private BH solve(TreeNode root) {
        if (root == null) {
            return new BH();
        }
        BH sp1 = solve(root.left);
        BH sp2 = solve(root.right);
        int height = Math.max(sp1.height, sp2.height) + 1;
        boolean isBalanced = false;
        if (sp1.isBalanced && sp2.isBalanced) {
            isBalanced = Math.abs(sp1.height - sp2.height) <= 1;
        }
        return new BH(height, isBalanced);
    }
}

class BH {

    int height = -1;
    boolean isBalanced = true;

    public BH() {
    }

    public BH(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int num) {
        this.val = num;
    }
}
