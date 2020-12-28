import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        addWord(queue, visited, beginWord);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curt = queue.poll();
                if (curt.equals(endWord))
                    return step;

                List<String> neighbors = expanding(curt.toCharArray());
                for (String neighbor : neighbors) {
                    if (words.contains(neighbor) && !visited.contains(neighbor)) {
                        addWord(queue, visited, neighbor);
                    }
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