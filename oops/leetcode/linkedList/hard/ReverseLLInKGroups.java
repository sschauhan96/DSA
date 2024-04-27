package leetcode.linkedList.hard;

import java.util.Stack;

public class ReverseLLInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tempHead = new ListNode(0);
        ListNode currNode = tempHead;
        while (head != null) {
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    currNode.next = stack.pop();
                    currNode = currNode.next;
                }
            }
            stack.push(head);
            head = head.next;
        }

        if (!stack.isEmpty()) {
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    currNode.next = stack.pop();
                    currNode = currNode.next;
                }
                currNode.next = null;
            } else {
                ListNode leftNode = null;
                while (!stack.isEmpty()) {
                    leftNode = stack.pop();
                }
                currNode.next = leftNode;
            }
        }
        return tempHead.next;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
