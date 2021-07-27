import java.util.*;

class Solution {
    public int[] towSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) { // O(N)
            int potentialMatch = target - num;
            if (set.contains(potentialMatch)) { // O(1)
                return new int[]{potentialMatch, num};
            } else {
                set.add(num); // 空间消耗增加O(1)
            }
        }
        return new int[0];
    }
}