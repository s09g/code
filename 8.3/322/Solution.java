import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int MAX = amount + 1;
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c: coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}