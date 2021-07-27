class Solution {
    public int fact(int n) {
        return fact(n, 1);
    }

    int fact(int n, int acc) {
        if (n == 1) {
            return acc;
        }
        return fact(n - 1, n * acc);
    }
}