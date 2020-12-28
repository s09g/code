import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        int len = 0;
        for (int n : nums) {
            if (!set.contains(n)) continue;

            set.remove(n);
            int left = n - 1, right = n + 1;
            while (set.contains(left))  set.remove(left--);
            while (set.contains(right)) set.remove(right++);

            len = Math.max(right - left - 1, len);
        }
        return len;
    }
}