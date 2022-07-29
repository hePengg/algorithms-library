package com.dap.leecode.hot100;

/**
 * 二叉树的直径
 * <li>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。</li>
 */
public class L543 {

    /** 直径的节点数 */
    static int maxNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterBinaryTree(root));
    }

    /**
     * Depth（深度优先搜索）
     * <li>路径的长度为该路径经过的节点数减一，边的长度</li>
     * <li>提示，不一定经过根节点</li>
     * <li>最大的 left 深度 + right 深度 - 1 （边）</li>
     *
     * @param root
     * @return
     */
    static int diameterBinaryTree(TreeNode root) {
        // 节点最小为1，root
        maxNode = 1;
        maxDepth(root);
        // 边 = 节点 - 1
        return maxNode - 1;
    }

    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        maxNode = Math.max(leftDepth + rightDepth + 1, maxNode);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
