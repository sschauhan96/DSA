package arrays.leetcode.easy;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        int idx = num.length - 1;
        List<Integer> res = new ArrayList<>();
        while (idx >= 0 || k != 0) {
            int sum = 0;
            if (idx >= 0) {
                sum += num[idx--];
            }
            if (k != 0) {
                sum += k % 10;
                k /= 10;
            }
            sum += carry;
            res.add(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            res.add(0, 1);
        }
        return res;
    }
}
