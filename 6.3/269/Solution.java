import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2))
                return "";
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            char curt = queue.poll();
            builder.append(curt);

            List<Character> neighbors = graph.get(curt);
            for (char c : neighbors) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }
        return builder.length() == indegree.size() ? builder.toString() : "";
    }
}