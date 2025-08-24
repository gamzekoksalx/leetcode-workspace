package medium.mergeIntervals;
import java.util.*;

// LeetCode Top Interview 150 - Merge Intervals
// Time: O(n log n), Space: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by their start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int totalIntervals = intervals.length;
        int mergedCount = 0;
        int[][] mergedIntervals = new int[totalIntervals][2]; // result array

        // Step 2: Start with the first interval
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        // Step 3: Process all remaining intervals
        for (int i = 1; i < totalIntervals; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Overlap → extend the current interval
            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            }
            // No overlap → store current and start a new one
            else {
                mergedIntervals[mergedCount++] = new int[]{currentStart, currentEnd};
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // Step 4: Add the last interval
        mergedIntervals[mergedCount++] = new int[]{currentStart, currentEnd};

        // Step 5: Copy only the used portion of result
        return Arrays.copyOf(mergedIntervals, mergedCount);
    }
}