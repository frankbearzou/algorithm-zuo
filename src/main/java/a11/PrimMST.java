package a11;

import java.util.*;

public class PrimMST {
    public static class Edge {
        String from;
        String to;
        int weight;
        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public List<Edge> prim(Map<String, List<Edge>> edges, String startNode) {
        Set<String> nodeSet = new HashSet<>();
        List<Edge> ans = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        nodeSet.add(startNode);
        for (Edge edge : edges.get(startNode)) {
            queue.offer(edge);
        }

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            String to = edge.to;
            if (!nodeSet.contains(to)) {
                nodeSet.add(to);
                ans.add(edge);
                for (Edge e : edges.get(to)) {
                    if (!nodeSet.contains(e.to)) {
                        queue.offer(e);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        PrimMST mst = new PrimMST();
        Map<String, List<Edge>> map = Map.of("a", List.of(new Edge("b", 8), new Edge("c", 1), new Edge("d", 15)),
                "b", List.of(new Edge("a", 8), new Edge("c", 2), new Edge("e", 10)),
                "c", List.of(new Edge("a", 1), new Edge("b", 2), new Edge("d", 7), new Edge("e", 3), new Edge("f", 12)),
                "d", List.of(new Edge("a", 15), new Edge("c", 7), new Edge("f", 3)),
                "e", List.of(new Edge("b", 10), new Edge("c", 3), new Edge("f", 4)),
                "f", List.of(new Edge("c", 12), new Edge("d", 3), new Edge("e", 4)));
        List<Edge> edges = mst.prim(map, "a");
        for (Edge edge : edges) {
            System.out.println("to: " + edge.to + ", weight: " + edge.weight);
        }
    }
}
