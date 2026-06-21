class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    /*
       int r1 = m-1;
       int r2 = n-1;
       for(int w = m + n - 1; w>=0; w--) {
           if(r1 >=0 && r2>=0) {
               nums1[w] = nums1[r1] > nums2[r2]? nums1[r1--]: nums2[r2--];
           } else if(r1>=0) {
               nums1[w] = nums1[r1--];
           } else {
               nums1[w] = nums2[r2--];
           }
       }
        */

        int l = m-1, r = n-1, p = m+n-1;
        while(l>=0 && r >= 0) {
            if(nums1[l] >= nums2[r]) {
                nums1[p] = nums1[l];
                l--;
            } else {
                nums1[p] = nums2[r];
                r--;
            }
            p--;
        }
        while(l>=0) {
            nums1[p] = nums1[l];
            l--;
            p--;
        }
        while(r>=0) {
            nums1[p] = nums2[r];
            r--;
            p--;
        }
    }
}
