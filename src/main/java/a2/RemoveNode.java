package a2;

public class RemoveNode {
    public Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value == num) {
                head = head.next;
            } else {
                break;
            }
        }
        Node pre = head, cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
