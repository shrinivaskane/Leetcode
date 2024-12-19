import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];
        for(Integer num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i< freqs.length; i++) {
            freqs[i] = new ArrayList<Integer>();
        }
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = freqs.length - 1; i> 0; i--) {
            for(int n: freqs[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
