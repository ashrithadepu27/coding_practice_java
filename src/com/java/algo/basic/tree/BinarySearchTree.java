package com.java.algo.basic.tree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<? super T>> {

    public static class Entry<E extends Comparable<? super E>> {
        private E element;
        Entry<E> left, right, parent;

        Entry(E ele) {
            this.element = ele;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public E getElement() {
            return this.element;
        }

        public void setLeftChild(Entry<E> entry) {
            this.left = entry;
        }

        public Entry<E> getLeftChild() {
            return this.left;
        }

        public void setRightChild(Entry<E> entry) {
            this.right = entry;
        }

        public Entry<E> getRightChild() {
            return this.right;
        }

        public boolean hasRightChild() {
            return this.right != null;
        }

        public boolean hasLeftChild() {
            return this.left != null;
        }

        public int compareTo(Object o) {
            return (element).compareTo((E) o);
        }

        public void setParent(Entry<E> parent) {
            this.parent = parent;
        }

        public Entry<E> getParent() {
            return this.parent;
        }

        public void clear() {
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

    private Entry<T> root;
    private int  size;

    BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public Entry<T> getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }

    public boolean add(T ele) {
        Entry<T> newEntry = new Entry<>(ele);
        if (root == null) {
            root = newEntry;
        } else {
            Entry<T> prev = find(ele);
            if(prev.getElement().equals(ele)) return false;
            if(prev.getElement().compareTo(ele) > 0) prev.setLeftChild(newEntry);
            else prev.setRightChild(newEntry);
            newEntry.setParent(prev);
        }
        this.size++;
        return true;
    }

    public Entry<T> remove(T ele) {
        Entry<T> temp = find(ele);
        if(temp == null) return null;
        if(!temp.getElement().equals(ele)) return null;

        Entry<T> parent = temp.getParent();
        if(temp.getLeftChild() != null && temp.getRightChild() != null) {
            Entry<T> replacement = minimum(temp);

            if(replacement.getRightChild() != null) replacement.getRightChild().setParent(replacement.getParent());

            replacement.setParent(parent);
            replacement.setRightChild(temp.getRightChild());
            replacement.setLeftChild(temp.getLeftChild());
        } else {
            if(temp.getLeftChild() != null || temp.getRightChild() != null) {
                Entry<T> replacement = temp.getLeftChild() == null ? temp.getRightChild() : temp.getLeftChild();
                replacement.setParent(parent);
                if(parent.getRightChild().equals(temp)) {
                    parent.setRightChild(replacement);
                } else {
                    parent.setLeftChild(replacement);
                }
            } else {
                if(parent.getRightChild().equals(temp)) {
                    parent.setRightChild(null);
                } else {
                    parent.setLeftChild(null);
                }
            }
        }
        temp.clear();
        this.size--;
        return temp;
    }

    public Entry<T> minimum() {
        return minimum(this.root);
    }

    public Entry<T> minimum(Entry<T> entry) {
        Entry<T> temp = entry;
        while(temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }

    public Entry<T> maximum() {
        return maximum(this.root);
    }

    public Entry<T> maximum(Entry<T> entry) {
        Entry<T> temp = entry;
        while(temp.getRightChild() != null) {
            temp = temp.getRightChild();
        }
        return temp;
    }

    public boolean contains(T ele) {
        Entry<T> temp = find(ele);
        return temp != null && temp.getElement().equals(ele);
    }

    public Entry<T> find(T ele) {

        if(root == ele) return root;
        Entry<T> temp = root;
        Entry<T> prev = null;
        while(temp != null) {
            prev = temp;
            if(temp.getElement().equals(ele)) return temp;
            else if(temp.getElement().compareTo(ele) > 0) temp = temp.getLeftChild();
            else temp = temp.getRightChild();
        }
        return prev;
    }


    public void traverseBST(String traversal) {
        if(traversal.equalsIgnoreCase("inorder")) inOrderTraversal();
        else if(traversal.equalsIgnoreCase("preorder")) preOrderTraversal();
        else if(traversal.equalsIgnoreCase("levelorder")) levelOrderTraversal();
        else postOrderTraversal();
    }

    private void inOrderTraversal() {
        System.out.println("In-Order Traversal of BST (Recursive): ");
        inOrderTraversalRecursive(this.root);
        System.out.println();
        System.out.println("In-Order Traversal of BST (Iterative): ");
        inOrderTraversalIterative(this.root);
        System.out.println();
    }

    private void inOrderTraversalRecursive(Entry<T> entry) {
        if(entry.getLeftChild() != null) inOrderTraversalRecursive(entry.getLeftChild());
        System.out.print(entry.getElement() + " ");
        if(entry.getRightChild() != null) inOrderTraversalRecursive(entry.getRightChild());
    }

    private void inOrderTraversalIterative(Entry<T> entry) {
        List<T> result = new LinkedList<>();

        if(root == null) return;

        Stack<Entry<T>> nodeStack = new Stack<>();
        Entry<T> temp = root;

        while(temp != null || !nodeStack.empty()) {
            while(temp != null) {
                nodeStack.push(temp);
                temp = temp.getLeftChild();
            }
            temp = nodeStack.pop();
            result.add(temp.getElement());
            temp = temp.getRightChild();
        }
        for(T r : result) {
            System.out.print(r + " ");
        }
    }

    private void preOrderTraversal() {
        System.out.println("Pre-Order Traversal of BST (Recursive): ");
        preOrderTraversalRecursive(this.root);
        System.out.println();
        System.out.println("Pre-Order Traversal of BST (Iterative): ");
        preOrderTraversalIterative(this.root);
        System.out.println();
    }

    private void preOrderTraversalIterative(Entry<T> entry) {
        List<T> result = new LinkedList<>();
        if(root == null) return;

        Stack<Entry<T>> node = new Stack<>();
        node.push(root);

        while(!node.empty()) {

            Entry<T> temp = node.peek();
            result.add(temp.getElement());
            node.pop();

            if(temp.right != null) node.push(temp.right);
            if(temp.left != null) node.push(temp.left);
        }

        for(T r : result) {
            System.out.print(r + " ");
        }
    }

    private void preOrderTraversalRecursive(Entry<T> entry) {
        System.out.print(entry.getElement() + " ");
        if(entry.getLeftChild() != null) preOrderTraversalRecursive(entry.getLeftChild());
        if(entry.getRightChild() != null) preOrderTraversalRecursive(entry.getRightChild());
    }

    private void postOrderTraversal() {
        System.out.println("Post-Order Traversal of BST (Recursive): ");
        postOrderTraversalRecursive(this.root);
        System.out.println();
        System.out.println("Post-Order Traversal of BST (Iterative): ");
        postOrderTraversalIterative(this.root);
        System.out.println();
    }

    private void postOrderTraversalRecursive(Entry<T> entry) {
        if(entry.getLeftChild() != null) postOrderTraversalRecursive(entry.getLeftChild());
        if(entry.getRightChild() != null) postOrderTraversalRecursive(entry.getRightChild());
        System.out.print(entry.getElement() + " ");
    }

    private void levelOrderTraversal() {
        System.out.println("Level-Order Traversal of BST (Recursive): ");
        levelOrderTraversal(this.root);
        System.out.println();
    }

    public void levelOrderTraversal(Entry<T> root) {
        List<List<T>> result = new LinkedList<>();

        if(root == null) return;
        List<T> r = new LinkedList<>();
        Queue<Entry<T>> nodeLevel = new LinkedList<>();
        Queue<Entry<T>> tempStack = new LinkedList<>();
        Entry<T> temp;
        nodeLevel.add(root);

        while(nodeLevel.size() != 0) {

            temp = nodeLevel.remove();

            r.add(temp.getElement());
            if(temp.getLeftChild() != null ) tempStack.add(temp.getLeftChild());
            if(temp.getRightChild() != null) tempStack.add(temp.getRightChild());

            if(nodeLevel.size() == 0) {
                nodeLevel = new LinkedList<>(tempStack);
                tempStack.clear();
                result.add(r);
                r = new LinkedList<>();
            }
        }

        for(List l : result) {
            System.out.print(l + " ");
        }
    }

    private void postOrderTraversalIterative(Entry<T> entry) {
        List<T> result = new LinkedList<T>();

        Stack<Entry<T>> nodeStack = new Stack<>();

        Entry<T> temp = root;
        Entry<T> right = null;
        while(temp != null || !nodeStack.empty()) {
            if(temp != null) {
                nodeStack.push(temp);
                temp = temp.getLeftChild();
            } else {
                right = nodeStack.peek().getRightChild();
                if(right == null) {
                    right = nodeStack.pop();
                    result.add(right.getElement());
                    while(!nodeStack.empty() && right == nodeStack.peek().getRightChild()) {
                        right = nodeStack.pop();
                        result.add(right.getElement());
                    }
                } else {
                    temp = right;
                }
            }
        }

        for(T r : result) {
            System.out.print(r + " ");
        }
    }

    private int maximumDepth() {
        if(this.root == null) return 0;
        return maximumDepth(this.root);
    }

    private int maximumDepth(Entry<T> root) {
       if(root == null) return 0;
       int leftMaxDepth = maximumDepth(root.getLeftChild());
       int rightMaxDepth = maximumDepth(root.getRightChild());

       return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public Entry<T> successor(T x) {
        Entry<T> xEntry = find(x);
        if(xEntry == null) return null;
        return successor(xEntry);
    }

    public Entry<T> successor(Entry<T> entry) {
        if(entry.getRightChild() != null)
            return minimum(entry.getRightChild());
        Entry<T> parent = entry.getParent();
        if(parent != null && parent.hasRightChild() && parent.getRightChild().equals(entry)) return null;
        while(parent != null && entry.equals(entry.getRightChild())) {
            entry = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(6);
        bst.add(8);
        bst.add(8);
        bst.add(3);
        bst.add(7);

        System.out.println("Contains 8: " + bst.contains(8));
        System.out.println("Contains 9: " + bst.contains(9));
        System.out.println("Minimum: " + bst.minimum().getElement());

        System.out.println(bst.remove(1).getElement());
        System.out.println(bst.minimum().getElement());
        bst.traverseBST("inorder");
        bst.traverseBST("preorder");
        bst.traverseBST("postorder");
        bst.traverseBST("levelorder");
        System.out.println("Max Depth: " + bst.maximumDepth());
        System.out.println("Successor of 1: " + bst.successor(1).getElement());
        System.out.println("Successor of 2: " + bst.successor(2).getElement());
//        System.out.println("Successor of 3: " + bst.successor(3).getElement());
        System.out.println("Successor of 4: " + bst.successor(4).getElement());
        System.out.println("Successor of 5: " + bst.successor(5).getElement());
        System.out.println("Successor of 6: " + bst.successor(6).getElement());
        System.out.println("Successor of 7: " + bst.successor(7).getElement());
        System.out.println("Successor of 8: " + bst.successor(8).getElement());
    }
}
