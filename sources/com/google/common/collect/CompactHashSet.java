package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
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
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    @CheckForNull
    @VisibleForTesting
    transient Object[] elements;
    @CheckForNull
    private transient int[] entries;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @CheckForNull
    private transient Object table;

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    private Set<E> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashSet(i11, 1.0f);
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i11) {
        return new CompactHashSet<>(i11);
    }

    /* access modifiers changed from: private */
    public E element(int i11) {
        return requireElements()[i11];
    }

    private int entry(int i11) {
        return requireEntries()[i11];
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private Object[] requireElements() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
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

    private void setElement(int i11, E e11) {
        requireElements()[i11] = e11;
    }

    private void setEntry(int i11, int i12) {
        requireEntries()[i11] = i12;
    }

    private void setHashTableMask(int i11) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i11), 31);
    }

    @J2ktIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e11) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e11);
        }
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int i11 = this.size;
        int i12 = i11 + 1;
        int smearedHash = Hashing.smearedHash(e11);
        int hashTableMask = hashTableMask();
        int i13 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(requireTable(), i13);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i14 = 0;
            while (true) {
                int i15 = tableGet - 1;
                int i16 = requireEntries[i15];
                if (CompactHashing.getHashPrefix(i16, hashTableMask) == hashPrefix && com.google.common.base.Objects.equal(e11, requireElements[i15])) {
                    return false;
                }
                int next = CompactHashing.getNext(i16, hashTableMask);
                i14++;
                if (next != 0) {
                    tableGet = next;
                } else if (i14 >= 9) {
                    return convertToHashFloodingResistantImplementation().add(e11);
                } else {
                    if (i12 > hashTableMask) {
                        hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i11);
                    } else {
                        requireEntries[i15] = CompactHashing.maskCombine(i16, i12, hashTableMask);
                    }
                }
            }
        } else if (i12 > hashTableMask) {
            hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i11);
        } else {
            CompactHashing.tableSet(requireTable(), i13, i12);
        }
        resizeMeMaybe(i12);
        insertEntry(i11, e11, smearedHash, hashTableMask);
        this.size = i12;
        incrementModCount();
        return true;
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
        this.elements = new Object[i11];
        return i11;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            incrementModCount();
            Set delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                this.metadata = Ints.constrainToRange(size(), 3, 1073741823);
                delegateOrNull.clear();
                this.table = null;
                this.size = 0;
                return;
            }
            Arrays.fill(requireElements(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
            this.size = 0;
        }
    }

    public boolean contains(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(requireTable(), smearedHash & hashTableMask);
        if (tableGet == 0) {
            return false;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i11 = tableGet - 1;
            int entry = entry(i11);
            if (CompactHashing.getHashPrefix(entry, hashTableMask) == hashPrefix && com.google.common.base.Objects.equal(obj, element(i11))) {
                return true;
            }
            tableGet = CompactHashing.getNext(entry, hashTableMask);
        } while (tableGet != 0);
        return false;
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.add(element(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    @CheckForNull
    @VisibleForTesting
    public Set<E> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
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

    public void insertEntry(int i11, @ParametricNullness E e11, int i12, int i13) {
        setEntry(i11, CompactHashing.maskCombine(i12, 0, i13));
        setElement(i11, e11);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @VisibleForTesting
    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    public Iterator<E> iterator() {
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.iterator();
        }
        return new Object() {
            int currentIndex;
            int expectedMetadata;
            int indexToRemove = -1;

            {
                this.expectedMetadata = CompactHashSet.this.metadata;
                this.currentIndex = CompactHashSet.this.firstEntryIndex();
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.metadata != this.expectedMetadata) {
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
                return this.currentIndex >= 0;
            }

            public void incrementExpectedModCount() {
                this.expectedMetadata += 32;
            }

            @ParametricNullness
            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    int i11 = this.currentIndex;
                    this.indexToRemove = i11;
                    E access$100 = CompactHashSet.this.element(i11);
                    this.currentIndex = CompactHashSet.this.getSuccessor(this.currentIndex);
                    return access$100;
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
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.element(this.indexToRemove));
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }
        };
    }

    public void moveLastEntry(int i11, int i12) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int size2 = size() - 1;
        if (i11 < size2) {
            Object obj = requireElements[size2];
            requireElements[i11] = obj;
            requireElements[size2] = null;
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
            requireElements[i11] = null;
            requireEntries[i11] = 0;
        }
    }

    @VisibleForTesting
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, (Object) null, hashTableMask, requireTable(), requireEntries(), requireElements(), (Object[]) null);
        if (remove == -1) {
            return false;
        }
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i11) {
        this.entries = Arrays.copyOf(requireEntries(), i11);
        this.elements = Arrays.copyOf(requireElements(), i11);
    }

    public int size() {
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.size();
        }
        return this.size;
    }

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(requireElements(), this.size);
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Set delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                Set createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
                createHashFloodingResistantDelegate.addAll(delegateOrNull);
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

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i11) {
        init(i11);
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.toArray(tArr);
        }
        return ObjectArrays.toArrayImpl(requireElements(), 0, this.size, tArr);
    }
}
