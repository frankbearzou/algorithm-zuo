package a10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionSet {
    public static class Node {
        public int value;
        public Node(int value) {
            this.value = value;
        }
    }

    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Map<Node, Node> parentMap = new HashMap<>();
    private Map<Node, Integer> sizeMap = new HashMap<>();

    public UnionSet(List<Integer> list) {
        for (int val : list) {
            Node node = new Node(val);
            nodeMap.put(val, node);
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public boolean isSameSet(int a, int b) {
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)) {
            return false;
        }
        Node nodeA = nodeMap.get(a);
        Node nodeB = nodeMap.get(b);
        return findParent(nodeA) == findParent(nodeB);
    }

    public void union(int a, int b) {
        if (!nodeMap.containsKey(a) || !nodeMap.containsKey(b)) {
            return;
        }
        Node nodeA = nodeMap.get(a);
        Node nodeB = nodeMap.get(b);
        Node parentA = findParent(nodeA);
        Node parentB = findParent(nodeB);
        int sizeA = sizeMap.get(parentA);
        int sizeB = sizeMap.get(parentB);
        Node bigger = sizeA >= sizeB ? parentA : parentB;
        Node smaller = bigger == parentA ? parentB : parentA;
        parentMap.put(smaller, bigger);
        sizeMap.put(bigger, sizeA + sizeB);
        sizeMap.remove(smaller);
    }

    private Node findParent(Node node) {
        Stack<Node> stack = new Stack<>();
        Node cur = node;
        while (parentMap.get(cur) != cur) {
            stack.push(cur);
            cur = parentMap.get(cur);
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            parentMap.put(pop, cur);
        }
        return cur;
    }

    public static void main(String[] args) {
        UnionSet unionSet = new UnionSet(List.of(1,2,3,4,5,6,7));
        unionSet.union(1, 2);
        unionSet.union(1, 3);
        unionSet.union(4, 5);
        System.out.println(unionSet.isSameSet(1, 2));
        System.out.println(unionSet.isSameSet(1, 3));
        System.out.println(unionSet.isSameSet(2, 3));
        System.out.println(unionSet.isSameSet(5, 4));
        System.out.println(unionSet.isSameSet(1, 4));
        unionSet.union(3, 5);
        System.out.println(unionSet.isSameSet(2, 5));
    }
}
