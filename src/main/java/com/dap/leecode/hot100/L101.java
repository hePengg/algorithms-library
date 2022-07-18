package com.dap.leecode.hot100;

/**
 * 对称二叉树
 */
public class L101 {

    public static void main(String[] args) {
        // test
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        root.left = treeNode2;
        root.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println(isSymmetric(root));
    }

    /**
     * 如果一个树是对称二叉树，那么它的左子树 和 右子树 是对称的，如下
     * <li>tree1.root = tree2.root  </li>
     * <li>tree1.left = tree2.right </li>
     * <li>tree1.right = tree2.left </li>
     * @param root
     * @return
     */
    static boolean isSymmetric(TreeNode root) {
        return checkSubTree(root, root);
    }

    static boolean checkSubTree(TreeNode subTree1, TreeNode subTree2) {
        if (subTree1 == null && subTree2 == null) {
            return true;
        }

        if (subTree1 == null || subTree2 == null) {
            return false;
        }

        return subTree1.val == subTree2.val && checkSubTree(subTree1.left, subTree2.right)
                && checkSubTree(subTree1.right, subTree2.left);
    }
}
