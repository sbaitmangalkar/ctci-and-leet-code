package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 24: Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
public class SwapNodes {
    public static LinkedList.ListNode swapPairs(LinkedList.ListNode head) {
        LinkedList.ListNode temp = new LinkedList.ListNode();
        temp.next = head;
        LinkedList.ListNode current = temp;

        while(current.next != null && current.next.next != null) {
            LinkedList.ListNode firstNode = current.next;
            LinkedList.ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }
        return temp.next;
    }

    private static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);

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
        LinkedList.ListNode result = swapPairs(list.head);
        printListFromNode(result);
    }
}
