package com.dap.leecode.hot100;

/**
 * 合并二叉树
 *
 * <p>给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 * </p>
 */
public class L617 {

    public static void main(String[] args) {
        // test
        TreeNode root1 = new TreeNode(1);
        TreeNode root12 = new TreeNode(3);
        TreeNode root13 = new TreeNode(2);
        TreeNode root14 = new TreeNode(5);

        root1.left = root12;
        root1.right = root13;

        root12.left = root14;

        TreeNode root2 = new TreeNode(2);
        TreeNode root22 = new TreeNode(1);
        TreeNode root23 = new TreeNode(3);
        TreeNode root24 = new TreeNode(4);
        TreeNode root25 = new TreeNode(7);

        root2.left = root22;
        root2.right = root23;
        root22.right = root24;
        root23.right = root25;

        System.out.println(TreeNodeUtil.levelTraversal(root1));
        System.out.println(TreeNodeUtil.levelTraversal(root2));
        System.out.println(TreeNodeUtil.levelTraversal(mergeTrees(root1, root2)));
    }

    static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode mergeTree = new TreeNode(root1.val + root2.val);
        mergeTree.left = mergeTrees(root1.left, root2.left);
        mergeTree.right = mergeTrees(root1.right, root2.right);
        return mergeTree;
    }
}
