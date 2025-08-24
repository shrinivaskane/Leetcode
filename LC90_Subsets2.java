class LC90_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0, res);
        return res;
        */

        /* Iterative*/

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList());
        int start = 0;
        int end = 0;
        for(int i = 0; i< nums.length; i++) {
            start = 0;
            if(i>0 && nums[i] == nums[i-1]) {
                start = end + 1;
            }
            end = res.size() - 1;
            int size = res.size();
            for(int j = start; j < ; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(nums[i]);
                res.add(subset);
            }
        }
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, int i, List<List<Integer>> res) {
        if(i == nums.length) {
           res.add(new ArrayList<>(curr));
           return;
        }

        curr.add(nums[i]);
        dfs(nums, curr, i+1, res);
        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        curr.remove(curr.size() - 1);
        dfs(nums, curr, i+1, res);
    }
}
