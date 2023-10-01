package a11;

import java.util.ArrayList;

public class GraphDFS {
    private int V;
    private ArrayList<Integer> adj[];
    private boolean[] visited;

    public GraphDFS(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[v];
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFS(int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : adj[s]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS(5);
        graphDFS.addEdge(0, 1);
        graphDFS.addEdge(0, 2);
        graphDFS.addEdge(0, 3);
        graphDFS.addEdge(1, 0);
        graphDFS.addEdge(2, 0);
        graphDFS.addEdge(2, 3);
        graphDFS.addEdge(2, 4);
        graphDFS.addEdge(3, 0);
        graphDFS.addEdge(3, 2);
        graphDFS.addEdge(4, 2);
        graphDFS.DFS(0);
    }
}
