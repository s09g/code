import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        int left = 0, right = array[0].length - 1, top = 0, down = array.length - 1;
        helper(array, left, right, top, down, ans);
        return ans;
    }

    private static void helper(int[][] array, int left, int right, int top, int down, List<Integer> ans) {
        if (left > right || top > down)
            return;

        if (left == right) {
            for (int i = top; i <= down; i++)
                ans.add(array[i][left]);
            return;
        }

        if (top == down) {
            for (int i = left; i <= right; i++)
                ans.add(array[top][i]);
            return;
        }

        for (int i = left; i <= right; i++)
            ans.add(array[top][i]);
        top++;

        for (int i = top; i <= down; i++)
            ans.add(array[i][right]);
        right--;

        for (int i = right; i >= left; i--)
            ans.add(array[down][i]);
        down--;

        for (int i = down; i >= top; i--)
            ans.add(array[i][left]);
        left++;

        helper(array, left, right, top, down, ans);
    }
}
