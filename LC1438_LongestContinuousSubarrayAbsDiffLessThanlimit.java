class LC1438_LongestContinuousSubarrayAbsDiffLessThanlimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new LinkedList<>();  // monotonically decreasing
        Deque<Integer> minQueue = new LinkedList<>();  // monotonically increasing

        int l = 0, r;
        int maxLength = 0;

        for(r = 0; r< nums.length; r++) {
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[r]) {
                maxQueue.pollLast();
            }
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[r]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[r]);
            maxQueue.offerLast(nums[r]);

            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if(nums[l] == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                if(nums[l] == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;

        }
}
