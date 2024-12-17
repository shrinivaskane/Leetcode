class LC217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Using Hashset TC - O(n) SC - O(n)
        Set<Integer> seen = new HashSet<>();
        for(Integer num: nums) {
            if(seen.contains(num)) {
                return true;
            }
            seen.add(num); 
        }
        return false;

        // Using stream and distinct count TC O(n) SC O(n)
        //return Arrays.stream(nums).distinct().count() < nums.length;
    }
}