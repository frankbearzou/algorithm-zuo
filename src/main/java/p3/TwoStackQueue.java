package p3;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStackQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void add(int value) {
        pushStack.push(value);
        pushToPopStack();
    }

    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPopStack();
        return popStack.pop();
    }

    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPopStack();
        return popStack.peek();
    }

    private void pushToPopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
