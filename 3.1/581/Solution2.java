class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
            if (!sorted(nums, i)) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

        int left = 0;
        while (left < nums.length && nums[left] <= min)
            left++;

        int right = nums.length - 1;
        while (right >= 0 && max <= nums[right])
            right--;

        return left < right ? right - left + 1 : 0;
    }

    boolean sorted(int[] nums, int i) {
        if (i == 0)     return nums[i] <= nums[i + 1];
        if (i == nums.length - 1)   return nums[i - 1] <= nums[i];
        return nums[i - 1] <= nums[i] && nums[i] <= nums[i + 1];
    }
}