package com.dap.leecode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {

    /**
     * 层次遍历：一层一层从左到右
     * @param root
     * @return
     */
    public static List<Integer> levelTraversal(TreeNode root) {
        // TOTO
        // 结果存放
        List<Integer> result = new ArrayList<>();

        // 处理队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        // 先放入root节点
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            // 先放左边
            if (node.left != null) {
                queue.offer(node.left);
            }

            // 再放右边
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }

    /**
     * 中序遍历：left-root-right
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // TOTO
        return null;
    }
}
