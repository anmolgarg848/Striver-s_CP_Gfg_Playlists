package Trees;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    TreeNode(int val) {
        this.val = val;
    }
}

public class Construct {
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = in.length;
        for (int i = 0; i < n; i++) {
            map.put(in[i], i);
        }
        TreeNode root = BuildTree(pre, 0, n - 1, in, 0, n - 1, map);
        return root;
    }

    private TreeNode BuildTree(int[] pre, int pre_s, int pre_e, int[] in, int in_s, int in_e, Map<Integer, Integer> map) {
if (pre_s>pre_e||in_s>in_e)return null;
        int ele = pre[pre_s];
        TreeNode root = new TreeNode(ele);
        int root_idx = map.get(ele);
        int tot_ele = root_idx-in_s;
        root.left = BuildTree(pre, pre_s+1, pre_s+tot_ele, in, in_s, root_idx-1, map);
        root.right = BuildTree(pre, pre_s+tot_ele+1, pre_e, in, root_idx+1, in_e, map);

        return root;
    }
}