package arrays.leetcode.easy;

public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion.Solution sol = new FirstBadVersion().new Solution();
        System.out.println(sol.firstBadVersion(5));
    }

    class Solution {
        public int firstBadVersion(int n) {
            int s = 0;
            int e = n - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (isBadVersion(mid)) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            return e + 1;
        }

        // dummy method
        public boolean isBadVersion(int version) {
            return true;
        }
    }

}
