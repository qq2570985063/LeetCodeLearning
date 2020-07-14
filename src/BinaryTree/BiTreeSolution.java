package BinaryTree;

import java.util.*;

public class BiTreeSolution {
    // 617 合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    // 226 翻转二叉树
    public TreeNode invertTree(TreeNode node){
        if(node == null) return null;

        TreeNode temp = node;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }

    // 104 二叉树的最大深度
    public int maxDepth(TreeNode node){
        if(node == null) return 0;

        int leftD = maxDepth(node.left);
        int rightD = maxDepth(node.right);
        int depth = Math.max(leftD, rightD) + 1;

        return depth;
    }

    // 538 二叉搜索树转累加树
    int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    // 437 路径总和3
    public int pathSum(TreeNode node, int sum){
        if(node == null) return 0;
        return pathSumHelper(node, sum) + pathSum(node.left, sum) + pathSum(node.right, sum);
    }
    private int pathSumHelper(TreeNode node, int sum){
        if(node == null) return 0;

        int res = 0;
        if(node.val == sum) res++;
        res += pathSumHelper(node.left, sum-node.val);
        res += pathSumHelper(node.right, sum-node.val);
        return res;
    }

    // 101 对称二叉树
    public boolean isSymmetric(TreeNode root){
        return isSymmetricHelper(root, root);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val){
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }
        else return false;
    }

    // 543 二叉树的直径
    int diameter;
    public int diameterOfBinaryTree(TreeNode root){
        diameter = 1;
        diameterHelper(root);
        return diameter-1;
    }
    private int diameterHelper(TreeNode node){
        if(node == null) return 0;
        int leftDepth = diameterHelper(node.left);
        int rightDepth = diameterHelper(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 94 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorderList(root, list);
        return list;
    }
    private void inorderList(TreeNode root, List list){
        if(root == null) return;
        else{
            inorderList(root.left, list);
            list.add(root.val);
            inorderList(root.right, list);
        }
    }
    private void inorderList_Iteration(TreeNode root, List list){
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    // 114 原地展开二叉树为链表
    public void flatten(TreeNode root){
        if(root == null) return;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = temp;

        flatten(root.right);
    }
    public void flatten_Iteration(TreeNode root){
        TreeNode temp;
        while(root != null){
            if(root.left == null) {
                root = root.right;
                continue;
            }

            temp = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode p = root;
            while(p.right != null){
                p = p.right;
            }
            p.right = temp;

            root = root.right;
        }
    }

    // 105 从前序和中序遍历序列中构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == preorder[0]){
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i+1);
                int[] preRight = Arrays.copyOfRange(preorder, i+1, preorder.length);

                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i+1, inorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }

        return root;
    }

    // 96 不同的二叉搜索树
    public int numTrees(int n){
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                res[i] += res[j-1] * res[i-j];
            }
        }
        return res[n];
    }

    // 236 二叉树的最近公共祖先
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        res = null;
        hasPorQ(root, p, q);
        return res;
    }
    private boolean hasPorQ(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        int left = hasPorQ(root.left, p, q) ? 1 : 0;
        int right = hasPorQ(root.right, p, q) ? 1 : 0;
        int mid = root == p || root == q ? 1 : 0;

        if(left + right + mid >= 2) res = root;
        return left + right + mid > 0;
    }

    // 102 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> subRes = new LinkedList<>();
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                root = queue.poll();
                subRes.add(root.val);
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            res.add(subRes);
        }
        return res;
    }

    // 337 打家劫舍3
    public int rob(TreeNode root){
        if(root == null) return 0;

        int money = root.val;
        if(root.left != null) money += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) money += rob(root.right.left) + rob(root.right.right);

        return Math.max(money, rob(root.left) + rob(root.right));
    }

    // 98 验证二叉搜索树
    public boolean isValidBST(TreeNode root){
        return BSTHelper(root, null, null);
    }
    // lower <= root.val <= upper
    public boolean BSTHelper(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;

        if(lower != null && root.val <= lower) return false;
        if(upper != null && root.val >= upper) return false;

        if(!BSTHelper(root.left, lower, root.val)) return false;
        if(!BSTHelper(root.right, root.val, upper)) return false;

        return true;
    }

    // 124 二叉树中的最大路径和
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        path(root);
        return maxSum;
    }
    private int path(TreeNode root){
        if(root == null) return 0;

        int leftPath = Math.max(0, path(root.left));
        int rightPath = Math.max(0, path(root.right));

        maxSum = Math.max(maxSum, leftPath + rightPath + root.val);

        return Math.max(leftPath, rightPath) + root.val;
    }
}
