import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {

        // convert to hashmap
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int left = edges[i][0];

            for (int j = 1; j < edges[0].length; j++) {

                int right = edges[i][j];

                // e.g left, right --> 1,2 in edges

                if (graph.containsKey(left)) {
                    graph.get(left).add(right);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(right);
                    graph.put(left, temp);
                }

                if (graph.containsKey(right)) {
                    graph.get(right).add(left);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    graph.put(right, temp);
                }
            }
        }

        // find a key where its values is equal to n-1
        for (int k : graph.keySet()) {
            if (graph.get(k).size() == graph.size() - 1) {
                return k;
            }
        }

        // for (int k : graph.keySet()) {
        // System.out.print(k + " : ");
        // for (int v : graph.get(k)) {
        // System.out.print(" " + v);
        // }
        // System.out.println("");
        // }

        return 0;
    }

    // public static void main(String[] args) {
    // int[][] edges = "[[1,2],[2,3],[4,2]]";
    // int[][] edges = new int[4][4];
    // findCenter(edges);
    // }

}