package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        updateParentMap(root, null);
        return getKDistance(target, k);
    }

    private List<Integer> getKDistance(TreeNode target, int distanceRemained) {
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        visited.add(target);
        queue.add(target);

        while (!queue.isEmpty() && distanceRemained != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                if (parentMap.containsKey(curr.val) && !visited.contains(parentMap.get(curr.val))) {
                    queue.add(parentMap.get(curr.val));
                    visited.add(parentMap.get(curr.val));
                }
            }
            distanceRemained--;
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }

    Map<Integer, TreeNode> parentMap;

    private void updateParentMap(TreeNode child, TreeNode parent) {
        if (parent != null) {
            parentMap.put(child.val, parent);
        }
        if (child.left != null) {
            updateParentMap(child.left, child);
        }
        if (child.right != null) {
            updateParentMap(child.right, child);
        }
    }
}
