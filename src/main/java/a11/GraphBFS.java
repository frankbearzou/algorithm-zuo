package a11;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private int V;
    private LinkedList[] adj;

    public GraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int i = 0; i < adj[vertex].size(); i++) {
                int o = (int)adj[vertex].get(i);
                if (!visited[o]) {
                    visited[o] = true;
                    queue.offer(o);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graphBFS = new GraphBFS(5);
        graphBFS.addEdge(0, 1);
        graphBFS.addEdge(0, 2);
        graphBFS.addEdge(1, 0);
        graphBFS.addEdge(1, 2);
        graphBFS.addEdge(1, 3);
        graphBFS.addEdge(2, 0);
        graphBFS.addEdge(2, 1);
        graphBFS.addEdge(2, 4);
        graphBFS.addEdge(3, 1);
        graphBFS.addEdge(3, 4);
        graphBFS.addEdge(4, 2);
        graphBFS.addEdge(4, 3);
        graphBFS.BFS(0);
    }
}
