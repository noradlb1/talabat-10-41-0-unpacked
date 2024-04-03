package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

public class LLRBEmptyNode<K, V> implements LLRBNode<K, V> {
    private static final LLRBEmptyNode INSTANCE = new LLRBEmptyNode();

    private LLRBEmptyNode() {
    }

    public static <K, V> LLRBEmptyNode<K, V> getInstance() {
        return INSTANCE;
    }

    public LLRBNode<K, V> copy(K k11, V v11, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        return this;
    }

    public K getKey() {
        return null;
    }

    public LLRBNode<K, V> getLeft() {
        return this;
    }

    public LLRBNode<K, V> getMax() {
        return this;
    }

    public LLRBNode<K, V> getMin() {
        return this;
    }

    public LLRBNode<K, V> getRight() {
        return this;
    }

    public V getValue() {
        return null;
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
    }

    public LLRBNode<K, V> insert(K k11, V v11, Comparator<K> comparator) {
        return new LLRBRedValueNode(k11, v11);
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isRed() {
        return false;
    }

    public LLRBNode<K, V> remove(K k11, Comparator<K> comparator) {
        return this;
    }

    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        return true;
    }

    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        return true;
    }

    public int size() {
        return 0;
    }
}
