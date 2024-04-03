package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzby extends zzq<Long> implements zzcw, RandomAccess {
    private static final zzby zzkg;
    private int size;
    private long[] zzkh;

    static {
        zzby zzby = new zzby(new long[0], 0);
        zzkg = zzby;
        zzby.zzab();
    }

    public zzby() {
        this(new long[10], 0);
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    private final String zzg(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzl(int i11, long j11) {
        int i12;
        zzac();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        long[] jArr = this.zzkh;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzkh, i11, jArr2, i11 + 1, this.size - i11);
            this.zzkh = jArr2;
        }
        this.zzkh[i11] = j11;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzl(i11, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzby)) {
            return super.addAll(collection);
        }
        zzby zzby = (zzby) collection;
        int i11 = zzby.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.zzkh;
            if (i13 > jArr.length) {
                this.zzkh = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(zzby.zzkh, 0, this.zzkh, this.size, zzby.size);
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
        if (!(obj instanceof zzby)) {
            return super.equals(obj);
        }
        zzby zzby = (zzby) obj;
        if (this.size != zzby.size) {
            return false;
        }
        long[] jArr = zzby.zzkh;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzkh[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public final long getLong(int i11) {
        zzf(i11);
        return this.zzkh[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzbd.zzl(this.zzkh[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzac();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Long.valueOf(this.zzkh[i11]))) {
                long[] jArr = this.zzkh;
                System.arraycopy(jArr, i11 + 1, jArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzac();
        if (i12 >= i11) {
            long[] jArr = this.zzkh;
            System.arraycopy(jArr, i12, jArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzac();
        zzf(i11);
        long[] jArr = this.zzkh;
        long j11 = jArr[i11];
        jArr[i11] = longValue;
        return Long.valueOf(j11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= this.size) {
            return new zzby(Arrays.copyOf(this.zzkh, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzm(long j11) {
        zzl(this.size, j11);
    }

    private zzby(long[] jArr, int i11) {
        this.zzkh = jArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        zzf(i11);
        long[] jArr = this.zzkh;
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
