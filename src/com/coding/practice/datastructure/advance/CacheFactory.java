package com.coding.practice.datastructure.advance;

public class CacheFactory {

    public static void main(String[] args) {
        int capacity = 2;
        System.out.println("LRU Cached using Queue:");
        testCache(new LRUCacheQueue(capacity));
        System.out.println("---------------------------------");
        System.out.println("LRU Cached using Double Linked List:");
        testCache(new LRUCacheDLL(capacity));
    }

    public static void testCache(LRUCache cache) {
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
