public class LC242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        /* Brute Force  Optimal TC O(nlogn + mlogm) SC O(1)
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
        */

        // Optimal TC O(n+m) SC O(1)
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i< s.length(); i++) {
            count[s.charAt(i) - 'a']++;
             count[t.charAt(i) - 'a']--;
        }
        for(int c: count) {
            if(c!=0) {
                return false;
            }
        }
        return true;
    }
}
