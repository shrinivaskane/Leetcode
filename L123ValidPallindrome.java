class L123ValidPallindrome {
    public boolean isPalindrome(String s) {
        // TC - O(n)  SC - O(1)
        /*
        s = s.toLowerCase();
        StringBuilder cleaned = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            }
        }
        int l = 0, r = cleaned.length() - 1;
        while(l<r) {
            if(cleaned.charAt(l) != cleaned.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
        */
        // Optimal  TC O(n) SC O(1)
        int l = 0, r = s.length() - 1;
        while(l<r) {
            while(l<r && !alphanumeric(s.charAt(l))) {
                l++;
            }
             while(l<r && !alphanumeric(s.charAt(r))) {
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    } 

    boolean alphanumeric(char c) {
        return (c >= 'A' && c<= 'Z' ||
        c >= 'a' && c <= 'z' ||
        c >= '0' && c <= '9');
    }
}
