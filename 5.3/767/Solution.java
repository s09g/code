import java.util.*;

class Solution {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() != e2.getValue()) {
                return e2.getValue() - e1.getValue();
            }
            return e1.getKey() - e2.getKey();
        });

        heap.addAll(count.entrySet());

        Map.Entry<Character, Integer> prev = null;
        StringBuilder builder = new StringBuilder();
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> curt = heap.poll();
            if (prev != null && prev.getValue() > 0) {
                heap.offer(prev);
            }
            builder.append(curt.getKey());
            curt.setValue(curt.getValue() - 1);
            prev = curt;
        }
        return builder.length() == S.length() ? builder.toString() : "";
    }
}