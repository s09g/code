import java.util.*;

class Solution {
    Map<String, String> father = new HashMap<>();
    Map<String, Double> weight = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);

            putIfAbsent(s1);
            putIfAbsent(s2);

            String root1 = find(s1);
            String root2 = find(s2);

            father.put(root1, root2);
            weight.put(root1, weight.get(s2) * values[i] / weight.get(s1));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            if (!father.containsKey(s1) || !father.containsKey(s2) || !find(s1).equals(find(s2)))
                res[i] = -1.0;
            else
                res[i] = weight.get(s1) / weight.get(s2);
        }
        return res;
    }

    private void putIfAbsent(String s) {
        father.putIfAbsent(s, s);
        weight.putIfAbsent(s, 1.0);
    }

    private String find(String s) {
        if (father.get(s).equals(s)) {
            return s;
        }

        String prev = father.get(s);
        String p = find(father.get(s));
        father.put(s, p);
        weight.put(s, weight.get(prev) * weight.get(s));
        return p;
    }
}