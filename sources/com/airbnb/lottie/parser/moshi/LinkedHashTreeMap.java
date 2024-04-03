package com.airbnb.lottie.parser.moshi;

import j$.util.Iterator;
import j$.util.function.Consumer;
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

final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Comparator<? super K> f40702b;

    /* renamed from: c  reason: collision with root package name */
    public Node<K, V>[] f40703c;

    /* renamed from: d  reason: collision with root package name */
    public final Node<K, V> f40704d;

    /* renamed from: e  reason: collision with root package name */
    public int f40705e;
    private LinkedHashTreeMap<K, V>.EntrySet entrySet;

    /* renamed from: f  reason: collision with root package name */
    public int f40706f;

    /* renamed from: g  reason: collision with root package name */
    public int f40707g;
    private LinkedHashTreeMap<K, V>.KeySet keySet;

    public static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        public void a(Node<K, V> node) {
            node.f40718d = null;
            node.f40716b = null;
            node.f40717c = null;
            node.f40724j = 1;
            int i11 = this.leavesToSkip;
            if (i11 > 0) {
                int i12 = this.size;
                if ((i12 & 1) == 0) {
                    this.size = i12 + 1;
                    this.leavesToSkip = i11 - 1;
                    this.leavesSkipped++;
                }
            }
            node.f40716b = this.stack;
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
                        Node<K, V> node3 = node2.f40716b;
                        Node<K, V> node4 = node3.f40716b;
                        node3.f40716b = node4.f40716b;
                        this.stack = node3;
                        node3.f40717c = node4;
                        node3.f40718d = node2;
                        node3.f40724j = node2.f40724j + 1;
                        node4.f40716b = node3;
                        node2.f40716b = node3;
                    } else if (i17 == 1) {
                        Node<K, V> node5 = this.stack;
                        Node<K, V> node6 = node5.f40716b;
                        this.stack = node6;
                        node6.f40718d = node5;
                        node6.f40724j = node5.f40724j + 1;
                        node5.f40716b = node6;
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

        public void b(int i11) {
            this.leavesToSkip = ((Integer.highestOneBit(i11) * 2) - 1) - i11;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        public Node<K, V> c() {
            Node<K, V> node = this.stack;
            if (node.f40716b == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        public void a(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (node != null) {
                node.f40716b = node2;
                node2 = node;
                node = node.f40717c;
            }
            this.stackTop = node2;
        }

        public Node<K, V> next() {
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node<K, V> node2 = node.f40716b;
            node.f40716b = null;
            Node<K, V> node3 = node.f40718d;
            while (true) {
                Node<K, V> node4 = node2;
                node2 = node3;
                Node<K, V> node5 = node4;
                if (node2 != null) {
                    node2.f40716b = node5;
                    node3 = node2.f40717c;
                } else {
                    this.stackTop = node5;
                    return node;
                }
            }
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.c((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        public boolean remove(Object obj) {
            Node c11;
            if (!(obj instanceof Map.Entry) || (c11 = LinkedHashTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.e(c11, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.f40705e;
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
                    return a().f40721g;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.f(obj) != null;
        }

        public int size() {
            return LinkedHashTreeMap.this.f40705e;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T>, j$.util.Iterator {

        /* renamed from: b  reason: collision with root package name */
        public Node<K, V> f40712b;

        /* renamed from: c  reason: collision with root package name */
        public Node<K, V> f40713c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f40714d;

        public LinkedTreeMapIterator() {
            this.f40712b = LinkedHashTreeMap.this.f40704d.f40719e;
            this.f40714d = LinkedHashTreeMap.this.f40706f;
        }

        public final Node<K, V> a() {
            Node<K, V> node = this.f40712b;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.f40704d) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.f40706f == this.f40714d) {
                this.f40712b = node.f40719e;
                this.f40713c = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final boolean hasNext() {
            return this.f40712b != LinkedHashTreeMap.this.f40704d;
        }

        public final void remove() {
            Node<K, V> node = this.f40713c;
            if (node != null) {
                LinkedHashTreeMap.this.e(node, true);
                this.f40713c = null;
                this.f40714d = LinkedHashTreeMap.this.f40706f;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this((Comparator) null);
    }

    public static <K, V> Node<K, V>[] a(Node<K, V>[] nodeArr) {
        Node<K, V> node;
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            Node<K, V> node2 = nodeArr[i11];
            if (node2 != null) {
                avlIterator.a(node2);
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    Node next = avlIterator.next();
                    if (next == null) {
                        break;
                    } else if ((next.f40722h & length) == 0) {
                        i12++;
                    } else {
                        i13++;
                    }
                }
                avlBuilder.b(i12);
                avlBuilder2.b(i13);
                avlIterator.a(node2);
                while (true) {
                    Node next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    } else if ((next2.f40722h & length) == 0) {
                        avlBuilder.a(next2);
                    } else {
                        avlBuilder2.a(next2);
                    }
                }
                Node<K, V> node3 = null;
                if (i12 > 0) {
                    node = avlBuilder.c();
                } else {
                    node = null;
                }
                nodeArr2[i11] = node;
                int i14 = i11 + length;
                if (i13 > 0) {
                    node3 = avlBuilder2.c();
                }
                nodeArr2[i14] = node3;
            }
        }
        return nodeArr2;
    }

    private void doubleCapacity() {
        Node<K, V>[] a11 = a(this.f40703c);
        this.f40703c = a11;
        this.f40707g = (a11.length / 2) + (a11.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(Node<K, V> node, boolean z11) {
        int i11;
        int i12;
        int i13;
        int i14;
        while (node != null) {
            Node<K, V> node2 = node.f40717c;
            Node<K, V> node3 = node.f40718d;
            int i15 = 0;
            if (node2 != null) {
                i11 = node2.f40724j;
            } else {
                i11 = 0;
            }
            if (node3 != null) {
                i12 = node3.f40724j;
            } else {
                i12 = 0;
            }
            int i16 = i11 - i12;
            if (i16 == -2) {
                Node<K, V> node4 = node3.f40717c;
                Node<K, V> node5 = node3.f40718d;
                if (node5 != null) {
                    i14 = node5.f40724j;
                } else {
                    i14 = 0;
                }
                if (node4 != null) {
                    i15 = node4.f40724j;
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
                Node<K, V> node6 = node2.f40717c;
                Node<K, V> node7 = node2.f40718d;
                if (node7 != null) {
                    i13 = node7.f40724j;
                } else {
                    i13 = 0;
                }
                if (node6 != null) {
                    i15 = node6.f40724j;
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
                node.f40724j = i11 + 1;
                if (z11) {
                    return;
                }
            } else {
                node.f40724j = Math.max(i11, i12) + 1;
                if (!z11) {
                    return;
                }
            }
            node = node.f40716b;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.f40716b;
        node.f40716b = null;
        if (node2 != null) {
            node2.f40716b = node3;
        }
        if (node3 == null) {
            int i11 = node.f40722h;
            Node<K, V>[] nodeArr = this.f40703c;
            nodeArr[i11 & (nodeArr.length - 1)] = node2;
        } else if (node3.f40717c == node) {
            node3.f40717c = node2;
        } else {
            node3.f40718d = node2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        int i11;
        int i12;
        Node<K, V> node2 = node.f40717c;
        Node<K, V> node3 = node.f40718d;
        Node<K, V> node4 = node3.f40717c;
        Node<K, V> node5 = node3.f40718d;
        node.f40718d = node4;
        if (node4 != null) {
            node4.f40716b = node;
        }
        replaceInParent(node, node3);
        node3.f40717c = node;
        node.f40716b = node3;
        int i13 = 0;
        if (node2 != null) {
            i11 = node2.f40724j;
        } else {
            i11 = 0;
        }
        if (node4 != null) {
            i12 = node4.f40724j;
        } else {
            i12 = 0;
        }
        int max = Math.max(i11, i12) + 1;
        node.f40724j = max;
        if (node5 != null) {
            i13 = node5.f40724j;
        }
        node3.f40724j = Math.max(max, i13) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        int i11;
        int i12;
        Node<K, V> node2 = node.f40717c;
        Node<K, V> node3 = node.f40718d;
        Node<K, V> node4 = node2.f40717c;
        Node<K, V> node5 = node2.f40718d;
        node.f40717c = node5;
        if (node5 != null) {
            node5.f40716b = node;
        }
        replaceInParent(node, node2);
        node2.f40718d = node;
        node.f40716b = node2;
        int i13 = 0;
        if (node3 != null) {
            i11 = node3.f40724j;
        } else {
            i11 = 0;
        }
        if (node5 != null) {
            i12 = node5.f40724j;
        } else {
            i12 = 0;
        }
        int max = Math.max(i11, i12) + 1;
        node.f40724j = max;
        if (node4 != null) {
            i13 = node4.f40724j;
        }
        node2.f40724j = Math.max(max, i13) + 1;
    }

    private static int secondaryHash(int i11) {
        int i12 = i11 ^ ((i11 >>> 20) ^ (i11 >>> 12));
        return (i12 >>> 4) ^ ((i12 >>> 7) ^ i12);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public Node<K, V> b(K k11, boolean z11) {
        int i11;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.f40702b;
        Node<K, V>[] nodeArr = this.f40703c;
        int secondaryHash = secondaryHash(k11.hashCode());
        int length = (nodeArr.length - 1) & secondaryHash;
        Node<K, V> node3 = nodeArr[length];
        if (node3 != null) {
            if (comparator == NATURAL_ORDER) {
                comparable = (Comparable) k11;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i11 = comparable.compareTo(node3.f40721g);
                } else {
                    i11 = comparator.compare(k11, node3.f40721g);
                }
                if (i11 == 0) {
                    return node3;
                }
                if (i11 < 0) {
                    node2 = node3.f40717c;
                } else {
                    node2 = node3.f40718d;
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
        Node<K, V> node5 = this.f40704d;
        if (node4 != null) {
            node = new Node<>(node4, k11, secondaryHash, node5, node5.f40720f);
            if (i12 < 0) {
                node4.f40717c = node;
            } else {
                node4.f40718d = node;
            }
            rebalance(node4, true);
        } else if (comparator != NATURAL_ORDER || (k11 instanceof Comparable)) {
            node = new Node<>(node4, k11, secondaryHash, node5, node5.f40720f);
            nodeArr[length] = node;
        } else {
            throw new ClassCastException(k11.getClass().getName() + " is not Comparable");
        }
        int i13 = this.f40705e;
        this.f40705e = i13 + 1;
        if (i13 > this.f40707g) {
            doubleCapacity();
        }
        this.f40706f++;
        return node;
    }

    public Node<K, V> c(Map.Entry<?, ?> entry) {
        boolean z11;
        Node<K, V> d11 = d(entry.getKey());
        if (d11 == null || !equal(d11.f40723i, entry.getValue())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return d11;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(this.f40703c, (Object) null);
        this.f40705e = 0;
        this.f40706f++;
        Node<K, V> node = this.f40704d;
        Node<K, V> node2 = node.f40719e;
        while (node2 != node) {
            Node<K, V> node3 = node2.f40719e;
            node2.f40720f = null;
            node2.f40719e = null;
            node2 = node3;
        }
        node.f40720f = node;
        node.f40719e = node;
    }

    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    public Node<K, V> d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public void e(Node<K, V> node, boolean z11) {
        Node<K, V> node2;
        int i11;
        if (z11) {
            Node<K, V> node3 = node.f40720f;
            node3.f40719e = node.f40719e;
            node.f40719e.f40720f = node3;
            node.f40720f = null;
            node.f40719e = null;
        }
        Node<K, V> node4 = node.f40717c;
        Node<K, V> node5 = node.f40718d;
        Node<K, V> node6 = node.f40716b;
        int i12 = 0;
        if (node4 == null || node5 == null) {
            if (node4 != null) {
                replaceInParent(node, node4);
                node.f40717c = null;
            } else if (node5 != null) {
                replaceInParent(node, node5);
                node.f40718d = null;
            } else {
                replaceInParent(node, (Node<K, V>) null);
            }
            rebalance(node6, false);
            this.f40705e--;
            this.f40706f++;
            return;
        }
        if (node4.f40724j > node5.f40724j) {
            node2 = node4.last();
        } else {
            node2 = node5.first();
        }
        e(node2, false);
        Node<K, V> node7 = node.f40717c;
        if (node7 != null) {
            i11 = node7.f40724j;
            node2.f40717c = node7;
            node7.f40716b = node2;
            node.f40717c = null;
        } else {
            i11 = 0;
        }
        Node<K, V> node8 = node.f40718d;
        if (node8 != null) {
            i12 = node8.f40724j;
            node2.f40718d = node8;
            node8.f40716b = node2;
            node.f40718d = null;
        }
        node2.f40724j = Math.max(i11, i12) + 1;
        replaceInParent(node, node2);
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

    public Node<K, V> f(Object obj) {
        Node<K, V> d11 = d(obj);
        if (d11 != null) {
            e(d11, true);
        }
        return d11;
    }

    public V get(Object obj) {
        Node d11 = d(obj);
        if (d11 != null) {
            return d11.f40723i;
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
            Node b11 = b(k11, true);
            V v12 = b11.f40723i;
            b11.f40723i = v11;
            return v12;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        Node f11 = f(obj);
        if (f11 != null) {
            return f11.f40723i;
        }
        return null;
    }

    public int size() {
        return this.f40705e;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.f40705e = 0;
        this.f40706f = 0;
        this.f40702b = comparator == null ? NATURAL_ORDER : comparator;
        this.f40704d = new Node<>();
        Node<K, V>[] nodeArr = new Node[16];
        this.f40703c = nodeArr;
        this.f40707g = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public Node<K, V> f40716b;

        /* renamed from: c  reason: collision with root package name */
        public Node<K, V> f40717c;

        /* renamed from: d  reason: collision with root package name */
        public Node<K, V> f40718d;

        /* renamed from: e  reason: collision with root package name */
        public Node<K, V> f40719e;

        /* renamed from: f  reason: collision with root package name */
        public Node<K, V> f40720f;

        /* renamed from: g  reason: collision with root package name */
        public final K f40721g;

        /* renamed from: h  reason: collision with root package name */
        public final int f40722h;

        /* renamed from: i  reason: collision with root package name */
        public V f40723i;

        /* renamed from: j  reason: collision with root package name */
        public int f40724j;

        public Node() {
            this.f40721g = null;
            this.f40722h = -1;
            this.f40720f = this;
            this.f40719e = this;
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
                K r0 = r3.f40721g
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f40723i
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
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f40717c; node2 != null; node2 = node2.f40717c) {
                node = node2;
            }
            return node;
        }

        public K getKey() {
            return this.f40721g;
        }

        public V getValue() {
            return this.f40723i;
        }

        public int hashCode() {
            int i11;
            K k11 = this.f40721g;
            int i12 = 0;
            if (k11 == null) {
                i11 = 0;
            } else {
                i11 = k11.hashCode();
            }
            V v11 = this.f40723i;
            if (v11 != null) {
                i12 = v11.hashCode();
            }
            return i11 ^ i12;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f40718d; node2 != null; node2 = node2.f40718d) {
                node = node2;
            }
            return node;
        }

        public V setValue(V v11) {
            V v12 = this.f40723i;
            this.f40723i = v11;
            return v12;
        }

        public String toString() {
            return this.f40721g + "=" + this.f40723i;
        }

        public Node(Node<K, V> node, K k11, int i11, Node<K, V> node2, Node<K, V> node3) {
            this.f40716b = node;
            this.f40721g = k11;
            this.f40722h = i11;
            this.f40724j = 1;
            this.f40719e = node2;
            this.f40720f = node3;
            node3.f40719e = this;
            node2.f40720f = this;
        }
    }
}
