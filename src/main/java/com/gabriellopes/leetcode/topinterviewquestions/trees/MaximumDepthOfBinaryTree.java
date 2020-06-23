package com.gabriellopes.leetcode.topinterviewquestions.trees;

public class MaximumDepthOfBinaryTree {

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

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger + 1;
    }

    public static void main(String[] args) {
        TreeNode four = new TreeNode(4);

        TreeNode fifteen = new TreeNode(15, four, null);
        TreeNode seven = new TreeNode(7);

        TreeNode nine = new TreeNode(9);

        TreeNode twenty = new TreeNode(20, fifteen, seven);

        TreeNode root = new TreeNode(3, nine, twenty);

        System.out.println(maxDepth(root));
    }
}
