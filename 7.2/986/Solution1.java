import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (overlap(A[i], B[j]))
                list.add(intersect(A[i], B[j]));

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private boolean overlap(int[] a, int[] b) {
        return a[0] < b[0] ? a[1] >= b[0] : overlap(b, a);
    }

    private int[] intersect(int[] a, int[] b) {
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}