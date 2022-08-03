import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // rooms[i] is a list of rooms that you have access to
        // this is a graph problem where each room is connected via the keys
        // mark visited
        // directed graph
        // only do DFS on room 0

        boolean[] visited = new boolean[rooms.size()];

        // build hashmap to represent the graph
        HashMap<Integer, List<Integer>> graph = new HashMap();
        // loop through each room
        for (int i = 0; i < rooms.size(); i++) {
            // loop through each key and add as a value to the hashmap with key as room
            for (int j = 0; j < rooms.get(i).size(); j++) {
                if (!graph.containsKey(i)) {
                    List<Integer> keyList = new ArrayList();
                    keyList.add(rooms.get(i).get(j));
                    graph.put(i, keyList);
                } else {
                    graph.get(i).add(rooms.get(i).get(j));
                }
            }
        }

        // for (int key : graph.keySet()) {
        // System.out.print(key + " : ");
        // for (int val : graph.get(key)) {
        // System.out.print(val + ", ");
        // }
        // System.out.println("");
        // }
        // System.out.println("");

        // only DFS on room 0, since we can only start from there
        dfsRooms(0, graph, visited);

        for (boolean wasVisited : visited) {
            if (wasVisited == false) {
                return false;
            }
        }

        return true;

    }

    public void dfsRooms(int room, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        // dfs and mark visited
        // for each key in the room, traverse it

        // System.out.println("room: " + room);
        // System.out.println("visited status: " + visited[room]);

        if (!visited[room]) {
            visited[room] = true;
            if (graph.containsKey(room)) {
                for (int key : graph.get(room)) {
                    dfsRooms(key, graph, visited);
                }
            }

        }
    }
}