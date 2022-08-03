import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.html.HTMLDocument.RunElement;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        // boolean[] results = new boolean[queries.length];
        List<Boolean> results = new ArrayList<>();

        // convert prereqs to hashtable/graph

        HashMap<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int prereq = prerequisites[i][0];

            // add in reverse order -> key should be course and value is a list of prereqs

            if (graph.containsKey(course)) {
                // add to the existing list
                graph.get(course).add(prereq);
            } else {
                List<Integer> prereqList = new ArrayList<>();
                prereqList.add(prereq);
                graph.put(course, prereqList);
            }

        }

        for (int c : graph.keySet()) {
            System.out.print(c + " : ");
            for (int p : graph.get(c)) {
                System.out.print(p + ", ");
            }
            System.out.println("");
        }

        // now we can just loop through all of the queries and easily check if the
        // prereq is true or false

        for (int j = 0; j < queries.length; j++) {
            int course = queries[j][1];
            int prereq = queries[j][0];

            System.out.println("checking if " + prereq + " is a prereq for " + course);

            boolean[] visited = new boolean[numCourses];

            if (!graph.containsKey(course)) {
                results.add(false);
            } else {
                traverse(course, prereq, graph, visited, results);
            }
        }

        return results;

    }

    public void traverse(int course, int prereq, HashMap<Integer, List<Integer>> graph, boolean[] visited,
            List<Boolean> results) {

        System.out.println("  traversing " + course);

        for (int p : graph.get(course)) {
            if (visited[p] == false) {
                visited[p] = true;
                if (p == prereq) {
                    System.out.println("     found " + p);
                    results.add(true);
                    return;
                } else {
                    if (graph.containsKey(p)) {
                        traverse(p, prereq, graph, visited, results);
                    }
                }
            } else {
                System.out.println("    " + p + "is already visited");
                results.add(false);
            }
        }
    }
}