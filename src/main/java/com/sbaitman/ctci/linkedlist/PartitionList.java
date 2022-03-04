package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 86: Partition List
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come
 * before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    public static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(4);
        list.insertAtTail(3);
        list.insertAtTail(2);
        list.insertAtTail(5);
        list.insertAtTail(2);

        return list;
    }

    public static LinkedList createList1() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(3));
        list.insertAtTail(5);
        list.insertAtTail(8);
        list.insertAtTail(5);
        list.insertAtTail(10);
        list.insertAtTail(2);
        list.insertAtTail(1);

        return list;
    }

    public static void printListFromNode(LinkedList.ListNode node) {
        LinkedList.ListNode current = node;
        while(current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
    }

    public static LinkedList.ListNode partition(LinkedList.ListNode head, int x) {
        if(head == null) {
            return null;
        }

        LinkedList.ListNode left = new LinkedList.ListNode();
        LinkedList.ListNode right = new LinkedList.ListNode();
        LinkedList.ListNode lTail = left;
        LinkedList.ListNode rTail = right;

        while(head != null) {
            if(head.data < x) {
                lTail.next = head;
                lTail = lTail.next;
            } else {
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }
        lTail.next = right.next;
        rTail.next = null;

        return left.next;
    }

    public static void main(String[] args) {
        LinkedList list = createList1();
        LinkedList.ListNode result = partition(list.head, 5);

        printListFromNode(result);
    }
}
