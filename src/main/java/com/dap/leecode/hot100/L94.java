package com.dap.leecode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class L94 {

    public static void main(String[] args) {
        // test
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        System.out.println(inorderTraversal(root));

    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * 中序遍历，根节点在中，left-root-right，先序、后序解题思路同理
     * @param root
     * @param result
     */
    static void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            // 遍历左子树
            inorder(root.left, result);
            // 访问根节点
            result.add(root.val);
            // 遍历右子树
            inorder(root.right, result);
        }
    }

}
