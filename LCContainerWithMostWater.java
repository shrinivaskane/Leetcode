class LCContainerWithMostWater {
    public int maxArea(int[] height) {
      /*Two Pointer Approach */
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l<r) {
            int area = Math.min(height[r],height[l]) * (r-l);
            ans = Math.max(ans, area);
            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
