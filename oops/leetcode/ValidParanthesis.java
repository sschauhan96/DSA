package oops.leetcode;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        ValidParanthesis ob = new ValidParanthesis();
        System.out.println(ob.isValid("()"));
    }
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isClosingBracket(ch)){
                if(charStack.isEmpty()){
                    return false;
                }
                char openingBracket = charStack.pop();
                if(ch != getMatchingClosingBracket(openingBracket)){
                    return false;
                }
            }else{
                charStack.push(ch);
            }
        }
        return charStack.isEmpty();
    }

    private char getMatchingClosingBracket(char openingB){
        switch(openingB){
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
            default : return '0';
        }
    }

    private boolean isClosingBracket(char ch){
        return ch==')' || ch=='}' || ch==']';
    }
}
