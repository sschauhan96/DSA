package leetcode.medium;

import leetcode.medium.BinaryTreeLvlOrderTraversal.TreeNode;

public class FlipEquivalent {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        boolean sp1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean sp2 = flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        return sp1 || sp2;
    }
}
