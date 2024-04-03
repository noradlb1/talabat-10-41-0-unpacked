package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhq extends zzex<Long> implements zzio, RandomAccess {
    private static final zzhq zzyj;
    private int size;
    private long[] zzyk;

    static {
        zzhq zzhq = new zzhq(new long[0], 0);
        zzyj = zzhq;
        zzhq.zzdp();
    }

    public zzhq() {
        this(new long[10], 0);
    }

    private final void zzae(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
    }

    private final String zzaf(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        long longValue = ((Long) obj).longValue();
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        long[] jArr = this.zzyk;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzyk, i11, jArr2, i11 + 1, this.size - i11);
            this.zzyk = jArr2;
        }
        this.zzyk[i11] = longValue;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzhq)) {
            return super.addAll(collection);
        }
        zzhq zzhq = (zzhq) collection;
        int i11 = zzhq.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.zzyk;
            if (i13 > jArr.length) {
                this.zzyk = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(zzhq.zzyk, 0, this.zzyk, this.size, zzhq.size);
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
        if (!(obj instanceof zzhq)) {
            return super.equals(obj);
        }
        zzhq zzhq = (zzhq) obj;
        if (this.size != zzhq.size) {
            return false;
        }
        long[] jArr = zzhq.zzyk;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzyk[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public final long getLong(int i11) {
        zzae(i11);
        return this.zzyk[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzgt.zzab(this.zzyk[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Long.valueOf(this.zzyk[i11]))) {
                long[] jArr = this.zzyk;
                System.arraycopy(jArr, i11 + 1, jArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzdq();
        if (i12 >= i11) {
            long[] jArr = this.zzyk;
            System.arraycopy(jArr, i12, jArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzdq();
        zzae(i11);
        long[] jArr = this.zzyk;
        long j11 = jArr[i11];
        jArr[i11] = longValue;
        return Long.valueOf(j11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzac(long j11) {
        zzdq();
        int i11 = this.size;
        long[] jArr = this.zzyk;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.zzyk = jArr2;
        }
        long[] jArr3 = this.zzyk;
        int i12 = this.size;
        this.size = i12 + 1;
        jArr3[i12] = j11;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zzhq(Arrays.copyOf(this.zzyk, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzhq(long[] jArr, int i11) {
        this.zzyk = jArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        zzae(i11);
        long[] jArr = this.zzyk;
        long j11 = jArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j11);
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzac(((Long) obj).longValue());
        return true;
    }
}
