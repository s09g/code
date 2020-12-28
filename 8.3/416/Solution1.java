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
        boolean[][] dp = new boolean[len][sum + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] |= dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][sum];
    }
}