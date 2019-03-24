package com.coding.practice.datastructure.advance;

import java.util.*;

public class LRUCacheQueue implements LRUCache{

    private int maxCacheCapacity;
    private Queue<Integer> cachedElements;
    private Map<Integer, Integer> cachedElementsValue;

    public LRUCacheQueue(int cacheCapacity) {
        this.maxCacheCapacity = cacheCapacity;
        this.cachedElements = new LinkedList<>();
        this.cachedElementsValue = new HashMap<>();
    }

    @Override
    public int get(int key) {
        int val = cachedElementsValue.getOrDefault(key, -1);
        if(val != -1) {
            shuffleCache(key);
            cachedElements.add(key);
        }
        return val;
    }

    private void shuffleCache(int key) {
        Iterator<Integer> it = cachedElements.iterator();
        while(it.hasNext()) {
            if(it.next() == key) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public void put(int key, int value) {
        if(cachedElementsValue.containsKey(key)) {
            shuffleCache(key);
        } else {
            if(cachedElements.size() == maxCacheCapacity) {
                int t = cachedElements.poll();
                cachedElementsValue.remove(t);
            }
        }
        cachedElements.add(key);
        cachedElementsValue.put(key, value);
    }

    private void printCache() {
        System.out.print("Cache Elements: ");
        Iterator it = cachedElements.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
