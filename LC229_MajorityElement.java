class LC229_MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0, count2 = 0;
        Integer num1 = null, num2 = null;
        for(int num: nums) {
            if(count1!=0 && num1 == num) {
                count1++;
            } else if(count2!=0 && num2 == num) {
                count2++;
            } else if(count1== 0) {
                count1++;
                num1 = num;
            } else if(count2 == 0) {
                count2++;
                num2 = num;
            } else {
                count1--;
                count2--;
            }
            }
            
            count1 = count2 = 0;
            for(int num:nums) {
                if(num1== num) {
                    count1++;
                } else if(num2 == num) {
                    count2++;
                } 
            }

            if(count1> nums.length/3) {
                ans.add(num1);
            } 
            if(count2 > nums.length/3) {
                ans.add(num2);
            }
            return ans;
    }
}
