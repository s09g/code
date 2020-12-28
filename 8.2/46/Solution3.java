import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<>());
        for (int n : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> permutation = queue.poll();
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> copy = new LinkedList<>(permutation);
                    copy.add(j, n);
                    if (copy.size() == nums.length) {
                        res.add(copy);
                    } else {
                        queue.offer(copy);
                    }
                }
            }
        }
        return res;
    }
}