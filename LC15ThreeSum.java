class LC15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /* Approach using HashMap 
        // maintain a set for the ans
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        // loop through the nums array
        for(int i = 0; i<n; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i+ 1; j< n; j++) {
                int complement = target - nums[j];
                if(map.containsKey(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target-nums[j]);
                    Collections.sort(triplet);
                    ans.add(triplet);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(ans);
        */
        /* Approach using Sorting and Two Pointer */
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            int l = i+1, r = n-1;
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i - 1]) continue;
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
                else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }

        }
        return ans;
    }
}
