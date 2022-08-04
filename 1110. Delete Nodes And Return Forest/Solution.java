import java.util.ArrayList;

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

    List<TreeNode> parentNodesToDelete = new ArrayList();
    List<TreeNode> answer = new ArrayList();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        // we can delete all leaf nodes without consequence
        // but if the parent becomes a leaf, and is also on the delete list, we need to
        // delete
        // keep track of all the parent nodes that are left for deletion
        // we will then add their children to the list
        // what about root?

        // remove all possible leaf nodes
        TreeNode rootNoLeaves = dfsRemoveLeaves(root, to_delete);

        // remove remaining parent nodes
        for (TreeNode node : parentNodesToDelete) {
            rootNoLeaves = dfsRemoveParents(rootNoLeaves, node.val);
        }

        if (rootNoLeaves != null) {
            answer.add(rootNoLeaves);
        }

        return answer;

    }

    public TreeNode dfsRemoveLeaves(TreeNode node, int[] to_delete) {

        boolean toDel = toDeleteNode(node.val, to_delete);
        if (toDel) {
            if (node.left == null && node.right == null) {
                return null;
            }
        }

        if (node.left != null) {
            node.left = dfsRemoveLeaves(node.left, to_delete);
        }

        if (node.right != null) {
            node.right = dfsRemoveLeaves(node.right, to_delete);
        }

        if (toDel) {
            if (node.left == null && node.right == null) {
                return null;
            } else {
                // mark as a parent node to delete
                parentNodesToDelete.add(node);
            }
        }

        return node;

    }

    public TreeNode dfsRemoveParents(TreeNode node, int val) {

        if (node.val == val) {
            if (node.left != null)
                answer.add(node.left);
            if (node.right != null)
                answer.add(node.right);
            return null;
        }

        if (node.left != null) {
            node.left = dfsRemoveParents(node.left, val);
        }

        if (node.right != null) {
            node.right = dfsRemoveParents(node.right, val);
        }

        return node;

    }

    public boolean toDeleteNode(int val, int[] to_delete) {
        // check list to see if nodes val is in it
        for (int d : to_delete) {
            if (d == val) {
                return true;
            }
        }

        return false;
    }
}