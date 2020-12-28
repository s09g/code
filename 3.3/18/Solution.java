import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i - 1] == nums[i])	continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j])	continue;
                twoSum(targetSum - nums[i] - nums[j], nums, i, j, ans);
            }
        }

        return ans;
    }

    private void twoSum(int target, int[] nums, int i, int j, List<List<Integer>> ans) {
        int left = j + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left])
                    left++;
                while (left < right && nums[right + 1] == nums[right])
                    right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}