import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyQueue {
    private int[] data;
    private int start;
    private int size;

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.capacity());
        System.out.println(queue.size());
        System.out.println(queue);
        for (int i = 0; i < 24; i++) {
            queue.add((int) (Math.random() * 10));
        }

        System.out.println("==============");
        System.out.println(queue.capacity());
        System.out.println(queue.size());
        System.out.println(queue);

    }

    public MyQueue() {
        data = new int[10];
        start = 0;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int capacity() {
        return data.length;
    }

    public boolean isFull() {
        return size() == capacity();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        if (isEmpty()) {
            return sj.toString();
        }
        for (int i = start; i < start + size(); i++) {
            sj.add("" + data[i % capacity()]);
        }
        return sj.toString();
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data[(capacity() + start) % capacity()];
    }

    public void add(int element) {
        if (size() == capacity()) {
            grow();
        }
        data[(size() + start) % capacity()] = element;
        size++;
    }

    public void grow() {
        int growFactor = capacity() + (capacity() / 2);
        int[] newArray = new int[growFactor];
        for (int i = 0; i < size(); i++) {
            newArray[i] = data[(i + start) % capacity()];
        }
        this.data = newArray;
        this.start = 0;
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int pollElement = peek();
        start++;
        size--;
        return pollElement;
    }
}
