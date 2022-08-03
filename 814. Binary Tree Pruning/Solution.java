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
    public TreeNode pruneTree(TreeNode root) {

        // DFS to each leaf node, check if 0 and delete
        // after deletion, if parent is now leaf and 0, need to also delete

        return dfsPrune(root);

    }

    public TreeNode dfsPrune(TreeNode node) {

        if (node == null)
            return null;

        if (node.left == null && node.right == null && node.val == 0) {
            // found leaf node that hava value 0
            // return null to delete the node
            return null;
        }

        if (node.left != null) {
            node.left = dfsPrune(node.left);
        }

        if (node.right != null) {
            node.right = dfsPrune(node.right);
        }

        // need to check one more time if the current node is a leaf node, since it may
        // have become one
        if (node.left == null && node.right == null && node.val == 0) {
            // found leaf node that hava value 0
            // return null to delete the node
            return null;
        }

        return node;

    }
}