package com.java.datastructure.linkedlist;

public class Node<T extends Comparable<? super T>> {

    private T key;
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public void setElement(T data) {
        this.data = data;
    }

    public T getElement() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public boolean hasNext() {
        return this.getNext() != null;
    }

    public boolean hasPrev() {
        return this.getPrev() != null;
    }

    public int compareTo(T o) {
        return (this.data).compareTo(o);
    }
}