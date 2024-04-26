package arrays.leetcode.hard;

import java.util.Arrays;

public class RainWaterTrapping {

    public static void main(String[] args) {
        RainWaterTrapping ob = new RainWaterTrapping();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(ob.trap(height));
    }

    public int trap(int[] height) {
        int[] rightWallRef = getRightWallRef(height);
        int leftWallRef = height[0];
        int waterTrapped = 0;
        for (int i = 1; i < height.length - 1; i++) {
            leftWallRef = Math.max(leftWallRef, height[i - 1]);
            int currLvl = Math.min(leftWallRef, rightWallRef[i + 1]) - height[i];
            if (currLvl > 0) {
                waterTrapped += currLvl;
            }
        }
        return waterTrapped;
    }

    private int[] getRightWallRef(int[] height) {
        int[] refArray = new int[height.length];
        int currMax = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            refArray[i] = Math.max(currMax, height[i]);
            currMax = refArray[i];
        }
        return refArray;
    }
}
