package a6;

public class FastSlowPointerLinkedList {
    public Node oddMidEvenLowerMid(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
