package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzry extends zzpo<Long> implements zzsv, RandomAccess {
    private static final zzry zzbck;
    private int size;
    private long[] zzbcl;

    static {
        zzry zzry = new zzry(new long[0], 0);
        zzbck = zzry;
        zzry.zzmi();
    }

    public zzry() {
        this(new long[10], 0);
    }

    private final void zzah(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
    }

    private final String zzai(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzk(int i11, long j11) {
        int i12;
        zzmz();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
        long[] jArr = this.zzbcl;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzbcl, i11, jArr2, i11 + 1, this.size - i11);
            this.zzbcl = jArr2;
        }
        this.zzbcl[i11] = j11;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzk(i11, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzry)) {
            return super.addAll(collection);
        }
        zzry zzry = (zzry) collection;
        int i11 = zzry.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.zzbcl;
            if (i13 > jArr.length) {
                this.zzbcl = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(zzry.zzbcl, 0, this.zzbcl, this.size, zzry.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzry)) {
            return super.equals(obj);
        }
        zzry zzry = (zzry) obj;
        if (this.size != zzry.size) {
            return false;
        }
        long[] jArr = zzry.zzbcl;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzbcl[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public final long getLong(int i11) {
        zzah(i11);
        return this.zzbcl[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzre.zzz(this.zzbcl[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzmz();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Long.valueOf(this.zzbcl[i11]))) {
                long[] jArr = this.zzbcl;
                System.arraycopy(jArr, i11 + 1, jArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzmz();
        if (i12 >= i11) {
            long[] jArr = this.zzbcl;
            System.arraycopy(jArr, i12, jArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzmz();
        zzah(i11);
        long[] jArr = this.zzbcl;
        long j11 = jArr[i11];
        jArr[i11] = longValue;
        return Long.valueOf(j11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzaa(long j11) {
        zzk(this.size, j11);
    }

    public final /* synthetic */ zzrj zzaj(int i11) {
        if (i11 >= this.size) {
            return new zzry(Arrays.copyOf(this.zzbcl, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzry(long[] jArr, int i11) {
        this.zzbcl = jArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzmz();
        zzah(i11);
        long[] jArr = this.zzbcl;
        long j11 = jArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j11);
    }
}
