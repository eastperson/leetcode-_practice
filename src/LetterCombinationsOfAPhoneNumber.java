import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumberSolution letterCombinationsOfAPhoneNumberSolution= new LetterCombinationsOfAPhoneNumberSolution();
        List<String> strings = letterCombinationsOfAPhoneNumberSolution.letterCombinations("2");
        System.out.println(strings);
    }
}

class LetterCombinationsOfAPhoneNumberSolution {

    private Map<Integer,List<String>> map = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return result;
        map.put(2, Arrays.asList("a","b","c"));
        map.put(3, Arrays.asList("d","e","f"));
        map.put(4, Arrays.asList("g","h","i"));
        map.put(5, Arrays.asList("j","k","l"));
        map.put(6, Arrays.asList("m","n","o"));
        map.put(7, Arrays.asList("p","q","r","s"));
        map.put(8, Arrays.asList("t","u","v"));
        map.put(9, Arrays.asList("w","x","y","z"));
        dfs(0,"",digits);
        return result;
    }

    void dfs(int index, String path,String digits) {
        if(path.length() == digits.length()){
            result.add(path);
            return;
        }

        for(int i = index; i< digits.length();i++){
            for(String str : map.get(Integer.parseInt(String.valueOf(digits.charAt(i))))){
                dfs(i+1,path + str,digits);
            }
        }
    }
}