
public class RemoveNthNodeFromLastInLL {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode slow = newHead;
        ListNode ahead = newHead;

        for (int i = 0; i < n; i++) {
            if (ahead == null) {
                return head;
            }
            ahead = ahead.next;
        }
        while (ahead != null && ahead.next != null) {
            ahead = ahead.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
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
