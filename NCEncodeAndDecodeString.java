import java.util.ArrayList;
import java.util.List;

public class NCEncodeAndDecodeString {
    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for(String str: strs) {
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < str.length()) {
            j = i;
            while(str.charAt(j)!='#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i + length;
            ans.add(str.substring(i, j));
            i = j;
        }
        return ans;
    }
}
