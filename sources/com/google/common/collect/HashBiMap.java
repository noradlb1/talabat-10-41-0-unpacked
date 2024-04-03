package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    @LazyInit
    private transient Set<Map.Entry<K, V>> entrySet;
    /* access modifiers changed from: private */
    public transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    /* access modifiers changed from: private */
    @RetainedWith
    @CheckForNull
    @LazyInit
    public transient BiMap<V, K> inverse;
    @LazyInit
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    /* access modifiers changed from: private */
    public transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    @LazyInit
    private transient Set<V> valueSet;
    transient V[] values;

    public final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;
        @ParametricNullness
        final K key;

        public EntryForKey(int i11) {
            this.key = NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i11]);
            this.index = i11;
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @ParametricNullness
        public V getValue() {
            updateIndex();
            int i11 = this.index;
            if (i11 == -1) {
                return NullnessCasts.unsafeNull();
            }
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i11]);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v11) {
            updateIndex();
            int i11 = this.index;
            if (i11 == -1) {
                HashBiMap.this.put(this.key, v11);
                return NullnessCasts.unsafeNull();
            }
            V uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i11]);
            if (Objects.equal(uncheckedCastNullableTToT, v11)) {
                return v11;
            }
            HashBiMap.this.replaceValueInEntry(this.index, v11, false);
            return uncheckedCastNullableTToT;
        }

        public void updateIndex() {
            int i11 = this.index;
            if (i11 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i11 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i11], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }
    }

    public static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;
        @ParametricNullness
        final V value;

        public EntryForValue(HashBiMap<K, V> hashBiMap, int i11) {
            this.biMap = hashBiMap;
            this.value = NullnessCasts.uncheckedCastNullableTToT(hashBiMap.values[i11]);
            this.index = i11;
        }

        private void updateIndex() {
            int i11 = this.index;
            if (i11 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i11 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i11])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @ParametricNullness
        public V getKey() {
            return this.value;
        }

        @ParametricNullness
        public K getValue() {
            updateIndex();
            int i11 = this.index;
            if (i11 == -1) {
                return NullnessCasts.unsafeNull();
            }
            return NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i11]);
        }

        @ParametricNullness
        public K setValue(@ParametricNullness K k11) {
            updateIndex();
            int i11 = this.index;
            if (i11 == -1) {
                this.biMap.putInverse(this.value, k11, false);
                return NullnessCasts.unsafeNull();
            }
            K uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.biMap.keys[i11]);
            if (Objects.equal(uncheckedCastNullableTToT, k11)) {
                return k11;
            }
            this.biMap.replaceKeyInEntry(this.index, k11, false);
            return uncheckedCastNullableTToT;
        }
    }

    public final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        public EntrySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            return true;
        }

        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }

        public Map.Entry<K, V> forEntry(int i11) {
            return new EntryForKey(i11);
        }
    }

    public static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            BiMap unused = this.forward.inverse = this;
        }

        public void clear() {
            this.forward.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.forward.containsValue(obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.forward.containsKey(obj);
        }

        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet2 = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet2;
            return inverseEntrySet2;
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K forcePut(@ParametricNullness V v11, @ParametricNullness K k11) {
            return this.forward.putInverse(v11, k11, true);
        }

        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.forward.getInverse(obj);
        }

        public BiMap<K, V> inverse() {
            return this.forward;
        }

        public Set<V> keySet() {
            return this.forward.values();
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K put(@ParametricNullness V v11, @ParametricNullness K k11) {
            return this.forward.putInverse(v11, k11, false);
        }

        @CheckForNull
        @CanIgnoreReturnValue
        public K remove(@CheckForNull Object obj) {
            return this.forward.removeInverse(obj);
        }

        public int size() {
            return this.forward.size;
        }

        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        public InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.biMap.findEntryByValue(key);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            return true;
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }

        public Map.Entry<V, K> forEntry(int i11) {
            return new EntryForValue(this.biMap, i11);
        }
    }

    public final class KeySet extends View<K, V, K> {
        public KeySet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @ParametricNullness
        public K forEntry(int i11) {
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.keys[i11]);
        }

        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    public final class ValueSet extends View<K, V, V> {
        public ValueSet() {
            super(HashBiMap.this);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @ParametricNullness
        public V forEntry(int i11) {
            return NullnessCasts.uncheckedCastNullableTToT(HashBiMap.this.values[i11]);
        }

        public boolean remove(@CheckForNull Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }
    }

    public static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        public View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }

        public void clear() {
            this.biMap.clear();
        }

        @ParametricNullness
        public abstract T forEntry(int i11);

        public Iterator<T> iterator() {
            return new Object() {
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = View.this.biMap.firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                public /* synthetic */ void forEachRemaining(Consumer consumer) {
                    Iterator.CC.$default$forEachRemaining(this, consumer);
                }

                public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                    forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                }

                public boolean hasNext() {
                    checkForComodification();
                    if (this.index == -2 || this.remaining <= 0) {
                        return false;
                    }
                    return true;
                }

                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        T forEntry = View.this.forEntry(this.index);
                        this.indexToRemove = this.index;
                        this.index = View.this.biMap.nextInInsertionOrder[this.index];
                        this.remaining--;
                        return forEntry;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    boolean z11;
                    checkForComodification();
                    if (this.indexToRemove != -1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    CollectPreconditions.checkRemove(z11);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    int i11 = this.index;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    if (i11 == hashBiMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = hashBiMap.modCount;
                }
            };
        }

        public int size() {
            return this.biMap.size;
        }
    }

    private HashBiMap(int i11) {
        init(i11);
    }

    private int bucket(int i11) {
        return i11 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i11, int i12) {
        boolean z11;
        if (i11 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int bucket = bucket(i12);
        int[] iArr = this.hashTableKToV;
        int i13 = iArr[bucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketKToV[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            int i16 = i15;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i11]);
            } else if (i13 == i11) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i16] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            } else {
                i14 = this.nextInBucketKToV[i13];
            }
        }
    }

    private void deleteFromTableVToK(int i11, int i12) {
        boolean z11;
        if (i11 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int bucket = bucket(i12);
        int[] iArr = this.hashTableVToK;
        int i13 = iArr[bucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketVToK[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            int i16 = i15;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i11]);
            } else if (i13 == i11) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i16] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            } else {
                i14 = this.nextInBucketVToK[i13];
            }
        }
    }

    private void ensureCapacity(int i11) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i11) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i11);
            this.keys = Arrays.copyOf(this.keys, expandedCapacity);
            this.values = Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i11) {
            int closedTableSize = Hashing.closedTableSize(i11, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i12 = 0; i12 < this.size; i12++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i12]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i12] = iArr3[bucket];
                iArr3[bucket] = i12;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i12]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i12] = iArr5[bucket2];
                iArr5[bucket2] = i12;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i11) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i11);
        Arrays.fill(copyOf, length, i11, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i11, int i12) {
        boolean z11;
        if (i11 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int bucket = bucket(i12);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i11] = iArr2[bucket];
        iArr2[bucket] = i11;
    }

    private void insertIntoTableVToK(int i11, int i12) {
        boolean z11;
        if (i11 != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        int bucket = bucket(i12);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i11] = iArr2[bucket];
        iArr2[bucket] = i11;
    }

    private void moveEntryToIndex(int i11, int i12) {
        int i13;
        int i14;
        if (i11 != i12) {
            int i15 = this.prevInInsertionOrder[i11];
            int i16 = this.nextInInsertionOrder[i11];
            setSucceeds(i15, i12);
            setSucceeds(i12, i16);
            K[] kArr = this.keys;
            K k11 = kArr[i11];
            V[] vArr = this.values;
            V v11 = vArr[i11];
            kArr[i12] = k11;
            vArr[i12] = v11;
            int bucket = bucket(Hashing.smearedHash(k11));
            int[] iArr = this.hashTableKToV;
            int i17 = iArr[bucket];
            if (i17 == i11) {
                iArr[bucket] = i12;
            } else {
                int i18 = this.nextInBucketKToV[i17];
                while (true) {
                    int i19 = i17;
                    i17 = i18;
                    i14 = i19;
                    if (i17 == i11) {
                        break;
                    }
                    i18 = this.nextInBucketKToV[i17];
                }
                this.nextInBucketKToV[i14] = i12;
            }
            int[] iArr2 = this.nextInBucketKToV;
            iArr2[i12] = iArr2[i11];
            iArr2[i11] = -1;
            int bucket2 = bucket(Hashing.smearedHash(v11));
            int[] iArr3 = this.hashTableVToK;
            int i21 = iArr3[bucket2];
            if (i21 == i11) {
                iArr3[bucket2] = i12;
            } else {
                int i22 = this.nextInBucketVToK[i21];
                while (true) {
                    int i23 = i21;
                    i21 = i22;
                    i13 = i23;
                    if (i21 == i11) {
                        break;
                    }
                    i22 = this.nextInBucketVToK[i21];
                }
                this.nextInBucketVToK[i13] = i12;
            }
            int[] iArr4 = this.nextInBucketVToK;
            iArr4[i12] = iArr4[i11];
            iArr4[i11] = -1;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    /* access modifiers changed from: private */
    public void replaceKeyInEntry(int i11, @ParametricNullness K k11, boolean z11) {
        boolean z12;
        int i12;
        if (i11 != -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        int smearedHash = Hashing.smearedHash(k11);
        int findEntryByKey = findEntryByKey(k11, smearedHash);
        int i13 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i12 = -2;
        } else if (z11) {
            i13 = this.prevInInsertionOrder[findEntryByKey];
            i12 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            if (i11 == this.size) {
                i11 = findEntryByKey;
            }
        } else {
            throw new IllegalArgumentException("Key already present in map: " + k11);
        }
        if (i13 == i11) {
            i13 = this.prevInInsertionOrder[i11];
        } else if (i13 == this.size) {
            i13 = findEntryByKey;
        }
        if (i12 == i11) {
            findEntryByKey = this.nextInInsertionOrder[i11];
        } else if (i12 != this.size) {
            findEntryByKey = i12;
        }
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        deleteFromTableKToV(i11, Hashing.smearedHash(this.keys[i11]));
        this.keys[i11] = k11;
        insertIntoTableKToV(i11, Hashing.smearedHash(k11));
        setSucceeds(i13, i11);
        setSucceeds(i11, findEntryByKey);
    }

    /* access modifiers changed from: private */
    public void replaceValueInEntry(int i11, @ParametricNullness V v11, boolean z11) {
        boolean z12;
        if (i11 != -1) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        int smearedHash = Hashing.smearedHash(v11);
        int findEntryByValue = findEntryByValue(v11, smearedHash);
        if (findEntryByValue != -1) {
            if (z11) {
                removeEntryValueHashKnown(findEntryByValue, smearedHash);
                if (i11 == this.size) {
                    i11 = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v11);
            }
        }
        deleteFromTableVToK(i11, Hashing.smearedHash(this.values[i11]));
        this.values[i11] = v11;
        insertIntoTableVToK(i11, smearedHash);
    }

    private void setSucceeds(int i11, int i12) {
        if (i11 == -2) {
            this.firstInInsertionOrder = i12;
        } else {
            this.nextInInsertionOrder[i11] = i12;
        }
        if (i12 == -2) {
            this.lastInInsertionOrder = i11;
        } else {
            this.prevInInsertionOrder[i12] = i11;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return findEntryByKey(obj) != -1;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return findEntryByValue(obj) != -1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public int findEntry(@CheckForNull Object obj, int i11, int[] iArr, int[] iArr2, Object[] objArr) {
        int i12 = iArr[bucket(i11)];
        while (i12 != -1) {
            if (Objects.equal(objArr[i12], obj)) {
                return i12;
            }
            i12 = iArr2[i12];
        }
        return -1;
    }

    public int findEntryByKey(@CheckForNull Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    public int findEntryByValue(@CheckForNull Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V forcePut(@ParametricNullness K k11, @ParametricNullness V v11) {
        return put(k11, v11, true);
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @CheckForNull
    public K getInverse(@CheckForNull Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i11) {
        CollectPreconditions.checkNonnegative(i11, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i11, 1.0d);
        this.size = 0;
        this.keys = new Object[i11];
        this.values = new Object[i11];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i11);
        this.nextInBucketVToK = createFilledWithAbsent(i11);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i11);
        this.nextInInsertionOrder = createFilledWithAbsent(i11);
    }

    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse2 = new Inverse(this);
        this.inverse = inverse2;
        return inverse2;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V put(@ParametricNullness K k11, @ParametricNullness V v11) {
        return put(k11, v11, false);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public K putInverse(@ParametricNullness V v11, @ParametricNullness K k11, boolean z11) {
        int i11;
        boolean z12;
        int smearedHash = Hashing.smearedHash(v11);
        int findEntryByValue = findEntryByValue(v11, smearedHash);
        if (findEntryByValue != -1) {
            K k12 = this.keys[findEntryByValue];
            if (Objects.equal(k12, k11)) {
                return k11;
            }
            replaceKeyInEntry(findEntryByValue, k11, z11);
            return k12;
        }
        int i12 = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k11);
        int findEntryByKey = findEntryByKey(k11, smearedHash2);
        if (!z11) {
            if (findEntryByKey == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12, "Key already present: %s", (Object) k11);
        } else if (findEntryByKey != -1) {
            i12 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i13 = this.size;
        kArr[i13] = k11;
        this.values[i13] = v11;
        insertIntoTableKToV(i13, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        if (i12 == -2) {
            i11 = this.firstInInsertionOrder;
        } else {
            i11 = this.nextInInsertionOrder[i12];
        }
        setSucceeds(i12, this.size);
        setSucceeds(this.size, i11);
        this.size++;
        this.modCount++;
        return null;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v11 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v11;
    }

    public void removeEntry(int i11) {
        removeEntryKeyHashKnown(i11, Hashing.smearedHash(this.keys[i11]));
    }

    public void removeEntryKeyHashKnown(int i11, int i12) {
        removeEntry(i11, i12, Hashing.smearedHash(this.values[i11]));
    }

    public void removeEntryValueHashKnown(int i11, int i12) {
        removeEntry(i11, Hashing.smearedHash(this.keys[i11]), i12);
    }

    @CheckForNull
    public K removeInverse(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k11 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k11;
    }

    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i11) {
        return new HashBiMap<>(i11);
    }

    private void removeEntry(int i11, int i12, int i13) {
        Preconditions.checkArgument(i11 != -1);
        deleteFromTableKToV(i11, i12);
        deleteFromTableVToK(i11, i13);
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        moveEntryToIndex(this.size - 1, i11);
        K[] kArr = this.keys;
        int i14 = this.size;
        kArr[i14 - 1] = null;
        this.values[i14 - 1] = null;
        this.size = i14 - 1;
        this.modCount++;
    }

    public int findEntryByKey(@CheckForNull Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(@CheckForNull Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    @CheckForNull
    public V put(@ParametricNullness K k11, @ParametricNullness V v11, boolean z11) {
        int smearedHash = Hashing.smearedHash(k11);
        int findEntryByKey = findEntryByKey(k11, smearedHash);
        if (findEntryByKey != -1) {
            V v12 = this.values[findEntryByKey];
            if (Objects.equal(v12, v11)) {
                return v11;
            }
            replaceValueInEntry(findEntryByKey, v11, z11);
            return v12;
        }
        int smearedHash2 = Hashing.smearedHash(v11);
        int findEntryByValue = findEntryByValue(v11, smearedHash2);
        if (!z11) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", (Object) v11);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = k11;
        this.values[i11] = v11;
        insertIntoTableKToV(i11, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
