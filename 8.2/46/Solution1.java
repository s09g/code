import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], ans, res);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> ans, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            res.add(nums[i]);
            dfs(nums, visited, ans, res);
            res.remove(res.size() - 1);
            visited[i] = false;
        }
    }
}