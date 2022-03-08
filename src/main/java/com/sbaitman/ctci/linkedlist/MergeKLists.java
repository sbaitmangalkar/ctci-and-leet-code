package com.sbaitman.ctci.linkedlist;

/**
 * LeetCode 23: Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKLists {
    public static LinkedList.ListNode mergeKLists(LinkedList.ListNode[] lists) {
        if(lists == null || lists.length <= 0) {
            return null;
        }

        if(lists.length == 1) {
            return lists[0];
        }

        LinkedList.ListNode l1 = lists[0];
        LinkedList.ListNode l2 = lists[1];
        LinkedList.ListNode result = mergeLists(l1, l2);
        if(lists.length > 2) {
            for(int i = 2; i < lists.length; i++) {
                result = mergeLists(result, lists[i]);
            }
        } else {
            return result;
        }
        return result;
    }

    private static LinkedList.ListNode mergeLists(LinkedList.ListNode l1, LinkedList.ListNode l2) {
        LinkedList.ListNode result = new LinkedList.ListNode();
        LinkedList.ListNode rhead = result;

        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                rhead.next = l1;
                l1 = l1.next;
            } else {
                rhead.next = l2;
                l2 = l2.next;
            }
            rhead = rhead.next;
        }

        if(l1 != null) {
            rhead.next = l1;
        }

        if(l2 != null) {
            rhead.next = l2;
        }

        return result.next;
    }

    public static void main(String[] args) {
        
        LinkedList.ListNode[] lists = {};
    }

}
