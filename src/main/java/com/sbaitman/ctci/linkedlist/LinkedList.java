package com.sbaitman.ctci.linkedlist;

public class LinkedList {
    ListNode head;

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void insertAtTail(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            return;
        } else {
            ListNode last = head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }

    public void remove(int data) {
        if(head == null) {
            return;
        }

        if(head.data == data) {
            head = head.next;
        } else {
            ListNode current = head;
            ListNode previous = null;

            while(current != null && current.data != data) {
                previous = current;
                current = current.next;
            }

            if(current != null) {
                previous.next = current.next;
            }

            if(current == null) {
                System.out.println("Data: " + data + " not found in list");
            }
        }
    }

    public void printList() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
    }

    static class ListNode {
        ListNode next;
        int data;

        public ListNode() {

        }

        public ListNode(int data) {
            this.next = null;
            this.data = data;
        }

        public ListNode(ListNode next, int data) {
            this.next = next;
            this.data = data;
        }
    }
}
