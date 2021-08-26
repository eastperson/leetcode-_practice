import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLettersSolution solution = new RemoveDuplicateLettersSolution();
        int[] d = {2,2,3,3};
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};


        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}


class RemoveDuplicateLettersSolution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            boolean isContain = false;
            for(char ch : Arrays.copyOfRange(chars,i+1,chars.length)){
                if(ch == chars[i]) {
                    isContain = true;
                    break;
                }
            }
            if(stack.isEmpty() || chars[i] > stack.peek() || !isContain) {
                stack.push(chars[i]);
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = String.valueOf(stack.pop()) + result;
        }
        return result;
    }
}