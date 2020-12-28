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
            top++;

            for (int i = top; i <= down; i++)
                ans.add(matrix[i][right]);
            right--;

            if (top > down || left > right)
                break;

            for (int i = right; i >= left; i--)
                ans.add(matrix[down][i]);
            down--;

            for (int i = down; i >= top; i--)
                ans.add(matrix[i][left]);
            left++;
        }

        return ans;
    }
}
