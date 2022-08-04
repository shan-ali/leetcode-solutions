import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> allPerm = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> numsList = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();

        for (int n : nums) {
            numsList.add(n);
        }

        recurse(numsList, emptyList);

        return allPerm;
    }

    public void recurse(List<Integer> decisions, List<Integer> permutation) {

        if (decisions.size() == 0) {
            // deep copy
            allPerm.add(new ArrayList<Integer>(permutation));
        }

        for (int i = 0; i < decisions.size(); i++) {
            // find all remaining decisions excluding i
            List<Integer> left = decisions.subList(0, i);
            List<Integer> right = decisions.subList(i + 1, decisions.size());
            List<Integer> remaining = new ArrayList();
            remaining.addAll(left);
            remaining.addAll(right);

            permutation.add(decisions.get(i));

            recurse(remaining, permutation);

            // need to remove what we just added
            permutation.remove(decisions.get(i));
        }
    }
}