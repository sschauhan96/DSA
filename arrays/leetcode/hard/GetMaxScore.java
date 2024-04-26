package arrays.leetcode.hard;

public class GetMaxScore {
    public int maxSum(int[] nums1, int[] nums2) {
        long p1 = 0;
        long p2 = 0;
        long maxSum = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                maxSum += (Math.max(p1, p2) + nums1[idx1]);
                idx1++;
                idx2++;
                p1 = 0;
                p2 = 0;
            } else if (nums1[idx1] < nums2[idx2]) {
                p1 += nums1[idx1++];
            } else {
                p2 += nums2[idx2++];
            }
        }

        while (idx1 < nums1.length) {
            p1 += nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            p2 += nums2[idx2++];
        }
        return (int) ((maxSum + Math.max(p1, p2)) % (Math.pow(10, 9) + 7));
    }
}
