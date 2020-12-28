class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}