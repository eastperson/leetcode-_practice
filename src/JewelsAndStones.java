import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStonesSolution solution = new JewelsAndStonesSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};


        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
    }
}


class JewelsAndStonesSolution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : jewels.toCharArray()){
            map.put(ch,0);
        }
        int count = 0;
        for(char ch : stones.toCharArray()){
            if(null != map.get(ch)) count++;
        }
        return count;
    }
}