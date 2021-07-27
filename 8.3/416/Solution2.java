class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        int len = nums.length;
        boolean[][] dp = new boolean[2][sum + 1];
        dp[0][0] = true;
        dp[1][0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= nums[i]) {
                    dp[i % 2][j] = dp[i % 2][j] || dp[(i - 1) % 2][j - nums[i]];
                }
            }
        }
        return dp[(len - 1) % 2][sum];
    }
}