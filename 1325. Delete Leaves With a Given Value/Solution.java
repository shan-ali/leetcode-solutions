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
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        // delete all occurences of target in the tree that are leaf nodes
        // after deleting you need to check if the parent is a leaf -> then delete
        // DFS traverse until you reach leaf nodes, check if the value is target and
        // delete
        // recursion should handle the parent nodes

        return dfsDelete(root, target);

    }

    public TreeNode dfsDelete(TreeNode root, int target) {

        if (root == null)
            return root;

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        if (root.left != null) {
            root.left = dfsDelete(root.left, target);
        }

        if (root.right != null) {
            root.right = dfsDelete(root.right, target);
        }

        // need to check the target again since it may have become a leaf node
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}
