import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());

            if (i - k + 1 >= 0) {
                ans[i - k + 1] = maxHeap.size() == minHeap.size() ?
                        (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0) : maxHeap.peek();

                int last = nums[i - k + 1];
                if (last <= maxHeap.peek())
                    maxHeap.remove(last);
                else
                    minHeap.remove(last);

                if (minHeap.size() > maxHeap.size())
                    maxHeap.offer(minHeap.poll());
            }
        }
        return ans;
    }
}