import java.util.*;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        dfs(word, 0, "", 0, ans);
        return ans;
    }

    private void dfs(String word, int idx, String curt, int count, List<String> ans) {
        if (idx == word.length()) {
            if (count != 0)
                curt = curt + count;
            ans.add(curt);
            return;
        }

        dfs(word, idx + 1, curt, count + 1, ans);

        if (count != 0)
            curt += count;
        dfs(word, idx + 1, curt + word.charAt(idx), 0, ans);
    }
}