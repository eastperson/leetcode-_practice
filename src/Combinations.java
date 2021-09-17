import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Combinations {
    public static void main(String[] args) {
        CombinationsSolution combinationsSolution = new CombinationsSolution();
        List<List<Integer>> combine = combinationsSolution.combine(4, 2);
        System.out.println(combine);
    }
}

class CombinationsSolution {

    private int max;
    private int n;
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        max = k;
        result = new ArrayList<>();
        dfs(new ArrayList<>(),1,k);
        return result;
    }

    void dfs(List<Integer> elements, int start, int k) {
        if(k == 0){
            result.add(new ArrayList<>(elements));
        }

        for(int i = start; i < n+1; i++){
                elements.add(i);
                dfs(elements,i+1,k-1);
                elements.remove(elements.size()-1);
        };
    }
}