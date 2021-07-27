import java.util.*;

class Solution {
    public TreeNode rightSiblingTree(TreeNode root) {
        if (root == null)	return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curt = queue.poll();
                if (curt == null) continue;
                queue.offer(curt.left);
                queue.offer(curt.right);
                curt.right = i != size - 1 ? queue.peek() : null;
            }
        }

        return root;
    }
}
