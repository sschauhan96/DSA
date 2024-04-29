package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthLargestSumInBT {

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currLvlSize = queue.size();
            long sum = 0;
            while (currLvlSize-- > 0) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            if (sum != 0) {
                res.add(sum);
            }
        }

        if (res.size() < k) {
            return -1;
        }
        Collections.sort(res);
        return res.get(res.size() - k);
    }
}
