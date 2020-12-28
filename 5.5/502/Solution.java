import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Integer> minCapHeap = new PriorityQueue<>((n1, n2) -> Capital[n1] - Capital[n2]);
        PriorityQueue<Integer> maxProHeap = new PriorityQueue<>((n1, n2) -> Profits[n2] - Profits[n1]);

        for (int i = 0; i < Capital.length; i++) {
            minCapHeap.offer(i);
        }

        int cap = W;
        for (int i = 0; i < k; i++) {
            while (!minCapHeap.isEmpty() && Capital[minCapHeap.peek()] <= cap) {
                maxProHeap.offer(minCapHeap.poll());
            }

            if (!maxProHeap.isEmpty()) {
                cap += Profits[maxProHeap.poll()];
            }
        }
        return cap;
    }
}