package com.java.datastructure.linkedlist;

public class ReverseLL {

    public static Node<Integer> reverse(Node<Integer> head) {
        if(head == null || head.getNext() == null) return head;
        Node<Integer> current = head;
        return reverse(head, current);
    }

    public static Node<Integer> reverse(Node<Integer> head, Node<Integer> current) {
        if(current == null || current.getNext() == null) return head;
        Node<Integer> temp = current.getNext().getNext();
        current.getNext().setNext(head);
        head = current.getNext();
        current.setNext(temp);
        if(current.getNext() != null)
            return reverse(head, current);
        return head;
    }

//    private static Node<Integer> reverseGroup(Node<Integer> head, Node<Integer>)

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= 10; i++)
            list.add(i);

        Node<Integer> head = reverse(list.getHead());
        Node<Integer> temp = head;

        while(temp != null) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
    }
}
