package com.java.datastructure.advance;

public class BinarySearchTree {

    class Node  {

        int key;
        Node leftChild;
        Node rightChild;
        Node parent;

        Node(int key)  {

            this.key = key;
            this.leftChild = this.rightChild = this.parent = null;
        }
    }

    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public Node getRoot()    {
        return root;
    }

    public void insert(int key)    {

        Node prev = null;
        Node next = root;
        while(next != null)    {
            prev = next;
            if(next.key > key)
                next = next.leftChild;
            else
                next = next.rightChild;
        }
        if(prev == null)    {
            Node newNode = new Node(key);
            root = newNode;
        }
        else {
            Node newNode = new Node(key);
            newNode.parent = prev;
            if(prev.key > key)
                prev.leftChild = newNode;
            else
                prev.rightChild = newNode;
        }
    }

    public Node search(int key) {
        return searchRecursive(root, key);
    }

    public Node searchRecursive(Node n, int key)    {

        if(n == null)
            return null;

        if(n.key == key)
            return n;

        if(n.key < key)
            return searchRecursive(n.rightChild, key);
        else
            return searchRecursive(n.leftChild, key);
    }

    public Node minimum() {

        Node n = root;
        while (n.leftChild != null)
            n = n.leftChild;
        return n;
    }

    public Node maximum()   {

        Node n = root;
        while(n.rightChild != null)
        n = n.rightChild;
        return n;
    }

    public void printBST()  {
        if(root != null)
            inorderTraversal(root);
        else
            System.out.println("Empty Binary Search Tree");
    }

    public void inorderTraversal(Node n)    {
        if(n.leftChild != null)
            inorderTraversal(n.leftChild);
        System.out.println(n.key);
        if(n.rightChild != null)
            inorderTraversal(n.rightChild);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(50);
        bst.insert(80);
        bst.insert(30);
        bst.insert(60);
        bst.insert(10);
        bst.insert(90);
        bst.insert(40);
        bst.insert(70);

        System.out.println(bst.getRoot().key);
        bst.printBST();
    }
}
