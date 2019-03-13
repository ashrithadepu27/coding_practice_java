package com.java.datastructure.linkedlist;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedList<T extends Comparable<? super T>> {

    class Node<T extends Comparable<? super T>> {

        private T data;
        private Node<T> next;


        Node(T data) {
            this.data = data;
            this.next = null;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
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

        public int compareTo(T o) {
            return (this.data).compareTo(o);
        }
    }

    Node<T> head, tail;
    int size;

    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return this.size;
    }

    public void incrementSize() {
        this.size += 1;
    }

    public void decrementSize() {
        this.size -= 1;
    }

    public void add(T e) {
        add(new Node<>(e));
    }

    public void add(Node<T> e) {
        if(this.getHead() == null) {
            this.setHead(e);
            this.setTail(e);
        } else {
            this.getTail().setNext(e);
            this.setTail(e);
        }
        this.incrementSize();
    }

    public T find(T e) {
        Iterator<T> it = this.iterator();

        while(it.hasNext()) {
            T current = it.next();
            if(e.equals(current)) {
                return current;
            }
        }
        return null;
    }

    public boolean contains(T e) {
        T f = find(e);
        return f.equals(e);
    }

    // Delete from last
    public T delete() {
        if(this.getHead() == null) return null;
//        this.
        return null;
    }

    public Iterator<T> iterator() {

        Iterator<T> it = new Iterator<T>() {
            Node<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor.getNext() != null && cursor.getNext().getElement() != null;
            }

            @Override
            public T next() {
                if(this.hasNext()) {
                    cursor = cursor.getNext();
                    return cursor.getElement();
                }
                else {
                    throw new NoSuchElementException();
                }
            }
        };
        return it;
    }

    public void printList() {
        Iterator it = this.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + "  ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> LL = new LinkedList<>();
        System.out.println("--------Menu Options Usage--------");
        System.out.println("Add: 1 <x>");
        System.out.println("Remove: 2");
        System.out.println("Length of the queue: 3");
        System.out.println("Print the queue: 4");
        System.out.println("Exit: 5");
        System.out.println("----------------------------");

        while_loop:
        while (in.hasNext()) {
            int com = in.nextInt();
            switch (com) {
                case 1: // Return element at the front of the queue without removing it
                    try {
                        LL.add(in.nextInt());
                        System.out.println("Operation was successful");
                    } catch(Exception ex) {
                        System.out.println("Operation failed. " + ex.getMessage());
                    }
                    break;
                case 2: // Remove element at the front of the queue
                    try {
                        LL.delete();
                        System.out.println("Operation was successful");
                    } catch(Exception ex) {
                        System.out.println("Operation failed. " + ex.getMessage());
                    }
                    break;
                case 3: // Return the size of the queue
                    System.out.println("Size of the Bounded Queue is "+ LL.getSize());
                    break;
                case 4:
                    System.out.println("Elements in the Queue:");
                    LL.printList();
                    break;
                default: // Exit loop
                    break while_loop;
            }
        }
    }
}
