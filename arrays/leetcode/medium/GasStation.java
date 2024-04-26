package arrays.leetcode.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int gasRemained = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            gasRemained += gas[i] - cost[i];
            if (gasRemained < 0) {
                gasRemained = 0;
                startPoint = i + 1;
            }
        }
        if (totalGas < 0) {
            return -1;
        }
        return startPoint;
    }
}
