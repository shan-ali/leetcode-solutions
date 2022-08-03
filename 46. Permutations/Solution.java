import java.util.*;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList();
        recurse();
        return answer;

    }

    public static void recurse(int[] nums, int index, List<Integer> current, List<List<Integer>> answer) {
        if (index == nums.length) {
            answer.add(current);
        } else {
            for (int i = 0; i < current.size(); i++) {
                List<Integer> temp = new ArrayList();
                temp.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[3] = 3;
        permute(nums);
    }
}