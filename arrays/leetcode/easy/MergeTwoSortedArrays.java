
public class MergeTwoSortedArrays {

    /*
     * https://leetcode.com/problems/merge-sorted-array/submissions/1245213673/
     *
     * Approach 1:-
     * Since end of nums1 is filled with zero and have no impact of nums1 actual m elements, we can use that
     * space to store potential bigger elements out of nums1 or nums2 from extream right to idx=0 on nums1 array
     * 
     * Space complexity O(1)
     * Time complexity O(n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];
            } else {
                nums1[idx--] = nums2[n--];
            }
        }

        while (m >= 0) {
            nums1[idx--] = nums1[m--];
        }

        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }
}
