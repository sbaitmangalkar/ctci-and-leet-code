package com.sbaitman.ctci.stringsandarrays;

/**
 * LeetCode 108
 */
public class ArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    private static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int midpoint = left + (right - left) / 2;

        TreeNode root = new TreeNode(midpoint);

        root.left = constructTreeFromArray(nums, left, midpoint - 1);
        root.right = constructTreeFromArray(nums, midpoint + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }

}

class TreeNode {
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
