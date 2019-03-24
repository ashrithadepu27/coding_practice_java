package com.coding.practice.datastructure.advance;

import java.util.Arrays;

public class MinHeap {

    int[] heap;
    private int heapSize;
    private int capacity;

    MinHeap()   {
        heap = new int[15];
        heapSize = 0;
        capacity = 15;
    }

    MinHeap(int size)   {
        heap = new int[15];
        heapSize = 0;
        capacity = size;
    }

    int size() {
        return heapSize;
    }

    int capacity()  {
        return capacity;
    }

    int get(int index)  {
        if(index < heapSize && index > -1)
            return heap[index];
        else
            throw new IndexOutOfBoundsException("Index out of bound");
    }

    int parentIndex(int current)    {
        if(current < 1)
            return -1;
        return (current-1)/2;
    }

    int leftChildIndex(int current) {
        return current*2 +1;
    }

    int rightChildIndex(int current)    {
        return current*2 +2;
    }

    void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    int getMin()    {
        if(heapSize == 0)
            throw new IllegalStateException();
        return heap[0];
    }

    int getHeight() {
        return (int) Math.floor(Math.log(heapSize));
    }

    int extractMin(){
        if(heapSize == 0)
            throw new IllegalStateException();
        int min = heap[0];
        swap(0, heapSize);
        heapSize = heapSize -1;
        heapifyDown(0);
        return min;
    }

    void delete(int key) {

    }

    void insert(int key) {

        if(heapSize < capacity) {
            heap[heapSize] = key;
            heapSize++;
        }
        else    {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
            heap[heapSize] = key;
            heapSize++;
        }
        heapifyUp();
    }

    void heapifyUp()    {
        int index = heapSize - 1;
        while(index > 0 && heap[index] < heap[parentIndex(index)])  {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    void heapifyDown(int i)  {
        int l = leftChildIndex(i);
        int r = rightChildIndex(i);
        int smallest = i;

        if(l < heapSize && heap[l] < heap[i])
            smallest = l;

        if(r < heapSize && heap[r] < heap[smallest])
            smallest = r;

        if(smallest != i)   {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    void decreaseKey(int index, int updateValue)  {
        heap[index] = updateValue;
        while(index > 0 && updateValue < heap[parentIndex(index)])  {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    void printHeap(){
        System.out.println();
        for(int i = 0; i < heapSize; i++)   {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args)  {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(12);
        minHeap.insert(13);
        minHeap.insert(14);
        minHeap.insert(15);
        minHeap.insert(16);
        minHeap.insert(20);
        minHeap.insert(-5);
        minHeap.insert(-4);
        minHeap.printHeap();
        System.out.println();
        System.out.println("Min: " + minHeap.extractMin());
        System.out.println("Size: " + minHeap.size());
        System.out.println("Capacity: " + minHeap.capacity());
        System.out.println("Height: " + minHeap.getHeight());
    }
}
