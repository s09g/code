import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        helper(array, 0, array[0].length - 1, 0, array.length - 1, ans);
        return ans;
    }

    private void helper(int[][] array, int left, int right, int top, int down, List<Integer> ans) {
        if (left > right || top > down)
            return;

        for (int i = left; i <= right; i++)
            ans.add(array[top][i]);

        for (int i = top + 1; i <= down; i++)
            ans.add(array[i][right]);

        for (int i = right - 1; i >= left && top != down; i--)
            ans.add(array[down][i]);

        for (int i = down - 1; i > top && left != right; i--)
            ans.add(array[i][left]);

        helper(array, left + 1, right - 1, top + 1, down - 1, ans);
    }
}
