import java.util.*;

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curt = this.stack.pop();
        if (curt.right != null) {
            TreeNode root = curt.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return curt.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}