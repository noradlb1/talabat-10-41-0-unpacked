package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {
    private int size = -1;

    public LLRBBlackValueNode(K k11, V v11, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k11, v11, lLRBNode, lLRBNode2);
    }

    public LLRBValueNode<K, V> copy(K k11, V v11, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k11 == null) {
            k11 = getKey();
        }
        if (v11 == null) {
            v11 = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBBlackValueNode(k11, v11, lLRBNode, lLRBNode2);
    }

    public LLRBNode.Color getColor() {
        return LLRBNode.Color.BLACK;
    }

    public boolean isRed() {
        return false;
    }

    public void setLeft(LLRBNode<K, V> lLRBNode) {
        if (this.size == -1) {
            super.setLeft(lLRBNode);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }

    public int size() {
        if (this.size == -1) {
            this.size = getLeft().size() + 1 + getRight().size();
        }
        return this.size;
    }
}
