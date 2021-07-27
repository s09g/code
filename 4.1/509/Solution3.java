class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] fibSeq = new int[N + 1];
        fibSeq[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibSeq[i] = fibSeq[i-1] + fibSeq[i-2];
        }
        return fibSeq[N];
    }
}