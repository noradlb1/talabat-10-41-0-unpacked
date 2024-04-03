package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private Comparator<K> comparator;
    private LLRBNode<K, V> root;

    public static class Builder<A, B, C> {
        private final ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator;
        private final List<A> keys;
        private LLRBValueNode<A, C> leaf;
        private LLRBValueNode<A, C> root;
        private final Map<B, C> values;

        public static class Base1_2 implements Iterable<BooleanChunk> {
            /* access modifiers changed from: private */
            public final int length;
            /* access modifiers changed from: private */
            public long value;

            public Base1_2(int i11) {
                int i12 = i11 + 1;
                int floor = (int) Math.floor(Math.log((double) i12) / Math.log(2.0d));
                this.length = floor;
                this.value = (((long) Math.pow(2.0d, (double) floor)) - 1) & ((long) i12);
            }

            public Iterator<BooleanChunk> iterator() {
                return new Object() {
                    private int current;

                    {
                        this.current = Base1_2.this.length - 1;
                    }

                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return this.current >= 0;
                    }

                    public void remove() {
                    }

                    public BooleanChunk next() {
                        BooleanChunk booleanChunk = new BooleanChunk();
                        booleanChunk.isOne = (Base1_2.this.value & ((long) (1 << this.current))) == 0;
                        booleanChunk.chunkSize = (int) Math.pow(2.0d, (double) this.current);
                        this.current--;
                        return booleanChunk;
                    }
                };
            }
        }

        public static class BooleanChunk {
            public int chunkSize;
            public boolean isOne;
        }

        private Builder(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2) {
            this.keys = list;
            this.values = map;
            this.keyTranslator = keyTranslator2;
        }

        private LLRBNode<A, C> buildBalancedTree(int i11, int i12) {
            if (i12 == 0) {
                return LLRBEmptyNode.getInstance();
            }
            if (i12 == 1) {
                A a11 = this.keys.get(i11);
                return new LLRBBlackValueNode(a11, getValue(a11), (LLRBNode) null, (LLRBNode) null);
            }
            int i13 = i12 / 2;
            int i14 = i11 + i13;
            LLRBNode buildBalancedTree = buildBalancedTree(i11, i13);
            LLRBNode buildBalancedTree2 = buildBalancedTree(i14 + 1, i13);
            A a12 = this.keys.get(i14);
            return new LLRBBlackValueNode(a12, getValue(a12), buildBalancedTree, buildBalancedTree2);
        }

        public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator2, Comparator<A> comparator) {
            Builder builder = new Builder(list, map, keyTranslator2);
            Collections.sort(list, comparator);
            java.util.Iterator<BooleanChunk> it = new Base1_2(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                BooleanChunk next = it.next();
                int i11 = next.chunkSize;
                size -= i11;
                if (next.isOne) {
                    builder.buildPennant(LLRBNode.Color.BLACK, i11, size);
                } else {
                    builder.buildPennant(LLRBNode.Color.BLACK, i11, size);
                    int i12 = next.chunkSize;
                    size -= i12;
                    builder.buildPennant(LLRBNode.Color.RED, i12, size);
                }
            }
            LLRBNode lLRBNode = builder.root;
            if (lLRBNode == null) {
                lLRBNode = LLRBEmptyNode.getInstance();
            }
            return new RBTreeSortedMap<>(lLRBNode, comparator);
        }

        private void buildPennant(LLRBNode.Color color, int i11, int i12) {
            LLRBValueNode<A, C> lLRBValueNode;
            LLRBNode buildBalancedTree = buildBalancedTree(i12 + 1, i11 - 1);
            A a11 = this.keys.get(i12);
            if (color == LLRBNode.Color.RED) {
                lLRBValueNode = new LLRBRedValueNode<>(a11, getValue(a11), (LLRBNode) null, buildBalancedTree);
            } else {
                lLRBValueNode = new LLRBBlackValueNode<>(a11, getValue(a11), (LLRBNode) null, buildBalancedTree);
            }
            if (this.root == null) {
                this.root = lLRBValueNode;
                this.leaf = lLRBValueNode;
                return;
            }
            this.leaf.setLeft(lLRBValueNode);
            this.leaf = lLRBValueNode;
        }

        private C getValue(A a11) {
            return this.values.get(this.keyTranslator.translate(a11));
        }
    }

    public static <A, B, C> RBTreeSortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator2) {
        return Builder.buildFrom(list, map, keyTranslator, comparator2);
    }

    public static <A, B> RBTreeSortedMap<A, B> fromMap(Map<A, B> map, Comparator<A> comparator2) {
        return Builder.buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private LLRBNode<K, V> getNode(K k11) {
        LLRBNode<K, V> lLRBNode = this.root;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k11, lLRBNode.getKey());
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else if (compare == 0) {
                return lLRBNode;
            } else {
                lLRBNode = lLRBNode.getRight();
            }
        }
        return null;
    }

    public boolean containsKey(K k11) {
        return getNode(k11) != null;
    }

    public V get(K k11) {
        LLRBNode node = getNode(k11);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        return this.root.getMax().getKey();
    }

    public K getMinKey() {
        return this.root.getMin().getKey();
    }

    public K getPredecessorKey(K k11) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k11, lLRBNode.getKey());
            if (compare == 0) {
                if (!lLRBNode.getLeft().isEmpty()) {
                    LLRBNode<K, V> left = lLRBNode.getLeft();
                    while (!left.getRight().isEmpty()) {
                        left = left.getRight();
                    }
                    return left.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getRight();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k11);
    }

    public LLRBNode<K, V> getRoot() {
        return this.root;
    }

    public K getSuccessorKey(K k11) {
        LLRBNode<K, V> lLRBNode = this.root;
        LLRBNode<K, V> lLRBNode2 = null;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(lLRBNode.getKey(), k11);
            if (compare == 0) {
                if (!lLRBNode.getRight().isEmpty()) {
                    LLRBNode<K, V> right = lLRBNode.getRight();
                    while (!right.getLeft().isEmpty()) {
                        right = right.getLeft();
                    }
                    return right.getKey();
                } else if (lLRBNode2 != null) {
                    return lLRBNode2.getKey();
                } else {
                    return null;
                }
            } else if (compare < 0) {
                lLRBNode = lLRBNode.getRight();
            } else {
                lLRBNode2 = lLRBNode;
                lLRBNode = lLRBNode.getLeft();
            }
        }
        throw new IllegalArgumentException("Couldn't find successor key of non-present key: " + k11);
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.root.inOrderTraversal(nodeVisitor);
    }

    public int indexOf(K k11) {
        LLRBNode<K, V> lLRBNode = this.root;
        int i11 = 0;
        while (!lLRBNode.isEmpty()) {
            int compare = this.comparator.compare(k11, lLRBNode.getKey());
            if (compare == 0) {
                return i11 + lLRBNode.getLeft().size();
            }
            if (compare < 0) {
                lLRBNode = lLRBNode.getLeft();
            } else {
                i11 += lLRBNode.getLeft().size() + 1;
                lLRBNode = lLRBNode.getRight();
            }
        }
        return -1;
    }

    public ImmutableSortedMap<K, V> insert(K k11, V v11) {
        return new RBTreeSortedMap(this.root.insert(k11, v11, this.comparator).copy(null, null, LLRBNode.Color.BLACK, (LLRBNode) null, (LLRBNode) null), this.comparator);
    }

    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, false);
    }

    public java.util.Iterator<Map.Entry<K, V>> iteratorFrom(K k11) {
        return new ImmutableSortedMapIterator(this.root, k11, this.comparator, false);
    }

    public ImmutableSortedMap<K, V> remove(K k11) {
        if (!containsKey(k11)) {
            return this;
        }
        return new RBTreeSortedMap(this.root.remove(k11, this.comparator).copy(null, null, LLRBNode.Color.BLACK, (LLRBNode) null, (LLRBNode) null), this.comparator);
    }

    public java.util.Iterator<Map.Entry<K, V>> reverseIterator() {
        return new ImmutableSortedMapIterator(this.root, null, this.comparator, true);
    }

    public java.util.Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k11) {
        return new ImmutableSortedMapIterator(this.root, k11, this.comparator, true);
    }

    public int size() {
        return this.root.size();
    }

    public RBTreeSortedMap(Comparator<K> comparator2) {
        this.root = LLRBEmptyNode.getInstance();
        this.comparator = comparator2;
    }

    private RBTreeSortedMap(LLRBNode<K, V> lLRBNode, Comparator<K> comparator2) {
        this.root = lLRBNode;
        this.comparator = comparator2;
    }
}
