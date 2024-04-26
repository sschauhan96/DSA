package day2.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addParenthesis(n, res, 0, 0, "");
        return res;
    }

    private void addParenthesis(int n, List<String> res, int cO, int cC, String pattern) {
        if (n == cO && n == cC) {
            res.add(pattern);
            return;
        }
        if (n < cO || n < cC || cO < cC) {
            return;
        }
        if (n > cO) {
            addParenthesis(n, res, cO + 1, cC, pattern + '(');
        }
        if (n > cC) {
            addParenthesis(n, res, cO, cC + 1, pattern + ')');
        }
    }
}
