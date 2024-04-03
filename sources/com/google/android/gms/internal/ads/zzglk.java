package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzglk extends zzgio<Long> implements RandomAccess, zzgkt, zzgmc {
    private static final zzglk zza;
    private long[] zzb;
    private int zzc;

    static {
        zzglk zzglk = new zzglk(new long[0], 0);
        zza = zzglk;
        zzglk.zzb();
    }

    public zzglk() {
        this(new long[10], 0);
    }

    public static zzglk zzf() {
        return zza;
    }

    private final String zzh(int i11) {
        int i12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzi(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        long longValue = ((Long) obj).longValue();
        zzbU();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
        long[] jArr = this.zzb;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzb, i11, jArr2, i11 + 1, this.zzc - i11);
            this.zzb = jArr2;
        }
        this.zzb[i11] = longValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbU();
        zzgkv.zze(collection);
        if (!(collection instanceof zzglk)) {
            return super.addAll(collection);
        }
        zzglk zzglk = (zzglk) collection;
        int i11 = zzglk.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.zzb;
            if (i13 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(zzglk.zzb, 0, this.zzb, this.zzc, zzglk.zzc);
            this.zzc = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzglk)) {
            return super.equals(obj);
        }
        zzglk zzglk = (zzglk) obj;
        if (this.zzc != zzglk.zzc) {
            return false;
        }
        long[] jArr = zzglk.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzi(i11);
        return Long.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + zzgkv.zzc(this.zzb[i12]);
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == longValue) {
                return i12;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbU();
        zzi(i11);
        long[] jArr = this.zzb;
        long j11 = jArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Long.valueOf(j11);
    }

    public final void removeRange(int i11, int i12) {
        zzbU();
        if (i12 >= i11) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i12, jArr, i11, this.zzc - i12);
            this.zzc -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbU();
        zzi(i11);
        long[] jArr = this.zzb;
        long j11 = jArr[i11];
        jArr[i11] = longValue;
        return Long.valueOf(j11);
    }

    public final int size() {
        return this.zzc;
    }

    /* renamed from: zza */
    public final zzgkt zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzglk(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i11) {
        zzi(i11);
        return this.zzb[i11];
    }

    public final void zzg(long j11) {
        zzbU();
        int i11 = this.zzc;
        long[] jArr = this.zzb;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        jArr3[i12] = j11;
    }

    private zzglk(long[] jArr, int i11) {
        this.zzb = jArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
