package easy.twoSum;
import java.util.HashMap;
import java.util.Map;

// LeetCode Top Interview 150 - Two Sum
// Time: O(n), Space: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap for storing seen numbers and their indices (O(1) lookup)
        Map<Integer, Integer> map = new HashMap<>();

        // Single pass through array (O(n) time)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i}; // O(1) lookup
            }

            // Store current number and index
            map.put(nums[i], i); // O(1) insert
        }

        return null; // No valid pair found
    }
}