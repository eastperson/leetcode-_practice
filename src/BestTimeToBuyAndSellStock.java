import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockSolution solution = new BestTimeToBuyAndSellStockSolution();
        int[] d = {7,6,4,3,1};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};


        System.out.println(solution.maxProfit(d));
    }
}

class BestTimeToBuyAndSellStockSolution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices) {
            minPrice = Math.min(minPrice,price);
            profit = Math.max(profit,price - minPrice);
        }
        return profit;
    }
}