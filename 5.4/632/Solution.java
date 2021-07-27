import java.util.*;

class Solution {
    class Node {
        int x, y, value;
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.value = v;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.value - node2.value);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            heap.offer(new Node(i, 0, value));
            max = Math.max(value, max);
        }
        int[] ans = null;

        while (!heap.isEmpty()) {
            Node curt = heap.poll();

            if (ans == null || ans[1] - ans[0] > max - curt.value)
                ans = new int[]{curt.value, max};

            if (curt.y == nums.get(curt.x).size() - 1)  break;

            int value = nums.get(curt.x).get(curt.y + 1);
            heap.offer(new Node(curt.x, curt.y + 1, value));
            max = Math.max(value, max);
        }
        return ans;
    }
}