import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> line = new ArrayList<>();

            int r = 0;
            int c = i;

            while (r < n && c >= 0)
                line.add(matrix[r++][c--]);

            ans.add(line);
        }

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> line = new ArrayList<>();

            int r = i;
            int c = m - 1;

            while (r < n && c >= 0)
                line.add(matrix[r++][c--]);

            ans.add(line);
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(ans.get(i));
            }
        }

        int[] res = new int[n*m];
        int i = 0;
        for (List<Integer> line : ans) {
            for (int num : line) {
                res[i++] = num;
            }
        }

        return res;
    }
}