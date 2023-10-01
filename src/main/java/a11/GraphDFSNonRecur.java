package a11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDFSNonRecur {
    private int V;
    private ArrayList<Integer> adj[];
    private boolean[] visited;

    public GraphDFSNonRecur(int v) {
        V = v;
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
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        visited[s] = true;
        System.out.print(s + " ");
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(cur);
                    stack.push(next);
                    System.out.print(next + " ");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphDFSNonRecur graphDFSNonRecur = new GraphDFSNonRecur(5);
        graphDFSNonRecur.addEdge(0, 1);
        graphDFSNonRecur.addEdge(0, 2);
        graphDFSNonRecur.addEdge(0, 3);
        graphDFSNonRecur.addEdge(1, 0);
        graphDFSNonRecur.addEdge(2, 0);
        graphDFSNonRecur.addEdge(2, 3);
        graphDFSNonRecur.addEdge(2, 4);
        graphDFSNonRecur.addEdge(3, 0);
        graphDFSNonRecur.addEdge(3, 2);
        graphDFSNonRecur.addEdge(4, 2);
        graphDFSNonRecur.DFS(0);
    }
}
