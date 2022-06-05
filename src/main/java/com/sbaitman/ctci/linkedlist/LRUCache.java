package com.sbaitman.ctci.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146: LRU Cache
 * Design a data structure that follows the constraints of Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
    // Using linked list and hash map
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int cacheCapacity;

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.next = head;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null) {
            node.value = value;
            remove(node);
            add(node);
        } else {
            if(nodeMap.size() >= cacheCapacity) {
                nodeMap.remove(tail.previous.key);
                remove(tail.previous);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            add(newNode);
        }
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node != null) {
            int result = node.value;
            remove(node);
            add(node);
            return result;
        }
        return -1;
    }

    public void add(Node node) {
        Node headnext = head.next;
        node.next = headnext;
        headnext.previous = node;
        head.next = node;
        node.previous = head;
    }

    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.previous;

        nextNode.previous = prevNode;
        prevNode.next = nextNode;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        System.out.println(cache);
        cache.put(2, 2);
        System.out.println(cache);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "nodeMap=" + nodeMap +
                '}';
    }
}

class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node() {

    }
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
