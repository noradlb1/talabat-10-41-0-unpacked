package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    @CheckForNull
    private transient int[] predecessor;
    @CheckForNull
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i11) {
        return new CompactLinkedHashSet<>(i11);
    }

    private int getPredecessor(int i11) {
        return requirePredecessors()[i11] - 1;
    }

    private int[] requirePredecessors() {
        int[] iArr = this.predecessor;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] requireSuccessors() {
        int[] iArr = this.successor;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void setPredecessor(int i11, int i12) {
        requirePredecessors()[i11] = i12 + 1;
    }

    private void setSucceeds(int i11, int i12) {
        if (i11 == -2) {
            this.firstEntry = i12;
        } else {
            setSuccessor(i11, i12);
        }
        if (i12 == -2) {
            this.lastEntry = i11;
        } else {
            setPredecessor(i12, i11);
        }
    }

    private void setSuccessor(int i11, int i12) {
        requireSuccessors()[i11] = i12 + 1;
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    public int allocArrays() {
        int allocArrays = super.allocArrays();
        this.predecessor = new int[allocArrays];
        this.successor = new int[allocArrays];
        return allocArrays;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            int[] iArr = this.predecessor;
            if (!(iArr == null || this.successor == null)) {
                Arrays.fill(iArr, 0, size(), 0);
                Arrays.fill(this.successor, 0, size(), 0);
            }
            super.clear();
        }
    }

    @CanIgnoreReturnValue
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.predecessor = null;
        this.successor = null;
        return convertToHashFloodingResistantImplementation;
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i11) {
        return requireSuccessors()[i11] - 1;
    }

    public void init(int i11) {
        super.init(i11);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i11, @ParametricNullness E e11, int i12, int i13) {
        super.insertEntry(i11, e11, i12, i13);
        setSucceeds(this.lastEntry, i11);
        setSucceeds(i11, -2);
    }

    public void moveLastEntry(int i11, int i12) {
        int size = size() - 1;
        super.moveLastEntry(i11, i12);
        setSucceeds(getPredecessor(i11), getSuccessor(i11));
        if (i11 < size) {
            setSucceeds(getPredecessor(size), i11);
            setSucceeds(i11, getSuccessor(size));
        }
        requirePredecessors()[size] = 0;
        requireSuccessors()[size] = 0;
    }

    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        this.predecessor = Arrays.copyOf(requirePredecessors(), i11);
        this.successor = Arrays.copyOf(requireSuccessors(), i11);
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public CompactLinkedHashSet(int i11) {
        super(i11);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public <T> T[] toArray(T[] tArr) {
        return ObjectArrays.toArrayImpl(this, tArr);
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
