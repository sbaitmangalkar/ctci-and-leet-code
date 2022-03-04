package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 61: Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {
    public static LinkedList.ListNode rotateList(LinkedList.ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        // Find length and tail of LinkedList
        LinkedList.ListNode tail = head;
        int n = 1;
        while(tail.next != null) {
            tail = tail.next;
            n++;
        }

        //Adjust k
        k = k % n;

        // If k == 0, then no need to move any nodes
        if(k == 0) {
            return head;
        }

        // Find the number of steps to move in order to find the new head
        int stepsToNewHead = n - k;
        //Create a cycle by connecting tail to head
        tail.next = head;
        //Find the new tail
        LinkedList.ListNode newTail = tail;
        while(stepsToNewHead > 0) {
            newTail = newTail.next;
            stepsToNewHead--;
        }

        // once new tail is found, then newHead is the next node of newTail
        LinkedList.ListNode newHead = newTail.next;
        //break the cycle
        newTail.next = null;
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
        LinkedList.ListNode newHead = rotateList(list.head, 2);
        printListFromNode(newHead);
    }
}
