class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.right) + countNodes(root.left) + 1;
    }
}