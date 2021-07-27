import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((p1, p2) -> (p2.get(0) + p2.get(1)) - (p1.get(0) + p1.get(1)));

        for (int m : nums1) {
            for (int n : nums2) {
                maxHeap.offer(Arrays.asList(m, n));
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}