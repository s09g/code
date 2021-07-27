import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>((n1, n2) -> intervals[n2][0] - intervals[n1][0]);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>((n1, n2) -> intervals[n2][1] - intervals[n1][1]);

        for (int i = 0; i < n; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        while (!maxEndHeap.isEmpty()) {
            int latestEnd = maxEndHeap.poll();
            int end = intervals[latestEnd][1];

            if (intervals[maxStartHeap.peek()][0] < end) {
                ans[latestEnd] = -1;
                continue;
            }

            int next = maxStartHeap.poll();
            while (!maxStartHeap.isEmpty() && end <= intervals[maxStartHeap.peek()][0]) {
                next = maxStartHeap.poll();
            }

            ans[latestEnd] = next;
            maxStartHeap.offer(next);
        }
        return ans;
    }
}
