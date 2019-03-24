package com.coding.challenge.amazon;

public class NaryTree {

    public NaryNode root = new NaryNode(200);

    public NaryTree() {
        root.parent = null;
    }

    public NaryTree(NaryNode root) {
        root.parent = null;
        this.root = root;
    }

    public void traverseTree(NaryNode rootNode)// depth first
    {
        System.out.println(rootNode.value);
        if (rootNode.children.size() != 0)
            for (NaryNode ch : rootNode.children)
                traverseTree(ch);
    }

    public static void main(String[] args) {

        NaryNode n1 = new NaryNode(200);
        NaryNode n2 = new NaryNode(120);
        NaryNode n3 = new NaryNode(180);

        NaryNode n4 = new NaryNode(110);
        NaryNode n5 = new NaryNode(20);
        NaryNode n6 = new NaryNode(30);

        NaryNode n7 = new NaryNode(150);
        NaryNode n8 = new NaryNode(80);

        NaryTree mytree = new NaryTree();

        mytree.root.addChild(n2);
        mytree.root.addChild(n3);

        n2.addChild(n4);
        n2.addChild(n5);
        n2.addChild(n6);

        n3.addChild(n7);
        n3.addChild(n8);


        // mytree.traverseTree(mytree.root);
        float max = Integer.MIN_VALUE;
        float maxavg = calculateaverage(mytree.root, max);
        System.out.println(maxavg);
    }

    private static float calculateaverage(NaryNode root, float max) {
        float sum = 0;
        int count = 0;
        if (root.children.size() == 0)
            return root.value;
        else{
            sum += root.value;
            count+= 1;
        }
        for (NaryNode cc : root.children) {
            sum += calculateaverage(cc, max);
            count++;
        }
        System.out.println(root.value +"  " + sum + "  " + count);
        float curr_max = sum / count;
        if (curr_max > max)
            max = sum;
        return sum;
    }

}