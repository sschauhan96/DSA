package arrays.leetcode.medium;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isComposite = new boolean[n];
        for (int div = 2; div * div < n; div++) {
            if (!isComposite[div]) {
                for (int table = div * div; table < n; table += div) {
                    isComposite[table] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }
        return count;
    }
}
