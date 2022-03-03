package com.sbaitman.ctci.linkedlist;

public class ReverseBetweenList {
    public static LinkedList.ListNode reverseBetween(LinkedList.ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }

        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = null;

        while(left > 1) {
            previous = current;
            current = current.next;
            left--; // till starting point of reversal is reached
            right--; // number of spaces from left to go
        }

        LinkedList.ListNode connection = previous; // connect this to head of reversed part of list
        LinkedList.ListNode tail = current; // connect tail of reversed list to rest of the list

        while(right > 0) {
            LinkedList.ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            right--;
        }

        if(connection != null) {
            connection.next = previous;
        } else {
            head = previous;
        }

        tail.next = current;

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
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        System.out.println();
        LinkedList.ListNode head = reverseBetween(list.head, 2, 4);
        printListFromNode(head);
    }
}
