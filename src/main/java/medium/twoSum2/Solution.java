package medium.twoSum2;

// Time Complexity - O(n) as it scans only once
// Space Complexity - O(1) as the space we use doesn't grow when the input gets bigger
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        // Loop until the two pointers meet
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // Calculate current sum

            if (sum == target) {
                // Return 1-indexed positions
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++; // Move left pointer right to increase sum
            } else {
                right--; // Move right pointer left to decrease sum
            }
        }

        // This return is never hit because there's always exactly one solution
        return null;
    }
}
