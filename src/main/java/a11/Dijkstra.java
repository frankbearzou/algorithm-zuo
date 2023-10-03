package a11;

import java.util.*;

public class Dijkstra {
    public static class Node {
        public String V;
        public List<Edge> edges;
        public Node(String v) {
            V = v;
        }
    }

    public static class Edge {
        public Node to;
        public int weight;
        public Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public Map<Node, Integer> dijkstra(Node head) {
        Map<Node, Integer> distanceMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getMinNode(distanceMap, visited);

        while (minNode != null) {
            for (Edge adj : minNode.edges) {
                Integer distance = distanceMap.get(minNode);
                Node to = adj.to;
                if (!distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance + adj.weight);
                } else {
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + adj.weight));
                }
            }
            visited.add(minNode);
            minNode = getMinNode(distanceMap, visited);
        }

        return distanceMap;
    }

    private Node getMinNode(Map<Node, Integer> distanceMap, Set<Node> visited) {
        int minDistance = Integer.MAX_VALUE;
        Node minNode = null;
        for (var entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!visited.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        A.edges = List.of(new Edge(D, 6), new Edge(C, 7), new Edge(B, 1));
        B.edges = List.of(new Edge(C, 2), new Edge(E, 170));
        C.edges = List.of(new Edge(D, 2), new Edge(E, 23));
        D.edges = List.of(new Edge(E, 4));
        E.edges = List.of();

        Dijkstra dijkstra = new Dijkstra();
        Map<Node, Integer> map = dijkstra.dijkstra(A);
        System.out.println(map);
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey().V + ": " + entry.getValue());
        }
    }
}
