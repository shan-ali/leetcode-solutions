import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> ancestorList = new ArrayList<>();

        // build reverse hashmap
        // i.e edge [1,2] maps to 2 : [1]
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int anscestor = edges[i][0];
            int child = edges[i][1];

            if (graph.containsKey(child)) {
                graph.get(child).add(anscestor);
            } else {
                List<Integer> tempAnscestorsList = new ArrayList<>();
                tempAnscestorsList.add(anscestor);
                graph.put(child, tempAnscestorsList);
            }
        }

        // loop through each node and get its anscestors
        for (int i = 0; i < n; i++) {
            // if no ancestors, add empty list
            if (graph.get(i) == null) {
                List<Integer> tempAnscestorsList = new ArrayList<>();
                ancestorList.add(tempAnscestorsList);
            } else {
                // need to keep track of what was visited so we dont add it to the list again
                // (if there are multiple paths)
                // need to use an array like this since it is a o(1) look up **** dont use
                // .contains() :)
                boolean visited[] = new boolean[n];
                List<Integer> unsortedAncestorList = new ArrayList<>();

                for (int ancestor : graph.get(i)) {
                    traverseAncestors(ancestor, graph, unsortedAncestorList, visited);
                }

                Collections.sort(unsortedAncestorList);
                ancestorList.add(unsortedAncestorList);
            }
        }

        return ancestorList;
    }

    public void traverseAncestors(int ancestor, HashMap<Integer, List<Integer>> graph,
            List<Integer> unsortedAncestorList, boolean visited[]) {
        // add the ancestor to the list

        if (visited[ancestor]) {
            return;
        }

        unsortedAncestorList.add(ancestor);
        visited[ancestor] = true;

        if (graph.get(ancestor) == null) {
            return;
        } else {
            for (int a : graph.get(ancestor)) {
                if (!visited[a]) {
                    traverseAncestors(a, graph, unsortedAncestorList, visited);
                }
            }
        }
    }
}