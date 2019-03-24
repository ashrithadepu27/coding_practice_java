package com.coding.sites.geeksforgeeks;

public class DetectCycle {

    class Node {
        int data;
        Node next;

        Node()  {
            this.next = null;
        }

        Node(int data)  {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args)  {

        DetectCycle dc = new DetectCycle();
        Node head = dc.new Node();
        Node tail = dc.new Node();
        int i = 5;
        while(i > 0) {
            Node newNode = dc.new Node(i);
            if(head == null)    {
                head = newNode;
                tail = newNode;
            }
            else    {
                tail.next = newNode;
                tail = tail.next;
            }
            i--;
        }
        System.out.println(dc.hasCycle(head));
    }

    boolean hasCycle(Node head) {
        if (head == null)
            return false;
        Node slow, fast;
        slow = head;
        fast = head;

        while (true) {

            slow = slow.next;

            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;

            if (slow == null || fast == null)
                return false;

            if (slow == fast)
                return true;
        }
    }
}
