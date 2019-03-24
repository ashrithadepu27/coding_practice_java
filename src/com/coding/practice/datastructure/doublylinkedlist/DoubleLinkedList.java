package com.coding.practice.datastructure.doublylinkedlist;

import com.coding.practice.datastructure.linkedlist.Node;

public class DoubleLinkedList<T extends Comparable<? super T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    private int MAX_SIZE = Integer.MAX_VALUE;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoubleLinkedList(int size) {
        this();
        this.MAX_SIZE = size;
    }

    public int size() {
        return this.size;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public Node<T> addFirst(T element) {
        return addFirst(new Node<T>(element));
    }

    public Node<T> addFirst(Node<T> node) {
        node.setPrev(null);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            if(size < MAX_SIZE) {
                node.setNext(head);
                head.setPrev(node);
                head = node;
            } else
                return null;
        }
        this.size++;
        return node;
    }

    public Node<T> addLast(T element) {
        return addLast(new Node<T>(element));
    }

    public Node<T> addLast(Node<T> node) {
        node.setNext(null);
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            if(size < MAX_SIZE) {
                tail.setNext(node);
                node.setPrev(tail);
                tail = node;
            } else {
                return null;
            }
        }
        this.size++;
        return node;
    }

    public Node<T> find(T element) {
        return find(new Node<T>(element));
    }

    public Node<T> find(Node<T> node) {
        Node<T> temp = head;
        while(temp != null && !temp.getElement().equals(node.getElement())) {
            temp = temp.getNext();
        }
        if(temp == null || !temp.getElement().equals(node.getElement())) return null;
        return temp;
    }

    public Node<T> remove(T element) {
        return remove(new Node<T>(element));
    }

    public Node<T> remove(Node<T> node) {
        Node<T> temp = find(node);
        if(temp == null) return null;
        Node<T> prev = temp.getPrev();
        prev.setNext(temp.getNext());
        if(temp.hasNext()) temp.getNext().setPrev(prev);
        else tail = prev;
        size--;
        return temp;
    }

    public Node<T> removeLast() {
        if(size == 0) return null;
        Node<T> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
        return temp;
    }

    public Node<T> removeFirst() {
        if(size == 0) return null;
        Node<T> temp = head;
        head = head.getNext();
        head.setPrev(null);
        size--;
        return temp;
    }


    public boolean moveToHead(T element) {
        return moveToHead(new Node<T>(element));
    }

    public boolean moveToHead(Node<T> node) {
        Node<T> temp = remove(node);
        if(temp == null) return false;
        return addFirst(temp) != null;
    }

    public void printDoubleLinkedList() {
        if(head == null) {
            System.out.println("No Element to print");
            return;
        }
        System.out.print("Elements in the List are: ");
        Node<T> temp = head;
        while(temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>(2);
        dll.addFirst(2);   dll.printDoubleLinkedList();
        dll.addFirst(1);   dll.printDoubleLinkedList();
        dll.addLast(3);   dll.printDoubleLinkedList();
        dll.addFirst(5);   dll.printDoubleLinkedList();
        dll.addLast(6);    dll.printDoubleLinkedList();
        dll.moveToHead(3);   dll.printDoubleLinkedList();
        dll.removeLast();   dll.printDoubleLinkedList();
        dll.addLast(10);    dll.printDoubleLinkedList();
        dll.removeFirst();   dll.printDoubleLinkedList();
        dll.addFirst(0);    dll.printDoubleLinkedList();
    }
}
