class Solution {
    public int countNodes(TreeNode root) {
        int max = 1;
        while (exist(root, max)) {
            max *= 2;
        }
        int min = 0;
        while (min + 1 < max) {
            int mid = min + (max - min) / 2;
            if (exist(root, mid)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return exist(root, max) ? max : min;
    }

    boolean exist(TreeNode root, int num) {
        for (int pivot = Integer.highestOneBit(num) / 2; pivot != 0; pivot /= 2) {
            if (root == null)
                return false;

            root = (num & pivot) == 0 ? root.left : root.right;
        }
        return root != null;
    }
}