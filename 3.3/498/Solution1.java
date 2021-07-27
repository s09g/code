import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int m = matrix[0].length;

        int[] res = new int[n*m];
        int k = 0;

        for (int i = 0; i < n + m - 1; i++) {
            int r = i < m ? 0 : i - m + 1;
            int c = i < m ? i : m - 1;

            ArrayList<Integer> line = new ArrayList<>();
            while (r < n && c >= 0)
                line.add(matrix[r++][c--]);

            if (i % 2 == 0)
                Collections.reverse(line);
            for (int j = 0; j < line.size(); j++)
                res[k++] = line.get(j);
        }
        return res;
    }
}