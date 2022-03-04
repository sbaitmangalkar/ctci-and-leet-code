package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 83: Removing Duplicates from sorted List
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
public class RemoveDuplicatesSortedList {
    public static LinkedList.ListNode removeDuplicates(LinkedList.ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        LinkedList.ListNode current = head;
        while(current != null && current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    private static void printListFromNode(LinkedList.ListNode node) {
        LinkedList.ListNode current = node;
        while(current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
    }

    private static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(4);
        list.insertAtTail(5);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        System.out.println();
        LinkedList.ListNode head = removeDuplicates(list.head);
        printListFromNode(head);
    }
}
