class Solution {
    public int longestMountain(int[] A) {
        int ans = 0, end = 0;
        while (end < A.length) {
            int start = end;
            while (end + 1 < A.length && A[end] < A[end + 1])
                end++;

            int peak = end;
            while (end + 1 < A.length && A[end] > A[end + 1])
                end++;

            if (start < peak && peak < end )
                ans = Math.max(ans, end - start + 1);
            if (start == end)
                end++;
        }
        return ans;
    }
}