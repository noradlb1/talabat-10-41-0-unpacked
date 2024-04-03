package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY;
    private static final Object[] EMPTY_ARRAY;
    @VisibleForTesting
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    @VisibleForTesting
    final transient Object[] table;

    static {
        Object[] objArr = new Object[0];
        EMPTY_ARRAY = objArr;
        EMPTY = new RegularImmutableSet(objArr, 0, objArr, 0, 0);
    }

    public RegularImmutableSet(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.elements = objArr;
        this.hashCode = i11;
        this.table = objArr2;
        this.mask = i12;
        this.size = i13;
    }

    public boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        while (true) {
            int i11 = smearedHash & this.mask;
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            smearedHash = i11 + 1;
        }
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        System.arraycopy(this.elements, 0, objArr, i11, this.size);
        return i11 + this.size;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.size);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object[] internalArray() {
        return this.elements;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public boolean isHashCodeFast() {
        return true;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }
}
