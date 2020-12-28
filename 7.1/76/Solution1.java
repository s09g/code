import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, match = 0;
        int len = Integer.MAX_VALUE, start = 0;
        for (right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) == 0)
                    match++;
            }
            while (match == map.size()) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    if (map.get(l) == 0)
                        match--;
                    map.put(l, map.get(l) + 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}