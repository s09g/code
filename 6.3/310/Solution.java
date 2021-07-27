import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
            indegree.put(to, indegree.get(to) + 1);
            indegree.put(from, indegree.get(from) + 1);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int node : indegree.keySet()) {
            if (indegree.get(node) == 1) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            n -= size;
            if (n == 0) {
                return queue;
            }
            for (int i = 0; i < size; i++) {
                int curt = queue.poll();
                List<Integer> neighbors = graph.get(curt);
                for (int next : neighbors) {
                    indegree.put(next, indegree.get(next) - 1);
                    indegree.put(curt, indegree.get(curt) - 1);
                    if (indegree.get(next) == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return queue;
    }
}