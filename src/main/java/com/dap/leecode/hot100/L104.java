package com.dap.leecode.hot100;

/**
 * 二叉树的最大深度
 */
public class L104 {

    public static void main(String[] args) {
        // test
        TreeNode root = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        root.left = treeNode2;
        root.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(maxDepth(root));
    }

    /**
     * 递归
     * <li>Max(l, r) + 1, l表示左子树的最大深度，r表示右子树的最大深度</li>
     * <li>左子树和右子树可以用同样方式计算</li>
     * <li>访问到空节点的时候退出，返回0</li>
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
