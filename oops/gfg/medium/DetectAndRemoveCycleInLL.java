package gfg.medium;

import org.w3c.dom.Node;

public class DetectAndRemoveCycleInLL {

    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                if (fast == head) {
                    while (fast.next != head) {
                        fast = fast.next;
                    }
                } else {
                    slow = head;
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
                fast.next = null;
            }
        }
    }

    class Node {

        int data;
        Node next;
    }
}
