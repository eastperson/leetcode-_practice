import java.util.Arrays;

/**
 * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.
 *
 *
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindromeSolution solution = new ValidPalindromeSolution();
        int[] d = {2,2,3,3};

        System.out.println(solution.solution("A man, a plan, a canal: Panama"));
    }
}

class ValidPalindromeSolution {
    public boolean solution(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]","").replaceAll(" ","").toLowerCase();
        char[] chars = s.toCharArray();
        int len = s.length();
        for(int i = 0; i < len; i++) if(chars[i] != chars[len-1-i]) return false;
        return true;
    }
}
