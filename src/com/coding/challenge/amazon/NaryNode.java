package com.coding.challenge.amazon;

import java.util.ArrayList;
import java.util.List;

class NaryNode {
    int value;
    NaryNode parent;
    List<NaryNode> children = new ArrayList<NaryNode>();

    NaryNode(int x) {
        this.value = x;
    }

    public void addChild(NaryNode childNode) {
        childNode.parent = this;
        this.children.add(childNode);
    }

}