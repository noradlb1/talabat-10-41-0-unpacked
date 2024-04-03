package com.google.firebase.database.collection;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
    private final boolean isReverse;
    private final ArrayDeque<LLRBValueNode<K, V>> nodeStack = new ArrayDeque<>();

    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k11, Comparator<K> comparator, boolean z11) {
        int i11;
        this.isReverse = z11;
        while (!lLRBNode.isEmpty()) {
            if (k11 == null) {
                i11 = 1;
            } else if (z11) {
                i11 = comparator.compare(k11, lLRBNode.getKey());
            } else {
                i11 = comparator.compare(lLRBNode.getKey(), k11);
            }
            if (i11 < 0) {
                if (z11) {
                    lLRBNode = lLRBNode.getLeft();
                } else {
                    lLRBNode = lLRBNode.getRight();
                }
            } else if (i11 == 0) {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                return;
            } else {
                this.nodeStack.push((LLRBValueNode) lLRBNode);
                if (z11) {
                    lLRBNode = lLRBNode.getRight();
                } else {
                    lLRBNode = lLRBNode.getLeft();
                }
            }
        }
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.nodeStack.size() > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode pop = this.nodeStack.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.isReverse) {
                for (LLRBNode left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.nodeStack.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.nodeStack.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
