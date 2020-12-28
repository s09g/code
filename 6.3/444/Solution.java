import java.util.*;

class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int n : seq) {
                graph.putIfAbsent(n, new ArrayList<>());
                indegree.putIfAbsent(n, 0);
            }
        }

        if (indegree.size() != org.length) {
            return false;
        }

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int from = seq.get(i);
                int to = seq.get(i + 1);
                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int n : indegree.keySet()) {
            if (indegree.get(n) == 0) {
                queue.offer(n);
            }
        }

        int pos = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int curt = queue.poll();
            if (curt != org[pos++]) {
                return false;
            }
            List<Integer> neighbors = graph.get(curt);
            for (int next : neighbors) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return pos == org.length;
    }
}