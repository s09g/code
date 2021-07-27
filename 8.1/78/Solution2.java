import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, res, ans);
        return ans;
    }

    void dfs(int[] nums, int idx, List<Integer> res, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[idx]);
        dfs(nums, idx + 1, res, ans);
        res.remove(res.size() - 1);
        dfs(nums, idx + 1, res, ans);
    }
}