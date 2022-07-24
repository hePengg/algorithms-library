package com.dap.leecode.hot100;

/**
 * 反转二叉树
 * <li>给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。</li>
 */
public class L226 {

    public static void main(String[] args) {
        // test
        TreeNode root = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        root.left = treeNode2;
        root.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(TreeNodeUtil.levelTraversal(root));
        invertTree(root);
        System.out.println(TreeNodeUtil.levelTraversal(root));
    }

    /**
     * <li>solution 1 : 递归，left、right交换</li>
     * @param root
     * @return
     */
    static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);

        root.left = invertRight;
        root.right = invertLeft;

        return root;
    }
}
