import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int fib(int N) {
        if (N <= 1)     return N;
        if (map.containsKey(N))     return map.get(N);

        int res = fib(N - 1) + fib(N - 2);
        map.put(N, res);
        return res;
    }
}