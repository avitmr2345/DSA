package Striver.Module13;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        System.out.println(inorderTraversal(root));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    public static void preorderHelper(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }

        // pre order traversal (NLR), used for copying the tree
        array.add(root.val);
        preorderHelper(root.left, array);
        preorderHelper(root.right, array);
    }
}
