class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int n_2 = 0, n_1 = 1;
        int count = 1;
        while (count < N) {
            int temp = n_1 + n_2;
            n_2 = n_1;
            n_1 = temp;
            count++;
        }
        return n_1;
    }
}