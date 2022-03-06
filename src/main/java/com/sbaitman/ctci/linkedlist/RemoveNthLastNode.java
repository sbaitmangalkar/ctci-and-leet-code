package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 19: Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 */
public class RemoveNthLastNode {
    public static LinkedList.ListNode removeNthFromEnd(LinkedList.ListNode head, int n) {
        if(head == null || head.next == null) {
            return null;
        }
        // Find the length of the list
        int len = 1;
        LinkedList.ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            len++;
        }

        // if M is length of the list, then the nth node from the end is (M - n + 1)th node from beginning
        int nodeCount = len - n;
        if(nodeCount == 0) {
            return head.next;
        }
        // Traverse the list till (M - n + 1)th node is reached.
        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = null;
        while(current != null && nodeCount > 0) {
            previous = current;
            current = current.next;
            nodeCount--;
        }

        // Once (M - n + 1)th node is reached, delete that node and connect the (M - n)th node and (M - n + 2)th node
        if(current != null) {
            previous.next = current.next;
            current.next = null;
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
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        return list;
    }

    private static LinkedList createList1() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        /*list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);*/

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList1();
        printListFromNode(list.head);
        System.out.println();
        LinkedList.ListNode res = removeNthFromEnd(list.head, 1);
        printListFromNode(res);
    }
}
