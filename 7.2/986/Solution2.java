import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]), high = Math.min(A[i][1], B[j][1]);
            if (low <= high) {
                list.add(new int[]{low, high});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}