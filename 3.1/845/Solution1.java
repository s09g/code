class Solution {
    public int longestMountain(int[] A) {
        int[] leftPeak = leftToRight(A);
        int[] rightPeak = RightToLeft(A);
        int longest = 0;
        for (int i = 0; i < A.length; i++) {
            if (leftPeak[i] == 0 || rightPeak[i] == 0) {
                continue;
            }
            longest = Math.max(longest, leftPeak[i] + rightPeak[i] + 1);
        }
        return longest;
    }

    private int[] leftToRight(int[] array) {
        int[] ans = new int[array.length];
        for (int i = 1; i < ans.length; i++) {
            if (array[i] > array[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }

    private int[] RightToLeft(int[] array) {
        int[] ans = new int[array.length];
        for (int i = ans.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                ans[i] = ans[i + 1] + 1;
            }
        }
        return ans;
    }
}
