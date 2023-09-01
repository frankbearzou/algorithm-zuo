package a5;

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    public static class Node {
        int pass;
        int end;
        Node[] next = new Node[26];
    }

    public void insert(String str) {
        if (str == null) {
            return;
        }
        Node node = root;
        node.pass++;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node.next[index].pass++;
            node = node.next[index];
        }
        node.end++;
    }

    public void delete(String str) {
        if (str == null || search(str) == 0) {
            return;
        }
        Node node = root;
        node.pass--;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.next[index].pass-- == 0) {
                node.next[index] = null;
                return;
            }
            node = node.next[index];
        }
        node.end--;
    }

    public int search(String str) {
        if (str == null) {
            return 0;
        }

        Node node = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }
}
