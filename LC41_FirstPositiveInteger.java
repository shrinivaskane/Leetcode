class LC41_FirstPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        // Step 1 - replace negatives and zeros
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) nums[i] = nums.length + 1;
        }

        // Step 2 - mark seen numbers
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if(val <= nums.length) {
                nums[val-1] = -Math.abs(nums[val-1]);
            }
        }

        // Step 3 - find first missing
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}
