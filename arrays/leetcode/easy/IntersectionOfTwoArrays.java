package arrays.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersectionViaSortedArray(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                res.add(nums1[idx1]);
                idx1++;
                idx2++;
                while (idx1 < nums1.length && nums1[idx1] == nums1[idx1 - 1]) {
                    idx1++;
                }
                while (idx2 < nums2.length && nums2[idx2] == nums2[idx2 - 1]) {
                    idx2++;
                }
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersectionViaHashSet(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
