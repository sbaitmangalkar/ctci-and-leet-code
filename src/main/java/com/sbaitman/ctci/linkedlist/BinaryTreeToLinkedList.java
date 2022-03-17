package com.sbaitman.ctci.linkedlist;

import java.util.Stack;

/**
 * LeetCode 114: Flatten Binary Tree to Linked List
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
public class BinaryTreeToLinkedList {
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

    /**
     * Efficient Without Additional Data Structure: Recursively look for the node with no grandchildren
     * in both left and right child in the left sub-tree. Then store root->right in temp and make root->right=root->left.
     * Insert temp in first NULL valued node present on right of root (root->right = temp).
     * Repeat until it is converted to linked list.
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        // Base case - return if root is NULL
        if (root == null) {
            return;
        }

        // Or if it is a leaf node
        if (root.left == null && root.right == null) {
            return;
        }

        // If root.left children exists then we have
        // to make it node.right (where node is root)
        if (root.left != null) {
            // Move left recursively
            flatten(root.left);

            // Store the root.right in
            // Node named temp
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            // Find the position to insert
            // the stored value
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }

            // Insert the stored value
            current.right = temp;
        }

        // Now call the same function
        // for node.right
        flatten(root.right);
    }

    /**
     * Simple Approach: A simple solution is to use Level Order Traversal using Stack.
     * In level order traversal, keep track of previous node. Make current node as right child of previous and
     * left of previous node as NULL.
     *
     * @param root
     */
    public static void flattenUsingAdditionalDataStructure(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }

    public static void main(String[] args) {

    }
}
