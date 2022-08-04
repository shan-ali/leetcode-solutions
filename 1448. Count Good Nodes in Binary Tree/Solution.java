/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int count = 0;

    public int goodNodes(TreeNode root) {

        // basically check to make sure no node has a value greater than its parent
        // need a counter for any node that is >= the root
        // do a dfs to traverse the tree

        // counter for the good nodes

        dfsTree(root, root.val);

        return count;

    }

    public void dfsTree(TreeNode node, int x) {

        // edge cases
        if (node == null) {
            return;
        }

        // System.out.println(node.val);

        if (node.val >= x) {
            System.out.println("val: " + node.val);
            x = node.val;
            count++;
        }

        // traverse left side
        if (node.left != null) {
            dfsTree(node.left, x);
        }

        if (node.right != null) {
            dfsTree(node.right, x);
        }
    }
}