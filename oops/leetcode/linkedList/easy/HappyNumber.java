package leetcode.linkedList.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> powerSet = new HashSet<>();
        powerSet.add(n);
        while (true) {
            int newNum = getDigitPower(n);
            if (newNum == 1) {
                return true;
            } else if (powerSet.contains(newNum)) {
                break;
            }

            powerSet.add(newNum);
            n = newNum;
        }
        return false;
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1 && getDigitPower(fast) != 1) {
            slow = getDigitPower(slow);
            fast = getDigitPower(getDigitPower(fast));
            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    private int getDigitPower(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}
