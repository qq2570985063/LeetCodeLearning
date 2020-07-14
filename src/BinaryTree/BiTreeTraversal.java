package BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

public class BiTreeTraversal {
    // 递归
    public void preOrder_Recursion(TreeNode node){
        if(node == null) return;
        System.out.println(node.val);
        preOrder_Recursion(node.left);
        preOrder_Recursion(node.right);
    }

    // 迭代
    public void preOrder_Iteration(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                System.out.println(node.val);
                node = node.left;
            }
            node = stack.pop().right;
        }
    }

    public void inOrder_Iteration(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }

    public void postOrder_Iteration(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tag = new Stack<>();

        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                tag.push(1);
                node = node.left;
            }
            else{
                if(tag.peek()==2){
                    tag.pop();
                    System.out.println(stack.pop().val);
                }
                else{
                    tag.pop();
                    tag.push(2);
                    node = stack.peek().right;
                }
            }
        }
    }

    public void levelOrder(TreeNode node){
        TreeNode temp = node;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(temp);

        while(!list.isEmpty()){
            temp = list.poll();
            System.out.println(temp.val);
            if(temp.left!=null) list.add(temp.left);
            if(temp.right!=null) list.add(temp.right);
        }
    }
}
