package com.newrelic.com.google.gson.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    Node<K, V>[] table;
    int threshold;

    public static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        public void add(Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i11 = this.leavesToSkip;
            if (i11 > 0) {
                int i12 = this.size;
                if ((i12 & 1) == 0) {
                    this.size = i12 + 1;
                    this.leavesToSkip = i11 - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int i13 = this.size + 1;
            this.size = i13;
            int i14 = this.leavesToSkip;
            if (i14 > 0 && (i13 & 1) == 0) {
                this.size = i13 + 1;
                this.leavesToSkip = i14 - 1;
                this.leavesSkipped++;
            }
            int i15 = 4;
            while (true) {
                int i16 = i15 - 1;
                if ((this.size & i16) == i16) {
                    int i17 = this.leavesSkipped;
                    if (i17 == 0) {
                        Node<K, V> node2 = this.stack;
                        Node<K, V> node3 = node2.parent;
                        Node<K, V> node4 = node3.parent;
                        node3.parent = node4.parent;
                        this.stack = node3;
                        node3.left = node4;
                        node3.right = node2;
                        node3.height = node2.height + 1;
                        node4.parent = node3;
                        node2.parent = node3;
                    } else if (i17 == 1) {
                        Node<K, V> node5 = this.stack;
                        Node<K, V> node6 = node5.parent;
                        this.stack = node6;
                        node6.right = node5;
                        node6.height = node5.height + 1;
                        node5.parent = node6;
                        this.leavesSkipped = 0;
                    } else if (i17 == 2) {
                        this.leavesSkipped = 0;
                    }
                    i15 *= 2;
                } else {
                    return;
                }
            }
        }

        public void reset(int i11) {
            this.leavesToSkip = ((Integer.highestOneBit(i11) * 2) - 1) - i11;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        public Node<K, V> root() {
            Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        public Node<K, V> next() {
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.parent;
            node.parent = null;
            Node<K, V> node3 = node.right;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                Node<K, V> node5 = node4;
                if (node2 != null) {
                    node2.parent = node5;
                    node3 = node2.left;
                } else {
                    this.stackTop = node5;
                    return node;
                }
            }
        }

        public void reset(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (node != null) {
                node.parent = node2;
                node2 = node;
                node = node.left;
            }
            this.stackTop = node2;
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public Map.Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        public boolean remove(Object obj) {
            Node findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T>, j$.util.Iterator {
        int expectedModCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.expectedModCount) {
                this.next = node.next;
                this.lastReturned = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedHashTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    private void doubleCapacity() {
        Node<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node<K, V> node, boolean z11) {
        int i11;
        int i12;
        int i13;
        int i14;
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int i15 = 0;
            if (node2 != null) {
                i11 = node2.height;
            } else {
                i11 = 0;
            }
            if (node3 != null) {
                i12 = node3.height;
            } else {
                i12 = 0;
            }
            int i16 = i11 - i12;
            if (i16 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                if (node5 != null) {
                    i14 = node5.height;
                } else {
                    i14 = 0;
                }
                if (node4 != null) {
                    i15 = node4.height;
                }
                int i17 = i15 - i14;
                if (i17 == -1 || (i17 == 0 && !z11)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z11) {
                    return;
                }
            } else if (i16 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                if (node7 != null) {
                    i13 = node7.height;
                } else {
                    i13 = 0;
                }
                if (node6 != null) {
                    i15 = node6.height;
                }
                int i18 = i15 - i13;
                if (i18 == 1 || (i18 == 0 && !z11)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z11) {
                    return;
                }
            } else if (i16 == 0) {
                node.height = i11 + 1;
                if (z11) {
                    return;
                }
            } else {
                node.height = Math.max(i11, i12) + 1;
                if (!z11) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            int i11 = node.hash;
            Node<K, V>[] nodeArr = this.table;
            nodeArr[i11 & (nodeArr.length - 1)] = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        int i11;
        int i12;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i13 = 0;
        if (node2 != null) {
            i11 = node2.height;
        } else {
            i11 = 0;
        }
        if (node4 != null) {
            i12 = node4.height;
        } else {
            i12 = 0;
        }
        int max = Math.max(i11, i12) + 1;
        node.height = max;
        if (node5 != null) {
            i13 = node5.height;
        }
        node3.height = Math.max(max, i13) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        int i11;
        int i12;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i13 = 0;
        if (node3 != null) {
            i11 = node3.height;
        } else {
            i11 = 0;
        }
        if (node5 != null) {
            i12 = node5.height;
        } else {
            i12 = 0;
        }
        int max = Math.max(i11, i12) + 1;
        node.height = max;
        if (node4 != null) {
            i13 = node4.height;
        }
        node2.height = Math.max(max, i13) + 1;
    }

    private static int secondaryHash(int i11) {
        int i12 = i11 ^ ((i11 >>> 20) ^ (i11 >>> 12));
        return (i12 >>> 4) ^ ((i12 >>> 7) ^ i12);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        Node<K, V> node2 = node.next;
        while (node2 != node) {
            Node<K, V> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.EntrySet entrySet2 = this.entrySet;
        if (entrySet2 != null) {
            return entrySet2;
        }
        LinkedHashTreeMap<K, V>.EntrySet entrySet3 = new EntrySet();
        this.entrySet = entrySet3;
        return entrySet3;
    }

    public Node<K, V> find(K k11, boolean z11) {
        int i11;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator2 = this.comparator;
        Node<K, V>[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k11.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            if (comparator2 == NATURAL_ORDER) {
                comparable = (Comparable) k11;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i11 = comparable.compareTo(node3.key);
                } else {
                    i11 = comparator2.compare(k11, node3.key);
                }
                if (i11 == 0) {
                    return node3;
                }
                if (i11 < 0) {
                    node2 = node3.left;
                } else {
                    node2 = node3.right;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i11 = 0;
        }
        Node<K, V> node4 = node3;
        int i12 = i11;
        if (!z11) {
            return null;
        }
        Node<K, V> node5 = this.header;
        if (node4 != null) {
            node = new Node<>(node4, k11, secondaryHash, node5, node5.prev);
            if (i12 < 0) {
                node4.left = node;
            } else {
                node4.right = node;
            }
            rebalance(node4, true);
        } else if (comparator2 != NATURAL_ORDER || (k11 instanceof Comparable)) {
            node = new Node<>(node4, k11, secondaryHash, node5, node5.prev);
            nodeArr[length] = node;
        } else {
            throw new ClassCastException(k11.getClass().getName() + " is not Comparable");
        }
        int i13 = this.size;
        this.size = i13 + 1;
        if (i13 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return node;
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        boolean z11;
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject == null || !equal(findByObject.value, entry.getValue())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return findByObject;
        }
        return null;
    }

    public Node<K, V> findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.KeySet keySet2 = this.keySet;
        if (keySet2 != null) {
            return keySet2;
        }
        LinkedHashTreeMap<K, V>.KeySet keySet3 = new KeySet();
        this.keySet = keySet3;
        return keySet3;
    }

    public V put(K k11, V v11) {
        if (k11 != null) {
            Node find = find(k11, true);
            V v12 = find.value;
            find.value = v11;
            return v12;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        Node removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    public void removeInternal(Node<K, V> node, boolean z11) {
        Node<K, V> node2;
        int i11;
        if (z11) {
            Node<K, V> node3 = node.prev;
            node3.next = node.next;
            node.next.prev = node3;
            node.prev = null;
            node.next = null;
        }
        Node<K, V> node4 = node.left;
        Node<K, V> node5 = node.right;
        Node<K, V> node6 = node.parent;
        int i12 = 0;
        if (node4 == null || node5 == null) {
            if (node4 != null) {
                replaceInParent(node, node4);
                node.left = null;
            } else if (node5 != null) {
                replaceInParent(node, node5);
                node.right = null;
            } else {
                replaceInParent(node, (Node<K, V>) null);
            }
            rebalance(node6, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (node4.height > node5.height) {
            node2 = node4.last();
        } else {
            node2 = node5.first();
        }
        removeInternal(node2, false);
        Node<K, V> node7 = node.left;
        if (node7 != null) {
            i11 = node7.height;
            node2.left = node7;
            node7.parent = node2;
            node.left = null;
        } else {
            i11 = 0;
        }
        Node<K, V> node8 = node.right;
        if (node8 != null) {
            i12 = node8.height;
            node2.right = node8;
            node8.parent = node2;
            node.right = null;
        }
        node2.height = Math.max(i11, i12) + 1;
        replaceInParent(node, node2);
    }

    public Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new Node<>();
        Node<K, V>[] nodeArr = new Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    public static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            Node<K, V> node = nodeArr[i11];
            if (node != null) {
                avlIterator.reset(node);
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    Node next = avlIterator.next();
                    if (next == null) {
                        break;
                    } else if ((next.hash & length) == 0) {
                        i12++;
                    } else {
                        i13++;
                    }
                }
                avlBuilder.reset(i12);
                avlBuilder2.reset(i13);
                avlIterator.reset(node);
                while (true) {
                    Node next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    } else if ((next2.hash & length) == 0) {
                        avlBuilder.add(next2);
                    } else {
                        avlBuilder2.add(next2);
                    }
                }
                Node<K, V> node2 = null;
                nodeArr2[i11] = i12 > 0 ? avlBuilder.root() : null;
                int i14 = i11 + length;
                if (i13 > 0) {
                    node2 = avlBuilder2.root();
                }
                nodeArr2[i14] = node2;
            }
        }
        return nodeArr2;
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        public Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.key
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.value
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.com.google.gson.internal.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            int i11;
            K k11 = this.key;
            int i12 = 0;
            if (k11 == null) {
                i11 = 0;
            } else {
                i11 = k11.hashCode();
            }
            V v11 = this.value;
            if (v11 != null) {
                i12 = v11.hashCode();
            }
            return i11 ^ i12;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }

        public V setValue(V v11) {
            V v12 = this.value;
            this.value = v11;
            return v12;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node<K, V> node, K k11, int i11, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k11;
            this.hash = i11;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
