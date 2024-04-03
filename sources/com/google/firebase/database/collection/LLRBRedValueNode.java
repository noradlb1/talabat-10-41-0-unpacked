package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    public LLRBRedValueNode(K k11, V v11) {
        super(k11, v11, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
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
        return new LLRBRedValueNode(k11, v11, lLRBNode, lLRBNode2);
    }

    public LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    public boolean isRed() {
        return true;
    }

    public int size() {
        return getLeft().size() + 1 + getRight().size();
    }

    public LLRBRedValueNode(K k11, V v11, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k11, v11, lLRBNode, lLRBNode2);
    }
}
