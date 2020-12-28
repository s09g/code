import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : intervals) {
            if (!list.isEmpty() && list.getLast()[1] >= i[0]) {
                list.getLast()[1] = Math.max(i[1], list.getLast()[1]);
            } else {
                list.add(i);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
