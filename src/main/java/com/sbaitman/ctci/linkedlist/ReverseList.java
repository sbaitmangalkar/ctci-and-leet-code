package com.sbaitman.ctci.linkedlist;

public class ReverseList {
    public static LinkedList.ListNode reverse(LinkedList.ListNode head) {
        if(head == null) {
            return null;
        }

        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = null;
        while(current != null) {
            LinkedList.ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

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
        list.insertAtTail(4);
        list.insertAtTail(3);
        list.insertAtTail(2);
        list.insertAtTail(5);
        list.insertAtTail(2);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        System.out.println();
        LinkedList.ListNode head = reverse(list.head);
        printListFromNode(head);
    }
}
