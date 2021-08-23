import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelfSolution solution = new ProductOfArrayExceptSelfSolution();
        int[] d = {1,2,3,4};
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};


        System.out.println(Arrays.toString(solution.productExceptSelf(d)));
    }
}

class ProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            if(i == 0) leftSum[i] = nums[i];
            else leftSum[i] = nums[i] * leftSum[i-1];
        }
        for(int i = 0; i< nums.length; i++) {
            if(i == 0) rightSum[nums.length - i - 1] = nums[nums.length - 1];
            else rightSum[nums.length - i - 1] = nums[nums.length - i - 1] * rightSum[nums.length - i];
        }

        for(int i = 0; i < nums.length; i++) {
            if(i == 0){
                result[i] = rightSum[i + 1];
                continue;
            } else if(i == nums.length - 1){
                result[i] = leftSum[i -1];
            } else {
                result[i] = leftSum[i - 1] * rightSum[i + 1];
            }
        }
        return result;
    }
}