class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /* Recursion 
        if(nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> perm: perms) {
            for(int i = 0; i<= perm.size(); i++) {
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(i, nums[0]);
                res.add(permCopy);
            }
        }
        return res;
        */

        /* Iteration */
        if(nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int num: nums) {
            List<List<Integer>> newPerm = new ArrayList<>();
            for(List<Integer> perm: perms) {
            for(int i = 0; i<= perm.size(); i++) {
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(i, num);
                newPerm.add(permCopy);
            }
            perms = newPerm;
        }
        }
        return perms;
    }
}
