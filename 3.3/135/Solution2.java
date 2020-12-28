class Solution {
    public int candy(int[] ratings) {
        if (ratings.length < 2){
            return ratings.length;
        }
        int end = 0;
        int[] ans = new int[ratings.length];

        while (end < ratings.length) {
            int start = end;
            while (end + 1 < ratings.length && ratings[end] > ratings[end + 1])
                end++;

            int peak = end;
            while (end + 1 < ratings.length && ratings[end] < ratings[end + 1])
                end++;

            ans[peak] = Math.max(ans[peak], 1);

            for (int i = peak - 1; i >= start; i--)
                ans[i] = Math.max(ans[i], ans[i + 1]+1);

            for (int i = peak+1; i <= end; i++)
                ans[i] = ans[i-1] + 1;

            if (start == end) {
                end++;
            }
        }

        int sum = 0;
        for (int n : ans) {
            sum+= n;
        }
        return sum;
    }
}
