import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int start = 0, end = 1;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i != 0 && nums[i] == nums[i-1]) {
                start = end;
            }
            end = ans.size();
            for (int j = start; j < end; j++) {
                List<Integer> copy = new ArrayList<>(ans.get(j));
                copy.add(nums[i]);
                ans.add(copy);
            }
        }
        return ans;
    }
}