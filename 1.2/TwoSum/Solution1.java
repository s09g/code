import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) { // O(N)
            int firstNum = nums[i]; // 确定第一个可能的数字
            for (int j = i + 1; j < nums.length; j++) { // O(N)
                int secondNum = nums[j]; // 确定第二个可能的数字
                if (firstNum + secondNum == target) {
                    return new int[]{firstNum, secondNum};
                }
            }
        }
        return new int[0];
    }
}