package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    @CheckForNull
    @VisibleForTesting
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactLinkedHashMap<>(i11);
    }

    private int getPredecessor(int i11) {
        return ((int) (link(i11) >>> 32)) - 1;
    }

    private long link(int i11) {
        return requireLinks()[i11];
    }

    private long[] requireLinks() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void setLink(int i11, long j11) {
        requireLinks()[i11] = j11;
    }

    private void setPredecessor(int i11, int i12) {
        setLink(i11, (link(i11) & 4294967295L) | (((long) (i12 + 1)) << 32));
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
        setLink(i11, (link(i11) & -4294967296L) | (((long) (i12 + 1)) & 4294967295L));
    }

    public void accessEntry(int i11) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i11), getSuccessor(i11));
            setSucceeds(this.lastEntry, i11);
            setSucceeds(i11, -2);
            incrementModCount();
        }
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    public int allocArrays() {
        int allocArrays = super.allocArrays();
        this.links = new long[allocArrays];
        return allocArrays;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            long[] jArr = this.links;
            if (jArr != null) {
                Arrays.fill(jArr, 0, size(), 0);
            }
            super.clear();
        }
    }

    @CanIgnoreReturnValue
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return convertToHashFloodingResistantImplementation;
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i11) {
        return new LinkedHashMap(i11, 1.0f, this.accessOrder);
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i11) {
        return ((int) link(i11)) - 1;
    }

    public void init(int i11) {
        super.init(i11);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i11, @ParametricNullness K k11, @ParametricNullness V v11, int i12, int i13) {
        super.insertEntry(i11, k11, v11, i12, i13);
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
        setLink(size, 0);
    }

    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        this.links = Arrays.copyOf(requireLinks(), i11);
    }

    public CompactLinkedHashMap(int i11) {
        this(i11, false);
    }

    public CompactLinkedHashMap(int i11, boolean z11) {
        super(i11);
        this.accessOrder = z11;
    }
}
