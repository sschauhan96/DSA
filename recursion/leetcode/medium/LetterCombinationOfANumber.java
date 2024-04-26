package day2.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfANumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        getLetterCombination(digits, res, "");
        return res;
    }

    private void getLetterCombination(
        String digits, List<String> res, String pattern){
            if(digits.isEmpty()){
                if(!pattern.isEmpty()){
                    res.add(pattern);
                }
            }else{
                String options = getOptions(digits.charAt(0));
                for(char ch : options.toCharArray()){
                    getLetterCombination(digits.substring(1), res, pattern+ch);
                }
            }
    }

    private String getOptions(char num){
        switch(num){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default :
                return "";
        }
    }
}
