import java.util.*;

class Solution {
    public int smallestDifference(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int diff = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            if (Math.abs(arr1[i] - arr2[j]) < diff) {
                diff = Math.abs(arr1[i] - arr2[j]);
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return diff;
    }
}
