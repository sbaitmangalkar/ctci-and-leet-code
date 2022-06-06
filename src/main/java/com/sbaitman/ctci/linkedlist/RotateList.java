package com.sbaitman.ctci.linkedlist;

import static com.sbaitman.ctci.linkedlist.ListUtil.printListFromNode;

/**
 * LeetCode 61: Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    public static LinkedList.ListNode rotateList(LinkedList.ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //Find the last element (along with length of the list) and connect it to head
        LinkedList.ListNode last = head;
        int n = 1;
        while(last.next != null) {
            last = last.next;
            n++;
        }

        k = k % n; // Ensures the number of rotations never exceeds size of the linkedlist

        // Make the last node to point to current head
        last.next = head;

        // Find the number of jumps to be made in order to reach the new tail
        // temp.next will be the new head and temp.next will point to null as it is new tail
        int jump = n - k;
        LinkedList.ListNode temp = last;
        while(jump > 0) {
            temp = temp.next;
            jump--;
        }
        LinkedList.ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }

    private static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        LinkedList.ListNode newHead = rotateList(list.head, 2);
        printListFromNode(newHead);
    }
}
