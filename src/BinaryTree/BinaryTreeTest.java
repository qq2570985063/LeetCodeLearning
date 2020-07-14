package BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);

        // pre:1 2 4 5 8 9 3 6 7
        // in:4 2 8 5 9 1 6 3 7
        // post: 4 8 9 5 2 6 7 3 1
        // level: 1 2 3 4 5 6 7 8 9
//        BiTreeSort test = new BiTreeSort();
//        test.inOrder_Iteration(node);
//        test.preOrder_Recursion(node);
//        test.preOrder_Iteration(node);
//        test.postOrder_Iteration(node);
//        test.levelOrder(node);
    }
}
