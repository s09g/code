import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, res, ans);
        return ans;
    }

    void dfs(int[] nums, int idx, List<Integer> res, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(res));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i-1]) {
                continue;
            }
            res.add(nums[i]);
            dfs(nums, i + 1, res, ans);
            res.remove(res.size() - 1);
        }
    }
}