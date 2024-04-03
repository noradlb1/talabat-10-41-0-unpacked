package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V> {
    private final Comparator<K> comparator;
    /* access modifiers changed from: private */
    public final K[] keys;
    /* access modifiers changed from: private */
    public final V[] values;

    public ArraySortedMap(Comparator<K> comparator2) {
        this.keys = new Object[0];
        this.values = new Object[0];
        this.comparator = comparator2;
    }

    private static <T> T[] addToArray(T[] tArr, int i11, T t11) {
        int length = tArr.length + 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i11);
        tArr2[i11] = t11;
        System.arraycopy(tArr, i11, tArr2, i11 + 1, (length - i11) - 1);
        return tArr2;
    }

    public static <A, B, C> ArraySortedMap<A, C> buildFrom(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator2) {
        Collections.sort(list, comparator2);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i11 = 0;
        for (A next : list) {
            objArr[i11] = next;
            objArr2[i11] = map.get(keyTranslator.translate(next));
            i11++;
        }
        return new ArraySortedMap<>(comparator2, objArr, objArr2);
    }

    private int findKey(K k11) {
        int i11 = 0;
        for (K compare : this.keys) {
            if (this.comparator.compare(k11, compare) == 0) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    private int findKeyOrInsertPosition(K k11) {
        int i11 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i11 >= kArr.length || this.comparator.compare(kArr[i11], k11) >= 0) {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    public static <K, V> ArraySortedMap<K, V> fromMap(Map<K, V> map, Comparator<K> comparator2) {
        return buildFrom(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator2);
    }

    private Iterator<Map.Entry<K, V>> iterator(int i11, boolean z11) {
        return new Object(i11, z11) {
            int currentPos;
            final /* synthetic */ int val$pos;
            final /* synthetic */ boolean val$reverse;

            {
                this.val$pos = r2;
                this.val$reverse = r3;
                this.currentPos = r2;
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                if (this.val$reverse) {
                    if (this.currentPos >= 0) {
                        return true;
                    }
                } else if (this.currentPos < ArraySortedMap.this.keys.length) {
                    return true;
                }
                return false;
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }

            public Map.Entry<K, V> next() {
                Object obj = ArraySortedMap.this.keys[this.currentPos];
                Object[] access$100 = ArraySortedMap.this.values;
                int i11 = this.currentPos;
                Object obj2 = access$100[i11];
                this.currentPos = this.val$reverse ? i11 - 1 : i11 + 1;
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        };
    }

    private static <T> T[] removeFromArray(T[] tArr, int i11) {
        int length = tArr.length - 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i11);
        System.arraycopy(tArr, i11 + 1, tArr2, i11, length - i11);
        return tArr2;
    }

    private static <T> T[] replaceInArray(T[] tArr, int i11, T t11) {
        int length = tArr.length;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i11] = t11;
        return tArr2;
    }

    public boolean containsKey(K k11) {
        return findKey(k11) != -1;
    }

    public V get(K k11) {
        int findKey = findKey(k11);
        if (findKey != -1) {
            return this.values[findKey];
        }
        return null;
    }

    public Comparator<K> getComparator() {
        return this.comparator;
    }

    public K getMaxKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    public K getMinKey() {
        K[] kArr = this.keys;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    public K getPredecessorKey(K k11) {
        int findKey = findKey(k11);
        if (findKey == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        } else if (findKey > 0) {
            return this.keys[findKey - 1];
        } else {
            return null;
        }
    }

    public K getSuccessorKey(K k11) {
        int findKey = findKey(k11);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (findKey < kArr.length - 1) {
                return kArr[findKey + 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find successor of nonexistent key");
    }

    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int i11 = 0;
        while (true) {
            K[] kArr = this.keys;
            if (i11 < kArr.length) {
                nodeVisitor.visitEntry(kArr[i11], this.values[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    public int indexOf(K k11) {
        return findKey(k11);
    }

    public ImmutableSortedMap<K, V> insert(K k11, V v11) {
        int findKey = findKey(k11);
        if (findKey != -1) {
            K[] kArr = this.keys;
            if (kArr[findKey] == k11 && this.values[findKey] == v11) {
                return this;
            }
            return new ArraySortedMap(this.comparator, replaceInArray(kArr, findKey, k11), replaceInArray(this.values, findKey, v11));
        } else if (this.keys.length > 25) {
            HashMap hashMap = new HashMap(this.keys.length + 1);
            int i11 = 0;
            while (true) {
                K[] kArr2 = this.keys;
                if (i11 < kArr2.length) {
                    hashMap.put(kArr2[i11], this.values[i11]);
                    i11++;
                } else {
                    hashMap.put(k11, v11);
                    return RBTreeSortedMap.fromMap(hashMap, this.comparator);
                }
            }
        } else {
            int findKeyOrInsertPosition = findKeyOrInsertPosition(k11);
            return new ArraySortedMap(this.comparator, addToArray(this.keys, findKeyOrInsertPosition, k11), addToArray(this.values, findKeyOrInsertPosition, v11));
        }
    }

    public boolean isEmpty() {
        return this.keys.length == 0;
    }

    public java.util.Iterator<Map.Entry<K, V>> iteratorFrom(K k11) {
        return iterator(findKeyOrInsertPosition(k11), false);
    }

    public ImmutableSortedMap<K, V> remove(K k11) {
        int findKey = findKey(k11);
        if (findKey == -1) {
            return this;
        }
        return new ArraySortedMap(this.comparator, removeFromArray(this.keys, findKey), removeFromArray(this.values, findKey));
    }

    public java.util.Iterator<Map.Entry<K, V>> reverseIterator() {
        return iterator(this.keys.length - 1, true);
    }

    public java.util.Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k11) {
        int findKeyOrInsertPosition = findKeyOrInsertPosition(k11);
        K[] kArr = this.keys;
        if (findKeyOrInsertPosition >= kArr.length || this.comparator.compare(kArr[findKeyOrInsertPosition], k11) != 0) {
            return iterator(findKeyOrInsertPosition - 1, true);
        }
        return iterator(findKeyOrInsertPosition, true);
    }

    public int size() {
        return this.keys.length;
    }

    public java.util.Iterator<Map.Entry<K, V>> iterator() {
        return iterator(0, false);
    }

    private ArraySortedMap(Comparator<K> comparator2, K[] kArr, V[] vArr) {
        this.keys = kArr;
        this.values = vArr;
        this.comparator = comparator2;
    }
}
