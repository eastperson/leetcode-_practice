import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {
        ArrayPartitionSolution solution = new ArrayPartitionSolution();
        int[] d = {6,2,6,5,1,2};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};


        System.out.println(solution.arrayPairSum(d));
    }
}

class ArrayPartitionSolution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i+=2) {
            sum += nums[len-i-2];
        }
        return sum;
    }
}