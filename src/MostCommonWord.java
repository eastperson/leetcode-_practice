import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {
    public static void main(String[] args) {
        MostCommonWordSolution solution = new MostCommonWordSolution();
        int[] d = {2,2,3,3};
        String[] banned = {"hit"};


        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }
}
class MostCommonWordSolution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> list = new ArrayList<>();
        for(String str : paragraph.split(" ")){
            for(String s : str.split(",")){
                list.add(s);
            }
        }

        Map<String,Integer> map = new HashMap<>();
        Set<String> set = Arrays.stream(banned).collect(Collectors.toSet());

        for(String str : list) {
            str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
            if(map.keySet().contains(str)){
                map.put(str,map.get(str) + 1);
            } else if(!set.contains(str)) {
                map.put(str,1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList, (o1,o2) -> o1.getValue().compareTo(o2.getValue()));

        return entryList.get(entryList.size()-1).getKey();
    }
}