import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        PermutationsSolution permutationsSolution = new PermutationsSolution();
        List<List<Integer>> permute = permutationsSolution.permute(nums);
        System.out.println(permute);
    }
}


class PermutationsSolution {
    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs(0,new ArrayList<>());
        return result;
    }

    void dfs(int index,List<Integer> list){
        if(list == null) list = new ArrayList<>();
        if(list.size() == nums.length){
            result.add(list);
            return;
        }
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(i+1,list);
        }
    }
}