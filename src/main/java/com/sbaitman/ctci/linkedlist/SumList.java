package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 2: Add Two Numbers
 * CTCI LinkedList: SumList problem
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class SumList {
    private static int length(LinkedList.ListNode head) {
        if(head == null) {
            return 0;
        }

        if(head.next == null) {
            return 1;
        }
        int len = 0;
        LinkedList.ListNode current = head;
        while(current != null) {
            current = current.next;
            len += 1;
        }
        return len;
    }

    private static LinkedList.ListNode appendZeros(LinkedList.ListNode head, int count) {
        if(head == null) {
            return head;
        }
        LinkedList.ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }

        while(count != 0) {
            current.next = new LinkedList.ListNode(0);
            current = current.next;
            count--;
        }

        return head;
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

    private static LinkedList createList1() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(2));
        list.insertAtTail(4);
        list.insertAtTail(3);
        //list.insertAtTail(2);
        //list.insertAtTail(5);
        //list.insertAtTail(2);

        // 751 + 365 = 6
        return list;
    }

    private static LinkedList createList2() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(5));
        list.insertAtTail(6);
        list.insertAtTail(4);
        //list.insertAtTail(2);
        //list.insertAtTail(5);
        //list.insertAtTail(2);

        return list;
    }

    private static LinkedList createList3() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(9));
        list.insertAtTail(9);
        list.insertAtTail(9);
        list.insertAtTail(9);
        list.insertAtTail(9);
        list.insertAtTail(9);
        list.insertAtTail(9);
        //list.insertAtTail(2);
        //list.insertAtTail(5);
        //list.insertAtTail(2);

        // 751 + 365 = 6
        return list;
    }

    private static LinkedList createList4() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(9));
        list.insertAtTail(9);
        list.insertAtTail(9);
        list.insertAtTail(9);
        //list.insertAtTail(5);
        //list.insertAtTail(2);

        // 751 + 365 = 6
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

    public static LinkedList.ListNode sum(LinkedList.ListNode l1, LinkedList.ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int len1 = length(l1);
        int len2 = length(l2);
        if(len1 > len2) {
            l2 = appendZeros(l2, len1 - len2);
        } else if(len2 > len1) {
            l1 = appendZeros(l1, len2 - len1);
        }
        LinkedList.ListNode result = new LinkedList.ListNode();
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }

        if(l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if(l1 != null || l2 != null) {
            LinkedList.ListNode more = sum(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    public static void main(String[] args) {
        /*LinkedList list = createList0();
        list.printList();
        int len = length(list.head);
        System.out.println("Length: " + len);

        LinkedList.ListNode head = appendZeros(list.head, 2);
        printListFromNode(head);*/

        LinkedList list1 = createList1();
        LinkedList list2 = createList2();

        LinkedList.ListNode result = sum(list1.head, list2.head, 0);

        printListFromNode(result);

    }
}
