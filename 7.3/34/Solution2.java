class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return ans;

        ans[0] = find(nums, target, true);
        if (ans[0] != -1) ans[1] = find(nums, target, false);
        return ans;
    }

    int find(int[] nums, int target, boolean first) {
        int idx = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (first)  right = mid - 1;
                else        left = mid + 1;
            }
        }
        return idx;
    }
}