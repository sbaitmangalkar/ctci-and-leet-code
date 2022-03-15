package com.sbaitman.ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static com.sbaitman.ctci.linkedlist.ListUtil.printListFromNode;

/**
 * CTCI
 */
public class RemoveDuplicates {
    public static LinkedList.ListNode removeDuplicates(LinkedList.ListNode head) {
        if(head == null) {
            return null;
        }
        Set<Integer> table = new HashSet<>();

        LinkedList.ListNode previous = null;
        LinkedList.ListNode current = head;

        while(current != null) {
            if(table.contains(current.data)) {
                previous.next = current.next;
            } else {
                previous = current;
                table.add(current.data);
            }
            current = current.next;
        }
        return head;
    }

    private static LinkedList createList0() {
        LinkedList list = new LinkedList(new LinkedList.ListNode(1));
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(2);
        list.insertAtTail(5);
        list.insertAtTail(4);

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = createList0();
        printListFromNode(list.head);
        LinkedList.ListNode head = removeDuplicates(list.head);
        printListFromNode(head);
    }
}
