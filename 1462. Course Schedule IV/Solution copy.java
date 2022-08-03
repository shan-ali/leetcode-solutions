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
        HashMap<Integer, List<Integer>> prereqGraph = new HashMap();

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
            // System.out.print(c + " : ");
            for (int p : graph.get(c)) {
                // System.out.print(p + ", ");
            }
            // System.out.println("");
        }

        // for each key in the graph, dfs to get all parent prereqs
        for (int c : graph.keySet()) {
            List<Integer> temp = new ArrayList();
            // add existing
            // temp.addAll(graph.get(c));
            prereqGraph.put(c, temp);
            traverse(c, c, graph, prereqGraph);
        }

        // System.out.println("");
        // System.out.println("");
        // System.out.println("");

        for (int c2 : prereqGraph.keySet()) {
            // System.out.print(c2 + " : ");
            for (int p2 : prereqGraph.get(c2)) {
                // System.out.print(p2 + ", ");
            }
            // System.out.println("");
        }

        for (int i = 0; i < queries.length; i++) {
            int course2 = queries[i][1];
            int prereq2 = queries[i][0];

            if (!prereqGraph.containsKey(course2)) {
                results.add(false);
            } else {
                if (prereqGraph.get(course2).contains(prereq2)) {
                    results.add(true);
                } else {
                    results.add(false);
                }
            }
        }

        return results;
    }

    public void traverse(int c, int index, HashMap<Integer, List<Integer>> graph,
            HashMap<Integer, List<Integer>> prereqGraph) {

        // System.out.println(c);

        for (int p : graph.get(c)) {
            if (prereqGraph.containsKey(index)) {
                if (!prereqGraph.get(index).contains(p)) {
                    // System.out.println("adding " + p);
                    prereqGraph.get(index).add(p);
                    if (graph.containsKey(p)) {
                        traverse(p, index, graph, prereqGraph);
                    }
                }
            }
        }
    }

}