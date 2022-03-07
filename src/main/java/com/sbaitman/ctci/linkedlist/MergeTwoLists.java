package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 21: Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoLists {
    public static LinkedList.ListNode mergeTwoLists(LinkedList.ListNode list1, LinkedList.ListNode list2) {
        LinkedList.ListNode result = new LinkedList.ListNode();
        LinkedList.ListNode rhead = result;

        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                rhead.next = list1;
                list1 = list1.next;
            } else {
                rhead.next = list2;
                list2 = list2.next;
            }
            rhead = rhead.next;
        }

        // Grab that last list1 node
        if(list1 != null) {
            rhead.next = list1;
        }

        // Grab that last list2 node
        if(list2 != null) {
            rhead.next = list2;
        }

        return result.next;
    }

    private static int length(LinkedList.ListNode head) {
        if(head == null) {
            return 0;
        }
        int len = 1;
        while(head.next != null) {
            head = head.next;
            len++;
        }
        return len;
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
        list.insertAtTail(4);

        return list;
    }

    private static LinkedList createList1() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(3);
        list.insertAtTail(4);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list1 = createList0();
        LinkedList list2 = createList1();
        LinkedList.ListNode result = mergeTwoLists(list1.head, list2.head);
        printListFromNode(result);
    }
}
