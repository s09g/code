import java.util.*;

class Solution {
    class Node {
        int row, col, value;
        Node(int r, int c, int v) {
            row = r;
            col = c;
            value = v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.value - node2.value);
        for (int i = 0; i < n; i++) {
            heap.offer(new Node(i, 0, matrix[i][0]));
        }

        for (int i = 0; i < k - 1; i++) {
            Node curt = heap.poll();
            if (curt.col == n - 1) {
                continue;
            }
            heap.offer(new Node(curt.row, curt.col + 1, matrix[curt.row][curt.col + 1]));
        }
        return heap.peek().value;
    }
}