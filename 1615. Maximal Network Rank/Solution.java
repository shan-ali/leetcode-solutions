import java.util.HashMap;
import java.util.List;

class Solution {

    // https://leetcode.com/problems/maximal-network-rank/

    public int maximalNetworkRank(int n, int[][] roads) {

        // convert to hashmap
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < roads.length; i++) {
            int left = roads[i][0];
            for (int j = 1; j < roads[0].length; j++) {
                int right = roads[i][j];
                // e.g left, right --> 1,2 in roads
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

        // brute force get maximum
        // could also get the two largests lists
        int maxRank = 0;
        String maxRankCities = "";

        for (int city : graph.keySet()) {
            for (int city2 : graph.keySet()) {
                // skip self
                if (city == city2) {
                    continue;
                }

                int rank = graph.get(city).size() + graph.get(city2).size();

                if (graph.get(city).contains(city2)) {
                    rank--;
                }

                if (rank > maxRank) {
                    maxRank = rank;
                    maxRankCities = city + "," + city2;
                }
            }
        }

        // System.out.println(maxRankCities);
        return maxRank;
    }
}