
public class SwapNodesInLL {

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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode tempNode = new ListNode(0, head);
        ListNode nodeFromStart = tempNode;
        ListNode nodeFromEnd = tempNode;

        for (int i = 0; i < k; i++) {
            if (nodeFromStart != null) {
                nodeFromStart = nodeFromStart.next;
            }
        }

        ListNode refNode = nodeFromStart;
        while (refNode != null) {
            refNode = refNode.next;
            nodeFromEnd = nodeFromEnd.next;
        }

        int temp = nodeFromStart.val;
        nodeFromStart.val = nodeFromEnd.val;
        nodeFromEnd.val = temp;
        return tempNode.next;
    }
}
