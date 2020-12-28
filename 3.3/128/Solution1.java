import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        Arrays.sort(nums);
        int len = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) continue;

            if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            len = Math.max(len, count);
        }
        return len;
    }
}