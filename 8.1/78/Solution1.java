import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int n : nums) {
            int size = ans.size();
            for (int i = 0 ; i < size; i++) {
                List<Integer> copy = new ArrayList<>(ans.get(i));
                copy.add(n);
                ans.add(copy);
            }
        }
        return ans;
    }
}