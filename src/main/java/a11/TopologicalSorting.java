package a11;

import java.util.*;

public class TopologicalSorting {
    public List<String> topologicalSort(Map<String, String[]> digraph) {
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> zeroInDegree = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        // init in-degree
        for (var entry : digraph.entrySet()) {
            inDegree.put(entry.getKey(), 0);
        }

        // init neighbor
        for (var entry : digraph.entrySet()) {
            for (String neighbor : entry.getValue()) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        // init zero in-degree
        for (var entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                zeroInDegree.offer(entry.getKey());
            }
        }

        while (!zeroInDegree.isEmpty()) {
            String node = zeroInDegree.poll();
            ans.add(node);
            for (String neighbor : digraph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    zeroInDegree.offer(neighbor);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TopologicalSorting topologicalSorting = new TopologicalSorting();
        List<String> sort = topologicalSorting.topologicalSort(Map.of("B", new String[]{"E", "C"}, "E", new String[]{"A", "C"},
                "C", new String[]{}, "A", new String[]{"C", "D"}, "D", new String[]{}));
        System.out.println(sort);
    }
}
