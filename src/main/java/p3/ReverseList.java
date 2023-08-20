package p3;

public class ReverseList {
    public Node reverseNode(Node head) {
        Node pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }
}
