import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> treeAsSortedArr = new ArrayList();
        traverse(root, treeAsSortedArr);

        // for (int i : treeAsSortedArr) {
        // System.out.print(i + ", ");
        // }

        return treeAsSortedArr.get(k - 1);

    }

    public void traverse(TreeNode root, ArrayList<Integer> treeAsSortedArr) {

        if (root.left != null) {
            traverse(root.left, treeAsSortedArr);
        }
        treeAsSortedArr.add(root.val);

        if (root.right != null) {
            traverse(root.right, treeAsSortedArr);
        }

    }
}