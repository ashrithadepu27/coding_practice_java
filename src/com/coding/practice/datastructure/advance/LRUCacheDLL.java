package com.coding.practice.datastructure.advance;

import com.coding.practice.datastructure.doublylinkedlist.DoubleLinkedList;
import com.coding.practice.datastructure.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDLL implements LRUCache {

    private int maxCacheCapacity;
    private DoubleLinkedList<Integer> cachedList;
    private Map<Integer, Node<Integer>> cachedElementsValue;

    public LRUCacheDLL(int cacheCapacity) {
        this.maxCacheCapacity = cacheCapacity;
        this.cachedList = new DoubleLinkedList<Integer>(cacheCapacity);
        this.cachedElementsValue = new HashMap<>();
    }

    @Override
    public int get(int key) {
        Node<Integer> temp = cachedElementsValue.getOrDefault(key, null);
        if(temp == null) return -1;
        cachedList.moveToHead(key);
        return temp.getElement();
    }

    @Override
    public void put(int key, int value) {
        if(cachedElementsValue.containsKey(key)) {
            cachedList.moveToHead(key);
        } else {
            if(cachedList.size() == maxCacheCapacity) {
                Node<Integer> temp = cachedList.removeLast();
                cachedElementsValue.remove(temp.getElement());
            }
        }
        Node<Integer> node = cachedList.addFirst(key);
        cachedElementsValue.put(key, node);
    }
}
