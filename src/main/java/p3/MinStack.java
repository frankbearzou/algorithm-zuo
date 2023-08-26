package p3;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else if (value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int ret = stack.pop();
        if (ret == minStack.peek()) {
            minStack.pop();
        }
        return ret;
    }

    public int min() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }
}
