import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWaterSolution solution = new TrappingRainWaterSolution();
        int[] d = {5,8,9,4,9,6,1,4};

        System.out.println(solution.trap(d));
    }
}

class TrappingRainWaterSolution {
    public int trap(int[] height) {
        int maxIdx = max(height,0);
        int left = maxIdx;
        int right = maxIdx;
        int sum = 0;


        while(left > 0) {
            left = max(Arrays.copyOfRange(height,0,left),0);
            sum += leftSum(height,left,right);
            right = left;
        }

        right = maxIdx + 1;
        left = right;
        while(right < height.length-1){
            right = max(Arrays.copyOfRange(height,left,height.length),left);
            sum += rightSum(height,left,right);
            left = right;
            if(left == right) left += 1;
        }
        return sum;
    }

    int max(int[] height,int left){
        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < height.length; i++) {
            if(max < height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        return maxIdx + left;
    }

    int leftSum(int[] height, int left, int right){
        int sum = 0;
        if(left == right)
            return 0;
        for(int i = left + 1; i < right; i++) {
            sum += height[left] -  height[i];
        }
        return sum;
    }

    int rightSum(int[] height, int left, int right){
        int sum = 0;
        if(left == right) return 0;
        for(int i = left; i < right; i++) {
            sum += height[right] -  height[i];
        }
        return sum;
    }
}