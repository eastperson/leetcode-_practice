import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        int[] d = {2,2,3,3};

        System.out.println(solution.isValid("([)]"));
    }
}

class ValidParenthesesSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char ch : s.toCharArray()) {
            if(!map.keySet().contains(ch)){
                stack.push(ch);
            }
            else if (stack.isEmpty() || map.get(ch) != stack.pop()){
                return false;
            }
        }
        return stack.size() == 0;
    }
}