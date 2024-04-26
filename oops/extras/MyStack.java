package day3.extras;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.top);
        stack.display();
        stack.push(5);
        stack.display();
        System.out.println(stack.top);
        System.out.println("============");
        System.out.println(stack.size());
        for (int i = 0; i < 14; i++) {
            stack.push(i);
        }
        stack.display();
        System.out.println(stack.top);
        System.out.println(stack.size());

        System.out.println("============");
        System.out.println(stack.size());
        for (int i = 0; i < 14; i++) {
            stack.push(i * 5);
        }
        stack.display();
        System.out.println(stack.top);
        System.out.println(stack.size());
        System.out.println("============");
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.display();
    }

    int[] data;
    int top;

    public MyStack() {
        data = new int[10];
        top = -1;
    }

    public MyStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int capacity() {
        return data.length;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    public void display() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        if (isEmpty()) {
            System.out.println(sj);
            return;
        }
        for (int i = 0; i <= top; i++) {
            sj.add(data[i] + "");
        }
        System.out.println(sj.toString());
    }

    public void push(int element) {
        if (isFull()) {
            grow();
        }
        this.data[++top] = element;
    }

    private void grow() {
        int growFactor = isEmpty() ? 10 : size() + (capacity() >> 2);
        this.data = Arrays.copyOf(data, growFactor);
    }

    public boolean isFull() {
        return capacity() == size();
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("No element present in stack");
        }
        int popElement = peek();
        top--;
        return popElement;
    }
}