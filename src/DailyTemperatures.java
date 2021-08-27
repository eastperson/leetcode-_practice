import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperaturesSolution solution = new DailyTemperaturesSolution();
        int[] d = {30,60,90};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};


        System.out.println(Arrays.toString(solution.dailyTemperatures(d)));
    }
}

class DailyTemperaturesSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] duration = new int[temperatures.length];
        for(int i = 0; i < temperatures.length-1; i++) {
            duration[i] = 0;
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[i] < temperatures[j]) {
                    duration[i] = j-i;
                    break;
                }
            }
        }
        return duration;
    }
}