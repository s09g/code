class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target)   return right;
        if (nums[left] == target)   return left;
        return -1;
    }

    int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target)   return left;
        if (nums[right] == target)   return right;
        return -1;
    }
}