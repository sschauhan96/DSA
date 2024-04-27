
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        for(int i = 1; i<=5; i++){
            s1.push(i);
        }
        System.out.println(s1);
        Stack<Integer> s2 = new Stack<>();
        copyStack(s1, s2);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        System.out.println(s1);
    }

    private static void copyStack(Stack<Integer> s1, Stack<Integer> s2) {
        if(s1.isEmpty()){
            return;
        }
        int popElement = s1.pop();
        copyStack(s1, s2);
        s2.push(popElement);
    }
}
