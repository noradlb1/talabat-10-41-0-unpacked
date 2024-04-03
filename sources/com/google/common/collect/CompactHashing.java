package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    private CompactHashing() {
    }

    public static Object createTable(int i11) {
        if (i11 < 2 || i11 > 1073741824 || Integer.highestOneBit(i11) != i11) {
            throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i11);
        } else if (i11 <= 256) {
            return new byte[i11];
        } else {
            if (i11 <= 65536) {
                return new short[i11];
            }
            return new int[i11];
        }
    }

    public static int getHashPrefix(int i11, int i12) {
        return i11 & (~i12);
    }

    public static int getNext(int i11, int i12) {
        return i11 & i12;
    }

    public static int maskCombine(int i11, int i12, int i13) {
        return (i11 & (~i13)) | (i12 & i13);
    }

    public static int newCapacity(int i11) {
        return (i11 < 32 ? 4 : 2) * (i11 + 1);
    }

    public static int remove(@CheckForNull Object obj, @CheckForNull Object obj2, int i11, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i12;
        int i13;
        int smearedHash = Hashing.smearedHash(obj);
        int i14 = smearedHash & i11;
        int tableGet = tableGet(obj3, i14);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(smearedHash, i11);
        int i15 = -1;
        while (true) {
            i12 = tableGet - 1;
            i13 = iArr[i12];
            if (getHashPrefix(i13, i11) != hashPrefix || !Objects.equal(obj, objArr[i12]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i12]))) {
                int next = getNext(i13, i11);
                if (next == 0) {
                    return -1;
                }
                int i16 = next;
                i15 = i12;
                tableGet = i16;
            }
        }
        int next2 = getNext(i13, i11);
        if (i15 == -1) {
            tableSet(obj3, i14, next2);
        } else {
            iArr[i15] = maskCombine(iArr[i15], next2, i11);
        }
        return i12;
    }

    public static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int tableGet(Object obj, int i11) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i11] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i11] & UShort.MAX_VALUE;
        }
        return ((int[]) obj)[i11];
    }

    public static void tableSet(Object obj, int i11, int i12) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i11] = (byte) i12;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i11] = (short) i12;
        } else {
            ((int[]) obj)[i11] = i12;
        }
    }

    public static int tableSize(int i11) {
        return Math.max(4, Hashing.closedTableSize(i11 + 1, 1.0d));
    }
}
