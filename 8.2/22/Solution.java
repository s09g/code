import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, "", ans);
        return ans;
    }

    private void dfs(int left, int right, int max, String curt, List<String> ans) {
        if (left == max && right == max) {
            ans.add(curt);
            return;
        }

        if (left > right) {
            dfs(left, right + 1, max, curt + ")", ans);
        }
        if (left < max) {
            dfs(left + 1, right, max, curt + "(", ans);
        }
    }
}