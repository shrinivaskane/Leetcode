import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49GroupAnagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        /* TC - O(m*nlogn) SC O(m*n)
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] sArray = str.toCharArray();
            Arrays.sort(sArray);
            String key = new String(sArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
        */
        /* TC O(m*n) SC O(m) */
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
           int[] count = new int[26];
           for(char c: str.toCharArray()) {
            count[c - 'a']++;
           }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
