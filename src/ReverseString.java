import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        ReverseStringSolution solution = new ReverseStringSolution();
        int[] d = {2,2,3,3};
        char[] chars = {'h','e','l','l','o'};
        solution.reverseString(chars);

        System.out.println(Arrays.toString(chars));
    }
}

class ReverseStringSolution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

