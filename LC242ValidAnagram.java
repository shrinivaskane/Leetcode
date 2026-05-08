class LC242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        /* Using Sorting Approach  TC O(nlogn)  SC O(n)
        if(s.length != t.length()) return false;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
        */

        // Using frequency counter  TC - O(n)   SC  O(1)
        if(s.length() != t.length()) return false;

        int[] counter = new int[26];

        for(int i = 0; i< s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i< t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if(counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

        /* If asked for Lowercase + Uppercase chars  TC  - O(n),  SC - O(1).
         // If lengths differ, cannot be anagram
        if (s.length() != t.length()) return false;

        // 26 lowercase + 26 uppercase
        int[] counter = new int[52];

        for (int i = 0; i < s.length(); i++) {
            counter[getIndex(s.charAt(i))]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = getIndex(t.charAt(i));
            counter[idx]--;

            if (counter[idx] < 0) {
                return false;
            }
        }

        return true;
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return c - 'A' + 26;
    }

    */

    /* If input strings contains unicode chars. TC   - O(n)   SC - O(k).
    if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
        */ 

        /* If input strings contains fully unicode chars 
        Some Unicode characters (like emojis 😄) are represented using 2 chars (surrogate pairs)
        
        // for (char c : s.toCharArray())  may break for full Unicode correctness.

        int[] sArr = s.codePoints().toArray();
        int[] tArr = t.codePoints().toArray();

        if (sArr.length != tArr.length) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int c : sArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int c : tArr) {
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return map.isEmpty();
        */ 
}
