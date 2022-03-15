package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 25: Reverse Nodes in k-Group
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseKGroup {
    public static LinkedList.ListNode reverseKGroup(LinkedList.ListNode head, int k) {
        LinkedList.ListNode root = new LinkedList.ListNode();
        root.next = head;
        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = root;

        while (current != null) {
            LinkedList.ListNode tail = current;
            int listIndex = 0;

            // move up to kth index
            while(current != null && listIndex < k) {
                current = current.next;
                listIndex++;
            }
            if(listIndex != k) {
                previous.next = tail;
            } else {
                previous.next = reverse(tail, k);
                previous = tail;
            }
        }
        return root.next;
    }

    private static LinkedList.ListNode reverse(LinkedList.ListNode head, int k) {
        if(head == null) {
            return null;
        }

        LinkedList.ListNode current = head;
        LinkedList.ListNode previous = null;

        while(current != null && k-- > 0) {
            LinkedList.ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    // Different approach
    public static LinkedList.ListNode reverseKGroupApproach1(LinkedList.ListNode head, int k) {
        LinkedList.ListNode dummy = new LinkedList.ListNode();
        dummy.next = head;
        LinkedList.ListNode groupPrevious = dummy;

        while(true) {
            LinkedList.ListNode kthNode = getKthNode(groupPrevious, k);
            if(kthNode == null) {
                break;
            }

            LinkedList.ListNode groupNext = kthNode.next;

            //Reverse
            LinkedList.ListNode previous = kthNode.next;
            LinkedList.ListNode current = groupPrevious.next;
            while(current != groupNext) {
                LinkedList.ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            LinkedList.ListNode temp = groupPrevious.next;
            groupPrevious.next = kthNode;
            groupPrevious = temp;
        }
        return dummy.next;
    }

    private static LinkedList.ListNode getKthNode(LinkedList.ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
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
        ListUtil.printListFromNode(list.head);
        LinkedList.ListNode result = reverseKGroup(list.head, 3);
        ListUtil.printListFromNode(result);
    }
}
