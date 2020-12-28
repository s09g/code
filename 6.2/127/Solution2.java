import java.util.*;

class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end)) return 0;

        Queue<String> startQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();

        addWord(startQueue, startSet, start);
        addWord(endQueue, endSet, end);

        int step = 1;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            boolean forwarding = startQueue.size() <= endQueue.size();
            Queue<String> queue = forwarding ? startQueue : endQueue;
            Set<String> forward = forwarding ? startSet : endSet, backward = forwarding ? endSet : startSet;

            step++;
            int size = queue.size();
            while (size -- != 0){
                String curt = queue.poll();
                List<String> neighbors = expanding(curt.toCharArray());
                for (String neighbor : neighbors) {
                    if (!dict.contains(neighbor)) continue;
                    if (backward.contains(neighbor)) return step;
                    if (!forward.contains(neighbor)) addWord(queue, forward, neighbor);
                }
            }
        }
        return 0;
    }

    private void addWord(Queue<String> queue, Set<String> set, String word) {
        queue.offer(word);
        set.add(word);
    }

    private List<String> expanding(char[] word) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            char tmp = word[i];
            for (char j = 'a'; j <= 'z'; j++) {
                word[i] = j;
                neighbors.add(new String(word));
            }
            word[i] = tmp;
        }
        return neighbors;
    }
}