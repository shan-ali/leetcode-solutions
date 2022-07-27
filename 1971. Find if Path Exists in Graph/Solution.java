import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    // https://leetcode.com/problems/find-if-path-exists-in-graph/

    boolean found = false;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        // convert to hashmap
        for (int i = 0; i < edges.length; i++) {
            int k = edges[i][0];
            int v = edges[i][1];

            if (graph.containsKey(k)) {
                graph.get(k).add(v);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(v);
                graph.put(k, temp);
            }

            if (graph.containsKey(v)) {
                graph.get(v).add(k);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(k);
                graph.put(v, temp);
            }
        }

        // given source, we just need to traverse using DFS until we hit destination
        traverse(source, destination, graph, visited);

        return found;

    }

    public void traverse(int source, int destination, HashMap<Integer, List<Integer>> graph,
            HashSet<Integer> visited) {
        // if source = destination, then we have found the destination
        if (source == destination) {
            found = true;
            return;
        }

        // if we have visited this node already, skip
        if (visited.contains(source)) {
            return;
        }

        visited.add(source);

        for (int neighbors : graph.get(source)) {
            traverse(neighbors, destination, graph, visited);
        }

        return;
    }
}