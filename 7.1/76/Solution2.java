import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int left = 0, matched = 0;
        int len = Integer.MAX_VALUE, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) >= 0)
                    matched++;
            }

            while (matched == t.length()) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    if (map.get(l) == 0)
                        matched--;
                    map.put(l, map.get(l) + 1);
                }
                left++;
            }
        }

        return len > s.length() ? "" : s.substring(start, start + len);
    }

}