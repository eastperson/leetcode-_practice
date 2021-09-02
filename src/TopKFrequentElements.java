import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElementsSolution solution = new TopKFrequentElementsSolution();
        int[] d = {1,2};

        System.out.println(Arrays.toString(solution.topKFrequent(d, 2)));
    }
}

class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.get(n) != null){
                map.put(n,map.get(n)+1);
            } else {
                map.put(n,1);
            }
        }

        return map.entrySet().stream()
                .sorted((e1,e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).subList(0,k).stream().mapToInt(Integer::intValue).toArray();
    }
}