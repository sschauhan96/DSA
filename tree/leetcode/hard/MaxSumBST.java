package leetcode.hard;

public class MaxSumBST {

    int max = 0;

    public int maxSumBST(TreeNode root) {
        getMax(root);
        return max;
    }

    private BSTWrapper getMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        BSTWrapper curr = new BSTWrapper(node.val);
        BSTWrapper left = getMax(node.left);
        BSTWrapper right = getMax(node.right);

        if (left != null) {
            curr.min = Math.min(left.min, curr.min);
            curr.max = Math.max(left.max, curr.max);
            curr.sum += left.sum;
            curr.isBST = left.isBST && left.max <= node.val;
        }

        if (right != null) {
            curr.min = Math.min(right.min, curr.min);
            curr.max = Math.max(right.max, curr.max);
            curr.sum += right.sum;
            curr.isBST &= right.isBST && node.val < right.min;
        }

        if (curr.isBST) {
            max = Math.max(curr.sum, max);
        }
        return curr;
    }
}

class BSTWrapper {

    int min;
    int max;
    boolean isBST;
    int sum;

    public BSTWrapper(int val) {
        this.min = val;
        this.max = val;
        this.sum = val;
        this.isBST = true;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
}
