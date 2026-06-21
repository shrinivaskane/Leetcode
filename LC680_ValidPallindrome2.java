class Solution {
    public boolean LC680_ValidPallindrome2(String s) {
        /* recursive 
        return pallR(0, s.length() -1, false, s);
        */

        /*  Iterative */
        int l = 0, r = s.length() - 1;
        
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                // try skipping either left or right character
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    // IsPallindrome of iterative approach.
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // Recursive Function. 
    private boolean pallR(int l, int r, boolean skipped, String s) {
    // base case - pointers crossed
     if(l >= r) return true;

        if(s.charAt(l) != s.charAt(r)) {
            if(skipped) return false;
            return pallR(l+1, r, true, s) || pallR(l, r-1, true, s);
        }

        return pallR(l+1, r-1, skipped, s);
    }

}
