/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode last;
    public void flatten(TreeNode root) {
        if (root == null)   return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (last != null) {
            last.right = root;
            last.left = null;
        }
        last = root;

        flatten(left);
        flatten(right);
    }
}