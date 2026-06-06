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
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for(int num: nums) {
            set.add(num);
        }
        for(int num: set) {
            if(!set.contains(num-1)) {
                int start = num;
                int count = 0;
                while(set.contains(start)) {
                    count+=1;
                    start+=1;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}


