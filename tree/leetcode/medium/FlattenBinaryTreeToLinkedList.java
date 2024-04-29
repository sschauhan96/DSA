package leetcode.medium;

public class FlattenBinaryTreeToLinkedList {

    TreeNode head = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            flatten(root.right);
        }
        if (root.left != null) {
            flatten(root.left);
        }
        root.left = null;
        root.right = head;
        head = root;
    }

}
