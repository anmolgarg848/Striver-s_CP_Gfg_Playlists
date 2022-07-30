package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class Binary_Tree {
    static class TreeNode {
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

    //================================ Traversal's in Binary Tree  ========================
    private static void pre_Order(TreeNode root) {
        //root --> left --> right
        if (root == null) return;
        System.out.print(root.val + ' ');
        pre_Order(root.left);
        pre_Order(root.right);

    }

    //Iterative Traversals
    private static void pre_Order_iterative(TreeNode root) {
        //root --> left --> right
        //Using Stack
        Stack<TreeNode> ps = new Stack<>();
        ps.add(root);
        while (!ps.isEmpty()) {
            TreeNode node = ps.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                ps.add(node.right);
            }
            if (node.left != null) {
                ps.add(node.left);
            }
        }
    }

    private static void In_Order_Iterative(TreeNode root) {
        // left --> root --> right
        Stack<TreeNode> ps = new Stack<>();
        TreeNode node = root;
        while (true) {
            //go deep left until null hits
            if (node != null) {
                ps.add(node);
                node = node.left;
            } else {
                //print root
                if (ps.isEmpty()) break;
                TreeNode nn = ps.pop();
                System.out.print(nn.val + " ");
                node = nn.right;
            }
        }
    }

    private static void postOrder_iterative(TreeNode root) {
        //left --> right --> root
        Stack<TreeNode> ps = new Stack<>();//primary stack stores left right nodes
        Stack<Integer> ss = new Stack<>(); //secondary stack stores root /res
        ps.add(root);
        while (!ps.isEmpty()) {
            TreeNode node = ps.pop();
            ss.add(node.val);
            //store left
            if (node.left != null) {
                ps.add(node.left);
            }
            if (node.right != null) {
                ps.add(node.right);
            }

        }
        while (!ss.isEmpty()) {
            System.out.print(ss.pop() + " ");
        }
    }

    class Pair {
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    private void pre_in_post(TreeNode root) {
        //Numbered Approach
//        pre -> 1 ,  In -->  2 , post --> 3
        Stack<Pair> ps = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> In = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null) return;
        ps.add(new Pair(root, 1));
        while (!ps.isEmpty()) {
            Pair pair = ps.pop();
            TreeNode node = pair.node;
            int idx = pair.idx;
            int val = node.val;
            if (idx == 1) {
                pre.add(val);
                pair.idx++;
                ps.add(pair);
                //when left exists
                if (node.left != null) {
                    ps.add(new Pair(node.left, 1));
                }
            } else if (idx == 2) {
                In.add(val);
                pair.idx++;
                ps.add(pair);
                if (node.right != null) {
                    ps.add(new Pair(node.right, 1));
                }
            } else {
                post.add(val);
            }
        }
        System.out.println(pre);
        System.out.println(In);
        System.out.println(post);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        Binary_Tree bt = new Binary_Tree();
        bt.pre_in_post(n1);
        pre_Order_iterative(n1);
        System.out.println();
        In_Order_Iterative(n1);
        System.out.println();
        postOrder_iterative(n1);
    }
    //depth or height of a Binary Tree

    private static int Depth_Height(TreeNode root) {
        if (root == null) return 0;
        int left = Depth_Height(root.left);
        int right = Depth_Height(root.right);
        return Math.max(left, right) + 1;
    }

    //check for Balanced Binary Tree
    //ht of tree must be log n or a binary tree in which the left and right subtrees of every node
    // differ in height by no more than 1.
    private static boolean isBalanced(TreeNode root) {
        return helper(root) == -1 ? false : true;
    }

    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    //Diameter of a Binary Tree
    private static int Dia(TreeNode root) {
        int[] max = {0};
        helper(root, max);
        return max[0];
    }

    private static int helper(TreeNode root, int[] max) {
        if (root == null) return 0;
        TreeNode node = root;
        int lh = helper(root.left);
        int rh = helper(root.right);
        max[0] = Math.max(lh + rh, max[0]);
        return Math.max(lh, rh) + 1;
    }

    //Brute force --> Ask every Node for its left_sum  + right_sum + root.val
    //    Maximum Path sum in a Binary Tree from any given node
    private static int max_path_sum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        max_path_sum_helper(root, max);
        return max[0];
    }

    private static int max_path_sum_helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left_subtree_sum = max_path_sum_helper(root.left, max);
        if (left_subtree_sum < 0) {
            left_subtree_sum = 0;
        }
        int right_subtree_sum = max_path_sum_helper(root.right, max);
        if (right_subtree_sum < 0) {
            right_subtree_sum = 0;
        }
        max[0] = Math.max(left_subtree_sum + right_subtree_sum + root.val, max[0]);
        return Math.max(left_subtree_sum, right_subtree_sum) + root.val;
    }

    //isIdentical
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null || p.val != q.val) {
            return false;
        }
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    //Zig - Zag Traversal
    private static void Zig_Zag(TreeNode root) {
//do level order traversal and reverse the odd lists
        //use add first of linkedlist
        List<LinkedList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int level = 0;
        while (!pq.isEmpty()) {
            int n = pq.size();
            LinkedList<Integer> ll = new LinkedList<>();
            boolean zig_zag = false;
            for (int i = 0; i < n; i++) {
                TreeNode node = pq.poll();
                int ele = node.val;
                if (!zig_zag) {
                    ll.addLast(ele);
                } else {
                    ll.addFirst(ele);
                }
                if (node.left != null) {
                    pq.add(node.left);
                }
                if (node.right != null) {
                    pq.add(node.right);
                }
            }
            level++;
            if (level % 2 == 1) {
                zig_zag = true;
            } else {
                zig_zag = false;
            }
            res.add(new LinkedList<>(ll));
        }
        for (LinkedList<Integer> ls : res) {
            System.out.println(ls);
        }
    }

    //Boundary Traversal --> Anti Clock_Wise
    private static List<Integer> Boundary_Traversal(TreeNode root) {
        //Approach --> left boundary  + leaf nodes  + right boundary
        List<Integer> res = new ArrayList<>();
        if (isLeaf(root)) {
            res.add(root.val);
            return res;
        } else {
            res.add(root.val);
        }
        Left_Boundary(root, res);
        Leaf_nodes(root, res);
        right_Boundary(root, res);
        return res;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    //[3,9,null,36,20,null,null,15,7,8,null,86]
    private static void Leaf_nodes(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
        }
        Leaf_nodes(root.left, res);
        Leaf_nodes(root.right, res);
    }

    private static void right_Boundary(TreeNode root, List<Integer> res) {
        TreeNode node = root.right;
        List<Integer> tmp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                tmp.add(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }
    }

    private static void Left_Boundary(TreeNode root, List<Integer> res) {
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }

        }
    }

    //vertical Order Traversal
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
//vertical --> level --> sorted level wise
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);

        for (TreeMap<Integer, PriorityQueue<Integer>> ver : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> lev : ver.values()) {
                while (!lev.isEmpty()) {
                    res.get(res.size() - 1).add(lev.poll());
                }
            }
        }
        return res;
    }

    private void helper(TreeNode root, int vertical, int level, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(vertical)) {
            map.put(vertical, new TreeMap<>());
        }
        if (!map.get(vertical).containsKey(level)) {
            map.get(vertical).put(level, new PriorityQueue<>());
        }
        map.get(vertical).get(level).add(root.val);
        helper(root.left, vertical - 1, level + 1, map);
        helper(root.right, vertical + 1, level + 1, map);
    }

    static class tuple {
        int level;
        int ele;

        tuple(int _level, int _ele) {
            this.level = _level;
            this.ele = _ele;
        }
    }

    //Top View Of a Binary Tree  View Oof a Binary
    private static void Top_View_BT(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        //Approach --> Vertical--> Level wise Traversal
        Map<Integer, tuple> map = new TreeMap<>();
        helper(root, 0, 0, map);

        for (tuple tp : map.values()) {
            ls.add(tp.ele);
        }
        System.out.println(ls);
    }

    private static void helper(TreeNode root, int vertical, int level, Map<Integer, tuple> map) {
        if (root == null) return;
        if (!map.containsKey(vertical)) {
            map.put(vertical, new tuple(level, root.val));
        } else {
            tuple tp = map.get(vertical);
            if (tp.level > level) {
                tp.level = level;
                tp.ele = root.val;
            }
        }
        helper(root.left, vertical - 1, level + 1, map);
        helper(root.right, vertical + 1, level + 1, map);
    }

    static class Pair_tv {
        int vert;
        TreeNode node;

        Pair_tv(int _vert, TreeNode node) {
            this.vert = _vert;
        }
    }

    //Top View Level Order
    private static void topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair_tv> pq = new LinkedList<>();
        pq.add(new Pair_tv(0, root));
        while (!pq.isEmpty()) {
            Pair_tv p = pq.remove();
            int vert = p.vert;
            TreeNode node = p.node;
            if (!map.containsKey(vert)) {
                map.put(vert, node.val);
            }

            if (node.left != null) {
                pq.add(new Pair_tv(vert - 1, node.left));
            }
            if (node.right != null) {
                pq.add(new Pair_tv(vert + 1, node.right));
            }
        }
        for (int ele : map.values()) {
            res.add(ele);
        }
        System.out.println(res);
    }

    //Bottom View of a Binary Tree
    private static void Bottom_View_BT(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        //Approach --> Vertical--> Level wise Traversal
        Map<Integer, tuple> map = new TreeMap<>();
        helper_bottom(root, 0, 0, map);

        for (tuple tp : map.values()) {
            ls.add(tp.ele);
        }
        System.out.println(ls);
    }

    //Catch --> When Nodes are OverLapping at the same level Always take the right node
    private static void helper_bottom(TreeNode root, int vertical, int level, Map<Integer, tuple> map) {
        if (root == null) return;
        if (!map.containsKey(vertical)) {
            map.put(vertical, new tuple(level, root.val));
        } else {
            tuple tp = map.get(vertical);
            if (tp.level < level) {
                tp.level = level;
                tp.ele = root.val;
            }
        }
        helper_bottom(root.right, vertical + 1, level + 1, map);
        helper_bottom(root.left, vertical - 1, level + 1, map);
    }

    //Bottom View Level Order
    private static void bt_level(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair_tv> pq = new LinkedList<>();
        pq.add(new Pair_tv(0, root));
        while (!pq.isEmpty()) {
            Pair_tv p = pq.remove();
            int vert = p.vert;
            TreeNode node = p.node;
            if (node.left != null) {
                pq.add(new Pair_tv(vert - 1, node.left));
            }
            map.put(vert, node.val);
            if (node.right != null) {
                pq.add(new Pair_tv(vert + 1, node.right));
            }
        }
        for (int ele : map.values()) {
            res.add(ele);
        }
        System.out.println(res);
    }

    //right left view of a Binary Tree
    private static void left_view_Bt(TreeNode root) {
        // level --> ele
        Map<Integer, Integer> map = new TreeMap<>();

        for (int ele : map.values()) {
            System.out.print(ele + " ");
        }
    }

    private static void helper_lv(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int level = 0;
        while (!pq.isEmpty()) {
            int n = pq.size();
            while (n-- > 0) {
                TreeNode node = pq.poll();
                //for left view
//                if (!map.containsKey(level)) {
//                    map.put(level, node.val);
//                }
                //for right view
                map.put(level, node.val);

                if (node.left != null) {
                    pq.add(node.left);
                }
                if (node.right != null) {
                    pq.add(node.right);
                }
            }
            level++;
        }
    }

    public boolean isSymmetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null && r2 != null || r1 != null && r2 == null || r1.val != r2.val) {
            return false;
        }
        if (isSymmetric(r1.left, r2.right)) return true;
        return false;
    }

    //root to Node Path
    private static boolean root_to_node_Path(TreeNode root, TreeNode node, String path) {
        if (root == null) return false;
        if (root == node) {
            System.out.println(path);
            return true;
        }
        boolean left = root_to_node_Path(root.left, node, path + root.val + " ");
        boolean right = root_to_node_Path(root.left, node, path + root.val + " ");
        if (left || right) return true;
        return false;
    }

    /*Lowest Common Ancestor
    Brute Force
    Store Both Paths and compare and get upper common bound in both
    optimized --> if  both meets  at same platform node  return that platform
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    static class width {
        TreeNode node;
        int idx;

        width(TreeNode _node, int _idx) {
            this.node = _node;
            this.idx = _idx;
        }
    }

    //Maximum width of a Binary Tree using level order Traversal
    private static int max_width(TreeNode root) {
        if (root == null) return 0;
        int max_width = 1;
        Queue<width> pq = new LinkedList<>();
        pq.add(new width(root, 0));
        while (!pq.isEmpty()) {
            int n = pq.size();
            int left_most_idx = 0;
            int right_most_idx = 0;
            for (int i = 0; i < n; i++) {
                width w = pq.poll();
                TreeNode node = w.node;
                int idx = w.idx;
                if (i == 0) {
                    left_most_idx = idx;
                }
                if (i == n - 1) {
                    right_most_idx = idx;
                }
                if (node.left != null) {
                    pq.add(new width(node.left, 2 * idx + 1));
                }
                if (node.right != null) {
                    pq.add(new width(node.right, 2 * idx + 2));
                }
            }
            max_width = Math.max(max_width, right_most_idx - left_most_idx + 1);
        }
        return max_width;
    }

    //Parent Pointer Approach(Up-Ward Pointer )-->Level-Order Traversal
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Parent_Pointer(root, map);
        Search(target, k, map, res);

        return res;
    }

    public void Search(TreeNode node, int k, Map<TreeNode, TreeNode> map, List<Integer> res) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> pq = new LinkedList<>();
        if (node == null) return;
        pq.add(node);
        visited.add(node);
        int dist = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            if (dist == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode tmp = pq.poll();
                //go left
                if (tmp.left != null && !visited.contains(tmp.left)) {
                    pq.add(tmp.left);
                    visited.add(tmp.left);
                }
                //go right
                if (tmp.right != null && !visited.contains(tmp.right)) {
                    pq.add(tmp.right);
                    visited.add(tmp.right);
                }
                //move upward
//                tmp ka parent hai jo visited nhi hai
                if (map.containsKey(tmp)&&!visited.contains(map.get(tmp))){
                    pq.add(map.get(tmp));
                    visited.add(map.get(tmp));
                }

            }

            dist++;
        }


        while (!pq.isEmpty()){
            res.add(pq.poll().val);
        }
    }

    public void Parent_Pointer(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        //Level Order Traversal
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while (!pq.isEmpty()) {
            TreeNode node = pq.poll();
            if (node.left != null) {
                map.put(node.left, node);
                pq.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                pq.add(node.right);
            }
        }
    }



}