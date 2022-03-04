package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 109:
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the
 * two subtrees of every node never differ by more than 1.
 */
public class ListToBST {
    public static TreeNode sortedListToBST(LinkedList.ListNode head) {
        if(head == null) {
            return null;
        }

        LinkedList.ListNode mid = mid(head);
        TreeNode root = new TreeNode(mid.data);

        if(head == mid) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private static LinkedList.ListNode mid(LinkedList.ListNode head) {
        LinkedList.ListNode slow = head;
        LinkedList.ListNode fast = head;
        LinkedList.ListNode previous = head;

        while(fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(previous != null) {
            previous.next = null;
        }
        return slow;
    }

    private static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(-10));
        list.insertAtTail(-3);
        list.insertAtTail(0);
        list.insertAtTail(5);
        list.insertAtTail(9);
        return list;
    }

    private static void printListFromNode(LinkedList.ListNode node) {
        LinkedList.ListNode current = node;
        while(current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        System.out.println();
        TreeNode treeNode = sortedListToBST(list.head);
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
