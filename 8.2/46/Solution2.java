import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList();

        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);

        dfs(list, ans, 0);
        return ans;
    }
    public void dfs(List<Integer> list, List<List<Integer>> ans, int idx) {
        if (idx == list.size())
            ans.add(new ArrayList<>(list));

        for (int i = idx; i < list.size(); i++) {
            Collections.swap(list, idx, i);
            dfs(list, ans, idx + 1);
            Collections.swap(list, idx, i);
        }
    }
}