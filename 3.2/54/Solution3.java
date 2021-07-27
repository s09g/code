import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        int left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;

        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);

            for (int i = top + 1; i <= down; i++)
                ans.add(matrix[i][right]);

            for (int i = right - 1; i >= left && top != down; i--)
                ans.add(matrix[down][i]);

            for (int i = down - 1; i > top && left != right; i--)
                ans.add(matrix[i][left]);

            top++;
            right--;
            down--;
            left++;
        }
        return ans;
    }
}
