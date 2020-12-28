import java.util.*;

class Solution {
    public int weightedSum(List<Object> array) {
        return weightedSumHelper(array, 1);
    }

    int weightedSumHelper(List<Object> array, int depth) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof ArrayList) {
                List<Object> list = (ArrayList<Object>) obj;
                sum += weightedSumHelper(list, depth + 1);
            } else {
                sum += (int)obj * depth;
            }
        }
        return sum;
    }
}
