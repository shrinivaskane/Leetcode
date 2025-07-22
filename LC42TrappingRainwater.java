class LC42TrappingRainwater {
    public int trap(int[] height) {          
        if(height == null || height.length == 0) {
            return 0;
        }                      
        /* Prefix and  Suffix Arrays 
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int res = 0;

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i = 1; i< n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for(int i = 0; i<n; i++) {
            res+= Math.min(leftMax[i], rightMax[i])  - height[i];
        }
        return res;
        */
        /* two pointer approach */
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int leftmax = height[l];
        int rightmax = height[r];
        while(l<r) {
            if(leftmax < rightmax) {
                l++;
                leftmax = Math.max(leftmax, height[l]);
                res += leftmax - height[l];
        } else {
            r--;
            rightmax = Math.max(rightmax, height[r]);
            res += rightmax - height[r];
        }
    }
    return res;
    }
}
