import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums); // O(NlogN)
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { // O(N)
            int sum = nums[left] + nums[right];
            if (sum == target) { 
                // 如果sum等于target，那么left、right所指向的数字就是我们要找的结果
                return new int[] {nums[left], nums[right]};
            } else if (sum < target) {
                // 如果sum小于target，那么将left向右移动一位，让下一个sum变大
                left++;
            } else if (sum > target) {
                // 如果sum大于target，那么将right向左移动一位，让下一个sum变小
                right--;
            }
        }
        return new int[0];
    }
}