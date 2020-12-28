import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        heap.addAll(count.keySet());


        while (!heap.isEmpty() && k >= count.get(heap.peek())) {
            k -= count.get(heap.poll());
        }
        return heap.size();
    }
}