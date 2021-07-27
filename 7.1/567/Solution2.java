import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())  return false;

        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            update(count, s1.charAt(i), -1);
            update(count, s2.charAt(i), 1);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (count.size() == 0)  return true;
            update(count, s2.charAt(i), 1);
            update(count, s2.charAt(i - s1.length()), -1);
        }
        return count.size() == 0;
    }

    private void update(HashMap<Character, Integer> map, char c, int update) {
        map.put(c, map.getOrDefault(c, 0) + update);
        if (map.get(c) == 0)
            map.remove(c);
    }
}