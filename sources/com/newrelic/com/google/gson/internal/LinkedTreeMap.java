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
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public Map.Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        public boolean remove(Object obj) {
            Node findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T>, j$.util.Iterator {
        int expectedModCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.modCount == this.expectedModCount) {
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
                LinkedTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
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
            this.root = node2;
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

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet2 = this.entrySet;
        if (entrySet2 != null) {
            return entrySet2;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet3 = new EntrySet();
        this.entrySet = entrySet3;
        return entrySet3;
    }

    public Node<K, V> find(K k11, boolean z11) {
        int i11;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator2 = this.comparator;
        Node<K, V> node3 = this.root;
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
        if (!z11) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node3 != null) {
            node = new Node<>(node3, k11, node4, node4.prev);
            if (i11 < 0) {
                node3.left = node;
            } else {
                node3.right = node;
            }
            rebalance(node3, true);
        } else if (comparator2 != NATURAL_ORDER || (k11 instanceof Comparable)) {
            node = new Node<>(node3, k11, node4, node4.prev);
            this.root = node;
        } else {
            throw new ClassCastException(k11.getClass().getName() + " is not Comparable");
        }
        this.size++;
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
        LinkedTreeMap<K, V>.KeySet keySet2 = this.keySet;
        if (keySet2 != null) {
            return keySet2;
        }
        LinkedTreeMap<K, V>.KeySet keySet3 = new KeySet();
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

    public LinkedTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node<>();
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
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
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
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

        public Node(Node<K, V> node, K k11, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k11;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
