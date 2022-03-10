package com.sbaitman.ctci.linkedlist;

import static com.sbaitman.ctci.linkedlist.ListUtil.printListFromNode;

/**
 * LeetCode 82: Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list. Return the linked list sorted as well.
 */
public class RemoveAllDuplicates {
    public static LinkedList.ListNode removeDuplicates(LinkedList.ListNode head) {
        if(head == null) {
            return null;
        }
        LinkedList.ListNode dummy = new LinkedList.ListNode();
        dummy.next = head;
        LinkedList.ListNode previous = dummy;

        LinkedList.ListNode current = head;

        while(current != null) {
            if(current.next != null && current.data == current.next.data) {
             while(current.next != null && current.data == current.next.data) {
                 current = current.next;
             }
             previous.next = current.next; // connect next of previous to next of head
            } else {
                previous = previous.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    private static LinkedList createList() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(4);
        list.insertAtTail(4);
        list.insertAtTail(5);
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList();
        printListFromNode(list.head);
        LinkedList.ListNode head = removeDuplicates(list.head);
        printListFromNode(head);
    }

}
