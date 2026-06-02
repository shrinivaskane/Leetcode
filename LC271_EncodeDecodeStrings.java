public class LC271_EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append('#').append(s);            
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> ans = new ArrayList<>();
        while(i<s.length()) {
            int j = s.indexOf('#', i);
            int strlength = Integer.parseInt(s.substring(i, j));
            ans.add(s.substring(j+1, j+1+strlength));
            i = j+1 + strlength;
        }
        return ans;
    }
}

