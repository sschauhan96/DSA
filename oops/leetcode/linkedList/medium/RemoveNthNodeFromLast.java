package oops.leetcode.linkedList.medium;

public class RemoveNthNodeFromLast {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode myHead = head;
        for (int i = 1; i <= 5; i++) {
            myHead.next = new ListNode(i);
            myHead = myHead.next;
        }
        RemoveNthNodeFromLast ob = new RemoveNthNodeFromLast();
        ListNode res = ob.removeNthFromEnd(head.next, 2);
        System.out.println(res);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head;
        while (n-- != 0 && ahead != null) {
            ahead = ahead.next;
        }
        // if (n != 0) {
        //     return head;
        // }
        ListNode curr = head;
        while (ahead != null && ahead.next != null) {
            ahead = ahead.next;
            curr = curr.next;
        }
        curr.next = ahead.next;
        return head;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
