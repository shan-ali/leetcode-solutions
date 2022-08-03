
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            // if there is no tree then the given val becomes the new tree
            return new TreeNode(val);
        }

        traverseAdd(root, val);

        return root;

    }

    public void traverseAdd(TreeNode root, int val) {

        TreeNode valNode = new TreeNode(val);

        // found leaf node
        if (root.left == null && root.right == null) {

            if (val > root.val) {
                root.right = valNode;
            } else {
                root.left = valNode;
            }
            return;
        }

        if (val > root.val) {
            if (root.right == null) {
                // dont want to send null too the traversal, instead root.right will equal the
                // val
                root.right = valNode;
                return;
            } else {
                traverseAdd(root.right, val);
            }
        } else {
            if (root.left == null) {
                // dont want to send null too the traversal, instead root.right will equal the
                // val
                root.left = valNode;
                return;
            } else {
                traverseAdd(root.left, val);
            }
        }

    }
}