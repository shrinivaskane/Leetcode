class LC3LongestSubstringwithoutrepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, res = 0;
        Set<Character> set = new HashSet<Character>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))) {
                 set.remove(s.charAt(l));
                 l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
