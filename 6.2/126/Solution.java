import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);

        List<List<String>> ans = new ArrayList<>();
        if (!dict.contains(endWord))
            return ans;

        Map<Integer, Set<String>> map = new HashMap<>();
        int distance = bfs(beginWord, endWord, dict, map);

        if (distance == 0)  return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, distance - 1, map, path, ans);
        for (List<String> list : ans)
            Collections.reverse(list);
        return ans;
    }

    private void dfs(String curt, int distance, Map<Integer, Set<String>> map, List<String> path, List<List<String>> ans) {
        if (distance == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        Set<String> set = map.get(distance);
        List<String> neighbors = expanding(curt.toCharArray());
        for (String neighbor : neighbors) {
            if (set.contains(neighbor)) {
                path.add(neighbor);
                dfs(neighbor, distance - 1, map, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private int bfs(String beginWord, String endWord, Set<String> dict, Map<Integer, Set<String>> map) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            map.put(distance, new HashSet<>());
            for (int i = 0; i < size; i++) {
                String curt = queue.poll();
                map.get(distance).add(curt);
                if (curt.equals(endWord))
                    return distance;

                List<String> neighbors = expanding(curt.toCharArray());
                for (String neighbor : neighbors) {
                    if (dict.contains(neighbor) && !visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return 0;
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