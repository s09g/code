import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        for (right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            count.put(r, count.getOrDefault(r, 0) + 1);
            while (count.size() > k) {
                char l = s.charAt(left);
                count.put(l, count.get(l) - 1);
                if (count.get(l) == 0)
                    count.remove(l);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}