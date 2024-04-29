package leetcode.medium;

import leetcode.medium.BinaryTreeLvlOrderTraversal.TreeNode;

public class ConvertSortedLinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next.next;
        TreeNode curr = new TreeNode(slow.next.val);
        slow.next = null;
        curr.left = sortedListToBST(head);
        curr.right = sortedListToBST(rightStart);
        return curr;
    }
}

class ListNode {

    int val;
    ListNode next;
}
