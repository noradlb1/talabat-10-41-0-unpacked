package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdc extends zzav<Long> implements RandomAccess {
    private static final zzdc zzlw;
    private int size;
    private long[] zzlx;

    static {
        zzdc zzdc = new zzdc();
        zzlw = zzdc;
        zzdc.zzv();
    }

    public zzdc() {
        this(new long[10], 0);
    }

    private zzdc(long[] jArr, int i11) {
        this.zzlx = jArr;
        this.size = i11;
    }

    public static zzdc zzbx() {
        return zzlw;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
    }

    private final String zzh(int i11) {
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
        zzw();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
        long[] jArr = this.zzlx;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzlx, i11, jArr2, i11 + 1, this.size - i11);
            this.zzlx = jArr2;
        }
        this.zzlx[i11] = j11;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzk(i11, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof zzdc)) {
            return super.addAll(collection);
        }
        zzdc zzdc = (zzdc) collection;
        int i11 = zzdc.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.zzlx;
            if (i13 > jArr.length) {
                this.zzlx = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(zzdc.zzlx, 0, this.zzlx, this.size, zzdc.size);
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
        if (!(obj instanceof zzdc)) {
            return super.equals(obj);
        }
        zzdc zzdc = (zzdc) obj;
        if (this.size != zzdc.size) {
            return false;
        }
        long[] jArr = zzdc.zzlx;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzlx[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public final long getLong(int i11) {
        zzg(i11);
        return this.zzlx[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzci.zzl(this.zzlx[i12]);
        }
        return i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzw();
        zzg(i11);
        long[] jArr = this.zzlx;
        long j11 = jArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, i12 - i11);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j11);
    }

    public final boolean remove(Object obj) {
        zzw();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Long.valueOf(this.zzlx[i11]))) {
                long[] jArr = this.zzlx;
                System.arraycopy(jArr, i11 + 1, jArr, i11, this.size - i11);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzw();
        if (i12 >= i11) {
            long[] jArr = this.zzlx;
            System.arraycopy(jArr, i12, jArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzw();
        zzg(i11);
        long[] jArr = this.zzlx;
        long j11 = jArr[i11];
        jArr[i11] = longValue;
        return Long.valueOf(j11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzcn zzi(int i11) {
        if (i11 >= this.size) {
            return new zzdc(Arrays.copyOf(this.zzlx, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzm(long j11) {
        zzk(this.size, j11);
    }
}
