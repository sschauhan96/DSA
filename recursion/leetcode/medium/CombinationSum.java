package day2.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        getCombinations(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private List<List<Integer>> res;

    private void getCombinations(int[] candidates, int target,
            int currSum, int currIdx, List<Integer> sol) {
        if (currSum == target) {
            res.add(new ArrayList<>(sol));
            return;
        }
        if (currSum > target || currIdx == candidates.length) {
            return;
        }
        for (int i = currIdx; i < candidates.length; i++) {
            sol.add(candidates[i]);
            getCombinations(candidates, target, currSum + candidates[i], i, sol);
            sol.remove(sol.size() - 1);
        }
    }

}
