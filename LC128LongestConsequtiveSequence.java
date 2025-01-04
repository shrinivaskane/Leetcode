import java.util.HashSet;
import java.util.Set;

public class LC128LongestConsequtiveSequence {
    public int longestConsecutive(int[] nums) {
        /* Using sorting
        TC - O(nlogn)  SC - O(1) 
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, streak = 0, maxLength = 0, curr = nums[i];
        while(i < nums.length) {
            if(curr!=nums[i]) {
                curr = nums[i];
                streak = 0;
                i++;
            }else if(curr == nums[i] && i < nums.length) {
                i++;
            }
            curr++;
            streak++;
            maxLength = Math.max(streak, maxLength);
        }
        return maxLength;
        */


        /* Using set approach TC - O(n) SC 0(n) */
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int maxLength = 0;
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int length = 1;
                while(set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}