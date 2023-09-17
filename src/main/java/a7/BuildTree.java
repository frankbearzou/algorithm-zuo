package a7;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    public Queue<Integer> serialize(Node head) {
        Queue<Integer> queue = new LinkedList<>();
        pre(head, queue);
        return queue;
    }

    private void pre(Node head, Queue<Integer> queue) {
        if (head == null) {
            queue.add(null);
        } else {
            queue.add(head.value);
            pre(head.left, queue);
            pre(head.right, queue);
        }
    }

    public Node deserialize(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return preBuild(queue);
    }

    private Node preBuild(Queue<Integer> queue) {
        Integer value = queue.poll();
        if (value == null) {
            return null;
        }
        Node head = new Node(value);
        head.left = preBuild(queue);
        head.right = preBuild(queue);
        return head;
    }
}
