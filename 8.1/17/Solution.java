import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        dfs(0, "", digits, board, ans);
        return ans;
    }

    private void dfs(int idx, String curt, String digits, String[] board, List<String> ans){
        if (idx == digits.length()) {
            ans.add(curt);
            return;
        }
        int d = digits.charAt(idx) - '0';
        for (char c : board[d].toCharArray()) {
            dfs(idx + 1, curt + c, digits, board, ans);
        }
    }
}