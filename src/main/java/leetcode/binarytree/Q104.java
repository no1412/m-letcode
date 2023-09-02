package leetcode.binarytree;

import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104 二叉树的最大深度</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ll
 */
public class Q104 {

    /**
     * 化解为根据子树的高度来进行求解
     * 递归每个节点的子树
     *
     * @param root 根节点
     * @return 二叉树最多深度
     */
    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        // 左子树高度
        int left = maxDepth(root.left);
        // 右子树高度
        int right = maxDepth(root.right);

        // 左右子树的最大高度 + 根节点高度
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode15 = new TreeNode();
        treeNode15.val = 15;

        TreeNode treeNode9 = new TreeNode();
        treeNode9.val = 9;
        treeNode9.left = new TreeNode();
        treeNode9.right = new TreeNode();

        TreeNode treeNode7 = new TreeNode();
        treeNode7.val = 7;

        TreeNode treeNode20 = new TreeNode();
        treeNode20.val = 20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 3;
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        System.out.println(maxDepth(treeNode3));
    }

}

