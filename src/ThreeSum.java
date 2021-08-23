import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution solution = new ThreeSumSolution();
        int[] d = {-2,0,1,1,2};

        System.out.println(solution.threeSum(d));
    }
}

class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (nums[left] == nums[left - 1] && left < right) left++;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}