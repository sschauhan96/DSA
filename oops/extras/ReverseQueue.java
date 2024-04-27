
import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
        System.out.println("Before->>" + queue);
        printReverseQueue(queue, queue.size());
        System.out.println("\nAfter->>" + queue);

    }

    private static void printReverseQueue(Queue<Integer> queue, int size) {
        if (size == 0) {
            return;
        }
        int pollElement = queue.poll();
        queue.add(pollElement);
        printReverseQueue(queue, size - 1);
        System.out.print(pollElement + " ->");
    }
}
