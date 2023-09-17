package a7;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelSerialization {
    public Queue<Integer> serialize(Node head) {
        Queue<Integer> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (head == null) {
            res.offer(null);
            return res;
        }
        res.offer(head.value);
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                res.add(node.left.value);
            } else {
                res.add(null);
            }
            if (node.right != null) {
                queue.offer(node.right);
                res.add(node.right.value);
            } else {
                res.add(null);
            }
        }
        return res;
    }

    public Node deserialize(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        Node head = buildNode(queue.poll());
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node node = q.poll();
            node.left = buildNode(queue.poll());
            node.right = buildNode(queue.poll());
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return head;
    }

    private Node buildNode(Integer value) {
        if (value == null) {
            return null;
        }
        return new Node(value);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.left = n5;

        TreeLevelSerialization app = new TreeLevelSerialization();
        Queue<Integer> serialize = app.serialize(n1);
        System.out.println(serialize);
        Node deserialize = app.deserialize(serialize);
        System.out.println(deserialize);
    }
}
