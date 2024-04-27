
import java.util.Stack;

public class RemoveNodesFromLL {

    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        Stack<Integer> res = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (res.isEmpty() || res.peek() <= curr) {
                res.push(curr);
            }
        }
        ListNode result = new ListNode(0);
        ListNode newHead = result;
        while (!res.isEmpty()) {
            result.next = new ListNode(res.pop());
            result = result.next;
        }
        return newHead.next;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
