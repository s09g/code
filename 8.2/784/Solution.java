import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(0, S, ans);
        return ans;
    }

    void dfs(int idx, String s, List<String> ans) {
        if (idx == s.length()) {
            ans.add(s);
            return;
        }
        dfs(idx + 1, s, ans);
        if (Character.isLetter(s.charAt(idx))) {
            char[] cs = s.toCharArray();
            cs[idx] = Character.isUpperCase(cs[idx]) ? Character.toLowerCase(cs[idx]) : Character.toUpperCase(cs[idx]);
            dfs(idx + 1, new String(cs), ans);
        }
    }
}