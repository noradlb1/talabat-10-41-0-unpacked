package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    /* access modifiers changed from: private */
    public static final Object NOT_FOUND = new Object();
    @CheckForNull
    @VisibleForTesting
    transient int[] entries;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;
    @CheckForNull
    private transient Set<K> keySetView;
    @CheckForNull
    @VisibleForTesting
    transient Object[] keys;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @CheckForNull
    private transient Object table;
    @CheckForNull
    @VisibleForTesting
    transient Object[] values;
    @CheckForNull
    private transient Collection<V> valuesView;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        public EntrySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$500 = CompactHashMap.this.indexOf(entry.getKey());
            if (access$500 == -1 || !Objects.equal(CompactHashMap.this.value(access$500), entry.getValue())) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            r0 = com.google.common.collect.CompactHashMap.access$700(r9.this$0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(@javax.annotation.CheckForNull java.lang.Object r10) {
            /*
                r9 = this;
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                java.util.Map r0 = r0.delegateOrNull()
                if (r0 == 0) goto L_0x0011
                java.util.Set r0 = r0.entrySet()
                boolean r10 = r0.remove(r10)
                return r10
            L_0x0011:
                boolean r0 = r10 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0061
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                boolean r0 = r0.needsAllocArrays()
                if (r0 == 0) goto L_0x0021
                return r1
            L_0x0021:
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                int r0 = r0.hashTableMask()
                java.lang.Object r2 = r10.getKey()
                java.lang.Object r3 = r10.getValue()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object r5 = r10.requireTable()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                int[] r6 = r10.requireEntries()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r7 = r10.requireKeys()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r8 = r10.requireValues()
                r4 = r0
                int r10 = com.google.common.collect.CompactHashing.remove(r2, r3, r4, r5, r6, r7, r8)
                r2 = -1
                if (r10 != r2) goto L_0x0050
                return r1
            L_0x0050:
                com.google.common.collect.CompactHashMap r1 = com.google.common.collect.CompactHashMap.this
                r1.moveLastEntry(r10, r0)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                com.google.common.collect.CompactHashMap.access$1210(r10)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                r10.incrementModCount()
                r10 = 1
                return r10
            L_0x0061:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.EntrySetView.remove(java.lang.Object):boolean");
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public abstract class Itr<T> implements Iterator<T>, j$.util.Iterator {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @ParametricNullness
        public abstract T getOutput(int i11);

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        public void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        @ParametricNullness
        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i11 = this.currentIndex;
                this.indexToRemove = i11;
                T output = getOutput(i11);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z11;
            checkForConcurrentModification();
            if (this.indexToRemove >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            CollectPreconditions.checkRemove(z11);
            incrementExpectedModCount();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.indexToRemove));
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    public class KeySetView extends AbstractSet<K> {
        public KeySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public java.util.Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public boolean remove(@CheckForNull Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.keySet().remove(obj);
            }
            if (CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND) {
                return true;
            }
            return false;
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {
        @ParametricNullness
        private final K key;
        private int lastKnownIndex;

        public MapEntry(int i11) {
            this.key = CompactHashMap.this.key(i11);
            this.lastKnownIndex = i11;
        }

        private void updateLastKnownIndex() {
            int i11 = this.lastKnownIndex;
            if (i11 == -1 || i11 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.key(this.lastKnownIndex))) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @ParametricNullness
        public V getValue() {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.get(this.key));
            }
            updateLastKnownIndex();
            int i11 = this.lastKnownIndex;
            if (i11 == -1) {
                return NullnessCasts.unsafeNull();
            }
            return CompactHashMap.this.value(i11);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v11) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return NullnessCasts.uncheckedCastNullableTToT(delegateOrNull.put(this.key, v11));
            }
            updateLastKnownIndex();
            int i11 = this.lastKnownIndex;
            if (i11 == -1) {
                CompactHashMap.this.put(this.key, v11);
                return NullnessCasts.unsafeNull();
            }
            V access$600 = CompactHashMap.this.value(i11);
            CompactHashMap.this.setValue(this.lastKnownIndex, v11);
            return access$600;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        public ValuesView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public java.util.Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i11 = compactHashMap.size;
        compactHashMap.size = i11 - 1;
        return i11;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactHashMap<>(i11);
    }

    private int entry(int i11) {
        return requireEntries()[i11];
    }

    /* access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public int indexOf(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(requireTable(), smearedHash & hashTableMask);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i11 = tableGet - 1;
            int entry = entry(i11);
            if (CompactHashing.getHashPrefix(entry, hashTableMask) == hashPrefix && Objects.equal(obj, key(i11))) {
                return i11;
            }
            tableGet = CompactHashing.getNext(entry, hashTableMask);
        } while (tableGet != 0);
        return -1;
    }

    /* access modifiers changed from: private */
    public K key(int i11) {
        return requireKeys()[i11];
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    /* access modifiers changed from: private */
    public Object removeHelper(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, (Object) null, hashTableMask, requireTable(), requireEntries(), requireKeys(), (Object[]) null);
        if (remove == -1) {
            return NOT_FOUND;
        }
        Object value = value(remove);
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return value;
    }

    /* access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i11) {
        int min;
        int length = requireEntries().length;
        if (i11 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            resizeEntries(min);
        }
    }

    @CanIgnoreReturnValue
    private int resizeTable(int i11, int i12, int i13, int i14) {
        Object createTable = CompactHashing.createTable(i12);
        int i15 = i12 - 1;
        if (i14 != 0) {
            CompactHashing.tableSet(createTable, i13 & i15, i14 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i16 = 0; i16 <= i11; i16++) {
            int tableGet = CompactHashing.tableGet(requireTable, i16);
            while (tableGet != 0) {
                int i17 = tableGet - 1;
                int i18 = requireEntries[i17];
                int hashPrefix = CompactHashing.getHashPrefix(i18, i11) | i16;
                int i19 = hashPrefix & i15;
                int tableGet2 = CompactHashing.tableGet(createTable, i19);
                CompactHashing.tableSet(createTable, i19, tableGet);
                requireEntries[i17] = CompactHashing.maskCombine(hashPrefix, tableGet2, i15);
                tableGet = CompactHashing.getNext(i18, i11);
            }
        }
        this.table = createTable;
        setHashTableMask(i15);
        return i15;
    }

    private void setEntry(int i11, int i12) {
        requireEntries()[i11] = i12;
    }

    private void setHashTableMask(int i11) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i11), 31);
    }

    private void setKey(int i11, K k11) {
        requireKeys()[i11] = k11;
    }

    /* access modifiers changed from: private */
    public void setValue(int i11, V v11) {
        requireValues()[i11] = v11;
    }

    /* access modifiers changed from: private */
    public V value(int i11) {
        return requireValues()[i11];
    }

    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        java.util.Iterator entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) entrySetIterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public void accessEntry(int i11) {
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    @CanIgnoreReturnValue
    public int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.metadata;
        int tableSize = CompactHashing.tableSize(i11);
        this.table = CompactHashing.createTable(tableSize);
        setHashTableMask(tableSize - 1);
        this.entries = new int[i11];
        this.keys = new Object[i11];
        this.values = new Object[i11];
        return i11;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            incrementModCount();
            Map delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                this.metadata = Ints.constrainToRange(size(), 3, 1073741823);
                delegateOrNull.clear();
                this.table = null;
                this.size = 0;
                return;
            }
            Arrays.fill(requireKeys(), 0, this.size, (Object) null);
            Arrays.fill(requireValues(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
            this.size = 0;
        }
    }

    public boolean containsKey(@CheckForNull Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsKey(obj);
        }
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Objects.equal(obj, value(i11))) {
                return true;
            }
        }
        return false;
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(key(firstEntryIndex), value(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashMap(i11, 1.0f);
    }

    public Set<K> createKeySet() {
        return new KeySetView();
    }

    public Collection<V> createValues() {
        return new ValuesView();
    }

    @CheckForNull
    @VisibleForTesting
    public Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public java.util.Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.entrySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            public Map.Entry<K, V> getOutput(int i11) {
                return new MapEntry(i11);
            }
        };
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return value(indexOf);
    }

    public int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.size) {
            return i12;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i11) {
        boolean z11;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i11, 1, 1073741823);
    }

    public void insertEntry(int i11, @ParametricNullness K k11, @ParametricNullness V v11, int i12, int i13) {
        setEntry(i11, CompactHashing.maskCombine(i12, 0, i13));
        setKey(i11, k11);
        setValue(i11, v11);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public java.util.Iterator<K> keySetIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.keySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<K>() {
            @ParametricNullness
            public K getOutput(int i11) {
                return CompactHashMap.this.key(i11);
            }
        };
    }

    public void moveLastEntry(int i11, int i12) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int size2 = size() - 1;
        if (i11 < size2) {
            Object obj = requireKeys[size2];
            requireKeys[i11] = obj;
            requireValues[i11] = requireValues[size2];
            requireKeys[size2] = null;
            requireValues[size2] = null;
            requireEntries[i11] = requireEntries[size2];
            requireEntries[size2] = 0;
            int smearedHash = Hashing.smearedHash(obj) & i12;
            int tableGet = CompactHashing.tableGet(requireTable, smearedHash);
            int i13 = size2 + 1;
            if (tableGet == i13) {
                CompactHashing.tableSet(requireTable, smearedHash, i11 + 1);
                return;
            }
            while (true) {
                int i14 = tableGet - 1;
                int i15 = requireEntries[i14];
                int next = CompactHashing.getNext(i15, i12);
                if (next == i13) {
                    requireEntries[i14] = CompactHashing.maskCombine(i15, i11 + 1, i12);
                    return;
                }
                tableGet = next;
            }
        } else {
            requireKeys[i11] = null;
            requireValues[i11] = null;
            requireEntries[i11] = 0;
        }
    }

    @VisibleForTesting
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V put(@ParametricNullness K k11, @ParametricNullness V v11) {
        int i11;
        int resizeTable;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k11, v11);
        }
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        V[] requireValues = requireValues();
        int i12 = this.size;
        int i13 = i12 + 1;
        int smearedHash = Hashing.smearedHash(k11);
        int hashTableMask = hashTableMask();
        int i14 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(requireTable(), i14);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i15 = 0;
            while (true) {
                int i16 = tableGet - 1;
                int i17 = requireEntries[i16];
                if (CompactHashing.getHashPrefix(i17, hashTableMask) != hashPrefix || !Objects.equal(k11, requireKeys[i16])) {
                    int next = CompactHashing.getNext(i17, hashTableMask);
                    i15++;
                    if (next != 0) {
                        tableGet = next;
                    } else if (i15 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k11, v11);
                    } else {
                        if (i13 > hashTableMask) {
                            resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i12);
                        } else {
                            requireEntries[i16] = CompactHashing.maskCombine(i17, i13, hashTableMask);
                        }
                    }
                } else {
                    V v12 = requireValues[i16];
                    requireValues[i16] = v11;
                    accessEntry(i16);
                    return v12;
                }
            }
            i11 = hashTableMask;
            resizeMeMaybe(i13);
            insertEntry(i12, k11, v11, smearedHash, i11);
            this.size = i13;
            incrementModCount();
            return null;
        } else if (i13 > hashTableMask) {
            resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i12);
        } else {
            CompactHashing.tableSet(requireTable(), i14, i13);
            i11 = hashTableMask;
            resizeMeMaybe(i13);
            insertEntry(i12, k11, v11, smearedHash, i11);
            this.size = i13;
            incrementModCount();
            return null;
        }
        i11 = resizeTable;
        resizeMeMaybe(i13);
        insertEntry(i12, k11, v11, smearedHash, i11);
        this.size = i13;
        incrementModCount();
        return null;
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V removeHelper = removeHelper(obj);
        if (removeHelper == NOT_FOUND) {
            return null;
        }
        return removeHelper;
    }

    public void resizeEntries(int i11) {
        this.entries = Arrays.copyOf(requireEntries(), i11);
        this.keys = Arrays.copyOf(requireKeys(), i11);
        this.values = Arrays.copyOf(requireValues(), i11);
    }

    public int size() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.size();
        }
        return this.size;
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Map delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                Map createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
                createHashFloodingResistantDelegate.putAll(delegateOrNull);
                this.table = createHashFloodingResistantDelegate;
                return;
            }
            int i11 = this.size;
            if (i11 < requireEntries().length) {
                resizeEntries(i11);
            }
            int tableSize = CompactHashing.tableSize(i11);
            int hashTableMask = hashTableMask();
            if (tableSize < hashTableMask) {
                resizeTable(hashTableMask, tableSize, 0, 0);
            }
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public java.util.Iterator<V> valuesIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.values().iterator();
        }
        return new CompactHashMap<K, V>.Itr<V>() {
            @ParametricNullness
            public V getOutput(int i11) {
                return CompactHashMap.this.value(i11);
            }
        };
    }

    public CompactHashMap(int i11) {
        init(i11);
    }
}
