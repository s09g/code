class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] fibSeq = new int[2];
        fibSeq[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibSeq[i % 2] += fibSeq[(i-1) % 2];
        }
        return fibSeq[N % 2];
    }
}