
import java.util.Stack;

public class IntersectionOfLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        while (headA != null) {
            s1.push(headA);
            headA = headA.next;
        }

        Stack<ListNode> s2 = new Stack<>();
        while (headB != null) {
            s2.push(headB);
            headB = headB.next;
        }
        ListNode intersection = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() != s2.peek()) {
                break;
            }
            intersection = s1.pop();
            s2.pop();
        }
        return intersection;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            if (n1 == null) {
                n1 = headB;
            } else {
                n1 = n1.next;
            }
            if (n2 == null) {
                n2 = headA;
            } else {
                n2 = n2.next;
            }
        }
        return n1;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
