package com.sbaitman.ctci.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(new LinkedList.ListNode(2));
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        list.insertAtTail(7);

        list.printList();
    }
}
