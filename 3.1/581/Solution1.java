import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int left = 0;
        while (left < nums.length && arr[left] == nums[left])
            left++;

        int right = nums.length -1;
        while (right >= 0 && arr[right] == nums[right])
            right--;

        return left <= right ? right - left + 1: 0;
    }
}