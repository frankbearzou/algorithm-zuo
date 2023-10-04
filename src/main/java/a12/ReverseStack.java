package a12;

import java.util.Stack;

public class ReverseStack {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int val = removeBottom(stack);
        reverse(stack);
        stack.push(val);
    }

    private int removeBottom(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = removeBottom(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
