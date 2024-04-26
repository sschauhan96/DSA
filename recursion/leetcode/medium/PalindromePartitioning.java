package day2.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getPartitions(s, new ArrayList<>(), res);
        return res;
    }

    private void getPartitions(String str, List<String> currPalindromes, List<List<String>> res) {
        if (str.isEmpty()) {
            if (!currPalindromes.isEmpty()) {
                res.add(new ArrayList<>(currPalindromes));
            }
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            String piece = str.substring(0, i);
            if (isPalindrome(piece)) {
                currPalindromes.add(piece);
                getPartitions(str.substring(i), currPalindromes, res);
                currPalindromes.remove(currPalindromes.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
