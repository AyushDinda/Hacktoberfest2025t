import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();
        
        // Step 1: Count frequency of each remainder
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            count.put(rem, count.getOrDefault(rem, 0) + 1);
        }

        // Step 2: Find the smallest integer x that balances counts
        int i = 0;
        while (true) {
            int rem = i % value;
            if (!count.containsKey(rem) || count.get(rem) == 0) {
                return i; // Found smallest missing remainder
            }
            count.put(rem, count.get(rem) - 1);
            i++;
        }
    }
}
