import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int minRoom = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(i -> i[1]));
        for (int[] i : intervals) {
            minHeap.offer(i);
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= i[0])
                minHeap.poll();
            minRoom = Math.max(minRoom, minHeap.size());
        }
        return minRoom;
    }
}