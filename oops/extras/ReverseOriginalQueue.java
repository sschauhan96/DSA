
import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseOriginalQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
        System.out.println("Before->>" + queue);
        reverseQueue(queue);
        System.out.println("\nAfter->>" + queue);

    }

    private static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int pollElement = queue.poll();
        reverseQueue(queue);
        queue.add(pollElement);
    }
}
