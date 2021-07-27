import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String from = equations.get(i).get(0), to = equations.get(i).get(1);
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, values[i]);

            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1.0 / values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }
        return ans;
    }

    private double dfs(String from, String to, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Double> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.offer(from);
        visited.add(from);
        map.put(from, 1.0);

        while (!queue.isEmpty()) {
            String curt = queue.poll();
            for (Map.Entry<String, Double> entry : graph.get(curt).entrySet()) {
                String next = entry.getKey();
                map.put(next, map.get(curt) * entry.getValue());
                if (next.equals(to)) {
                    return map.get(to);
                } else if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}