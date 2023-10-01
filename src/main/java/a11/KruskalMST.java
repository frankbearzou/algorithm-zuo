package a11;

import java.util.*;

public class KruskalMST {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    Map<Integer, Integer> parentMap = new HashMap<>();

    public List<Edge> kruskal(int V, List<Edge> edges) {
        List<Edge> ans = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);


        for (Edge edge : edges) {
            queue.offer(edge);
            parentMap.put(edge.src, edge.src);
            parentMap.put(edge.dest, edge.dest);
        }

        while (ans.size() < V - 1) {
            Edge edge = queue.poll();
            if (!isSameSet(edge.src, edge.dest)) {
                union(edge.src, edge.dest);
                ans.add(edge);
            }
        }

        return ans;
    }

    private boolean isSameSet(int a, int b) {
        return findParent(a) == findParent(b);
    }

    private void union(int a, int b) {
        if (isSameSet(a, b)) {
            return;
        }
        int parentA = findParent(a);
        int parentB = findParent(b);
        parentMap.put(parentB, parentA);
    }

    private int findParent(int a) {
        int cur = a;
        while (cur != parentMap.get(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void main(String[] args) {
        KruskalMST mst = new KruskalMST();
        List<Edge> edges = mst.kruskal(4, List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), new Edge(0, 3, 5), new Edge(1, 3, 15), new Edge(2, 3, 4)));
        for (Edge edge : edges) {
            System.out.println("from: " + edge.src + ", to: " + edge.dest + ", weight: " + edge.weight);
        }
    }
}
