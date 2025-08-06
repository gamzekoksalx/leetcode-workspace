package medium.groupAnagrams;
import java.util.*;

// LeetCode Top Interview 150 - Group Anagrams
// Time: O(n * k log k), Space: O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store grouped anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Loop through each string in the input array, Time Complexity O(n)
        for (String str : strs) {
            // Convert string to char array
            char[] letters = str.toCharArray();
            // Sort the characters to create a key, Time Complexity O(k log k) for each string
            Arrays.sort(letters);
            // Convert sorted chars back to a string
            String sorted = new String(letters);

            // Add the original string to the correct anagram group, Space Complexity O(n*k)
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        // Return the list of anagram groups
        return new ArrayList<>(map.values());
    }
}