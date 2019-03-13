package com.java.hackerank.practice;

import java.util.*;

public class IsBinarySearchTree {

    class Node  {

        int data;
        Node left;
        Node right;
        Node parent;

        Node(int key)  {

            this.data = key;
            this.left = this.right = this.parent = null;
        }
    }
    ArrayList<Integer> inorder = new ArrayList<Integer>();

    boolean checkBST(Node root) {
        if(root == null)
            return true;
        checkBSTUtil(root);
        for(int i =1; i < inorder.size(); i++)    {
            if(inorder.get(i-1) >= inorder.get(i))
                return false;
        }
        return true;
    }

    void checkBSTUtil(Node root) {
        if(root.left != null)
            checkBSTUtil(root.left);
        inorder.add(root.data);
        if(root.right != null)
            checkBSTUtil(root.right);
    }

    public static void main(String[] args)  {

        IsBinarySearchTree isBST = new IsBinarySearchTree();
        Node root = isBST.new Node(30);
        Node leftChild = isBST.new Node(20);
        Node rightChild = isBST.new Node(40);
        root.right = leftChild;
        root.left = rightChild;

        System.out.println(isBST.checkBST(root));
    }
}
