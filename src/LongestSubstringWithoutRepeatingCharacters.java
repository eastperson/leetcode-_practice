import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersSolution solution = new LongestSubstringWithoutRepeatingCharactersSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};


        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}

class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int max = 0;
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()){
            list.add(ch);
        }
        while(left != list.size()){
            if(right == list.size()) {
                right = ++left;
                continue;
            }
            List<Character> li = list.subList(left,right+1);
            Set<Character> set = new HashSet<>();
            set.addAll(li);
            if(set.size() == li.size()) {
                max = Math.max(max,li.size());
                right++;
                continue;
            }
            right = ++left;
        }
        return max;
    }
}