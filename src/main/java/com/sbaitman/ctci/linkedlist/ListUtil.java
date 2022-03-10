package com.sbaitman.ctci.linkedlist;

public class ListUtil {
    public static void printListFromNode(LinkedList.ListNode node) {
        LinkedList.ListNode current = node;
        while(current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
        System.out.println();
    }
}
